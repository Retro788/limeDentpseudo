package view.viewPanel.extra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import design.button.ButtonShadow;
import design.panel.RoundedShadowPanel;

/**
 * Simple panel to show database records in a table with Add/Delete actions.
 */
public abstract class SimpleReportPanel<T> extends RoundedShadowPanel {
    private static final long serialVersionUID = 1L;
    protected DefaultTableModel model;
    protected JTable table;

    public SimpleReportPanel(String title, String[] columns) {
        super(20);
        setOpaque(false);
        setBackground(new Color(244, 244, 249));
        setLayout(new BorderLayout(10,10));

        JLabel lbl = new JLabel(title);
        lbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbl, BorderLayout.NORTH);

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel actions = new JPanel();
        actions.setOpaque(false);
        ButtonShadow addBtn = new ButtonShadow();
        addBtn.setText("Agregar");
        addBtn.addActionListener(e -> onAdd());
        ButtonShadow delBtn = new ButtonShadow();
        delBtn.setText("Eliminar");
        delBtn.addActionListener(e -> onDelete());
        actions.add(addBtn);
        actions.add(delBtn);
        add(actions, BorderLayout.SOUTH);
    }

    protected abstract List<T> fetchData();
    protected abstract void addRecord();
    protected abstract void deleteRecord(int rowId);

    protected void onAdd() {
        addRecord();
        refreshTable();
    }

    protected void onDelete() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Object idVal = model.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar registro?" , "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteRecord(Integer.parseInt(idVal.toString()));
                refreshTable();
            }
        }
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (T item : fetchData()) {
            Object[] row = toRow(item);
            model.addRow(row);
        }
    }

    public void clearAll() {
        refreshTable();
    }

    protected abstract Object[] toRow(T item);
}
