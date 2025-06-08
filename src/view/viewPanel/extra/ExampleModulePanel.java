package view.viewPanel.extra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import design.panel.RoundedShadowPanel;
import design.button.ButtonShadow;
import javax.swing.JPanel;

/**
 * Panel de ejemplo para módulos en construcción.
 * Muestra una tabla vacía y botones "Agregar" y "Eliminar" para simular una interfaz.
 */
public class ExampleModulePanel extends RoundedShadowPanel {
    private static final long serialVersionUID = 1L;

    public ExampleModulePanel(String titulo) {
        super(20);
        setOpaque(false);
        setBackground(new Color(244, 244, 249));
        setLayout(new BorderLayout(10,10));

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbl, BorderLayout.NORTH);

        String[] cols = {"Columna 1", "Columna 2", "Columna 3"};
        JTable tabla = new JTable(new Object[][]{}, cols);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel acciones = new JPanel();
        acciones.setOpaque(false);
        ButtonShadow btnAdd = new ButtonShadow();
        btnAdd.setText("Agregar");
        ButtonShadow btnRemove = new ButtonShadow();
        btnRemove.setText("Eliminar");
        acciones.add(btnAdd);
        acciones.add(btnRemove);
        add(acciones, BorderLayout.SOUTH);
    }

    public void clearAll() {}
}
