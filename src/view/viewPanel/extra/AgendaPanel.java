package view.viewPanel.extra;

import view.viewPanel.CardPanel;
import view.viewPanel.HomePanel;
import view.View;

/**
 * Panel Agenda que aprovecha la lógica de pacientes para poder
 * registrar y listar elementos.
 */
public class AgendaPanel extends HomePanel {
    private static final long serialVersionUID = 1L;

    public AgendaPanel(CardPanel cardParent, View view) {
        super(cardParent, view);
    }
}
