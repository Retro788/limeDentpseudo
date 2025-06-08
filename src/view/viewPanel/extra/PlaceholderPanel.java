package view.viewPanel.extra;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import design.panel.RoundedShadowPanel;
import view.View;
import view.viewPanel.CardPanel;

public class PlaceholderPanel extends RoundedShadowPanel {
    private static final long serialVersionUID = 1L;

    public PlaceholderPanel(String text) {
        super(20);
        setBackground(new Color(244,244,249));
        setLayout(new BorderLayout());
        JLabel lbl = new JLabel(text);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbl, BorderLayout.CENTER);
    }

    public void clearAll() {}
}
