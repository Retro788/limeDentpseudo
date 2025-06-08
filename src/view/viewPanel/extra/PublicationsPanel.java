package view.viewPanel.extra;

import java.util.List;
import javax.swing.JOptionPane;
import dao.extra.PublicationDAO;
import model.extra.Publication;
import java.math.BigDecimal;

/**
 * Reporte de publicaciones.
 */
public class PublicationsPanel extends SimpleReportPanel<Publication> {
    private static final long serialVersionUID = 1L;
    private final PublicationDAO dao = new PublicationDAO();

    public PublicationsPanel() {
        super("Reporte de Publicaciones", new String[]{"ID","Práctica","Cuota","Detalle"});
        refreshTable();
    }

    @Override
    protected List<Publication> fetchData() {
        return dao.getAll();
    }

    @Override
    protected void addRecord() {
        try {
            String practica = JOptionPane.showInputDialog(this, "ID Práctica:");
            String cuota = JOptionPane.showInputDialog(this, "Cuota:");
            String detalle = JOptionPane.showInputDialog(this, "Detalle:");
            if(practica!=null) {
                Publication p = new Publication(null, Integer.parseInt(practica), new BigDecimal(cuota), detalle);
                dao.add(p);
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
    protected Object[] toRow(Publication item) {
        return new Object[]{item.getId(), item.getPracticaId(), item.getCuota(), item.getDetalle()};
    }
}
