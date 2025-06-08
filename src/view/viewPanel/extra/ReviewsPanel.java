package view.viewPanel.extra;

import java.util.List;
import javax.swing.JOptionPane;
import dao.extra.ReviewDAO;
import model.extra.Review;

/**
 * Reporte de calificaciones.
 */
public class ReviewsPanel extends SimpleReportPanel<Review> {
    private static final long serialVersionUID = 1L;
    private final ReviewDAO dao = new ReviewDAO();

    public ReviewsPanel() {
        super("Reporte de Calificaciones", new String[]{"ID","Cita","Paciente","Calificación","Comentario"});
        refreshTable();
    }

    @Override
    protected List<Review> fetchData() {
        return dao.getAll();
    }

    @Override
    protected void addRecord() {
        try {
            String cita = JOptionPane.showInputDialog(this, "ID Cita:");
            String paciente = JOptionPane.showInputDialog(this, "ID Paciente:");
            String calif = JOptionPane.showInputDialog(this, "Calificación (1-5):");
            String comm = JOptionPane.showInputDialog(this, "Comentario:");
            if(cita!=null) {
                Review r = new Review(null, Integer.parseInt(cita), Integer.parseInt(paciente), Integer.parseInt(calif), comm);
                dao.add(r);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos");
        }
    }

    @Override
    protected void deleteRecord(int id) {
        dao.delete(id);
    }

    @Override
    protected Object[] toRow(Review item) {
        return new Object[]{item.getId(), item.getCitaId(), item.getPacienteId(), item.getCalificacion(), item.getComentario()};
    }
}
