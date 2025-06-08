package view.viewPanel.extra;

import java.util.List;
import javax.swing.JOptionPane;
import dao.extra.AppointmentDAO;
import model.extra.Appointment;
import java.time.LocalDateTime;

/**
 * Reporte de agenda de citas.
 */
public class AgendaPanel extends SimpleReportPanel<Appointment> {
    private static final long serialVersionUID = 1L;
    private final AppointmentDAO dao = new AppointmentDAO();

    public AgendaPanel() {
        super("Reporte de Citas", new String[]{"ID","Publicación","Paciente","Fecha"});
        refreshTable();
    }

    @Override
    protected List<Appointment> fetchData() {
        return dao.getAll();
    }

    @Override
    protected void addRecord() {
        try {
            String pub = JOptionPane.showInputDialog(this, "ID Publicación:");
            String paciente = JOptionPane.showInputDialog(this, "ID Paciente:");
            String fecha = JOptionPane.showInputDialog(this, "Fecha (YYYY-MM-DD HH:MM:SS):");
            if(pub!=null) {
                LocalDateTime dt = LocalDateTime.parse(fecha.replace(' ', 'T'));
                Appointment a = new Appointment(null, Integer.parseInt(pub), Integer.parseInt(paciente), dt);
                dao.add(a);
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
    protected Object[] toRow(Appointment item) {
        return new Object[]{item.getId(), item.getPublicacionId(), item.getPacienteId(), item.getFecha()};
    }
}
