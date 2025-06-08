package view.viewPanel.extra;

import java.util.List;
import javax.swing.JOptionPane;
import dao.extra.PracticeDAO;
import model.extra.Practice;

/**
 * Reporte de prácticas clínicas.
 */
public class PracticesPanel extends SimpleReportPanel<Practice> {
    private static final long serialVersionUID = 1L;
    private final PracticeDAO dao = new PracticeDAO();

    public PracticesPanel() {
        super("Reporte de Prácticas", new String[]{"ID","Practicante","Docente","Descripción"});
        refreshTable();
    }

    @Override
    protected List<Practice> fetchData() {
        return dao.getAll();
    }

    @Override
    protected void addRecord() {
        try {
            String pract = JOptionPane.showInputDialog(this, "ID Practicante:");
            String doc = JOptionPane.showInputDialog(this, "ID Docente:");
            String desc = JOptionPane.showInputDialog(this, "Descripción:");
            if(pract!=null) {
                Practice p = new Practice(null, Integer.parseInt(pract), Integer.parseInt(doc), desc);
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
    protected Object[] toRow(Practice item) {
        return new Object[]{item.getId(), item.getPracticanteId(), item.getDocenteId(), item.getDescripcion()};
    }
}
