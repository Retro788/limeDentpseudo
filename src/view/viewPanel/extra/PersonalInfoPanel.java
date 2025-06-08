package view.viewPanel.extra;

import java.util.List;
import javax.swing.JOptionPane;
import dao.extra.PersonalInfoDAO;
import model.extra.PersonalInfo;

/**
 * Reporte de información personal.
 */
public class PersonalInfoPanel extends SimpleReportPanel<PersonalInfo> {
    private static final long serialVersionUID = 1L;
    private final PersonalInfoDAO dao = new PersonalInfoDAO();

    public PersonalInfoPanel() {
        super("Reporte Información Personal", new String[]{"ID","Usuario","Rol","Nombre","Apellido","Teléfono","Email"});
        refreshTable();
    }

    @Override
    protected List<PersonalInfo> fetchData() {
        return dao.getAll();
    }

    @Override
    protected void addRecord() {
        try {
            String user = JOptionPane.showInputDialog(this, "ID de usuario:");
            String rol = JOptionPane.showInputDialog(this, "Rol:");
            String nombre = JOptionPane.showInputDialog(this, "Nombre:");
            String apellido = JOptionPane.showInputDialog(this, "Apellido:");
            String tel = JOptionPane.showInputDialog(this, "Teléfono:");
            String mail = JOptionPane.showInputDialog(this, "Email:");
            if(user!=null) {
                PersonalInfo p = new PersonalInfo(null, Integer.parseInt(user), rol, nombre, apellido, tel, mail);
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
    protected Object[] toRow(PersonalInfo item) {
        return new Object[]{item.getId(), item.getUserId(), item.getRol(), item.getNombre(), item.getApellido(), item.getTelefono(), item.getEmail()};
    }
}
