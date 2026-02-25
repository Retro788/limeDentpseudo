package view.viewPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Locale;

import org.jdesktop.swingx.JXMonthView;

import design.panel.RoundedShadowPanel;
import view.View;

/**
 * Panel simple que muestra un calendario utilizando SwingX.
 */
public class CalendarPanel extends RoundedShadowPanel {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private CardPanel cardParent;
    @SuppressWarnings("unused")
    private View view;
    private JXMonthView monthView;

    public CalendarPanel(CardPanel cardParent, View view) {
        super(20);
        this.cardParent = cardParent;
        this.view = view;
        initComponents();
        initLayout();
    }

    private void initComponents() {
        monthView = new JXMonthView();
        monthView.setLocale(new Locale("es"));
        setBackground(new Color(244, 244, 249));
        setOpaque(false);
        setShadowOpacity(0.65f);
    }

    private void initLayout() {
        setLayout(new BorderLayout());
        add(monthView, BorderLayout.CENTER);
    }

    public void clearAll() {
        // No hay campos editables por ahora
    }
}
