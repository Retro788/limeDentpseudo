package view.viewPanel.extra;

import view.viewPanel.CardPanel;
import view.viewPanel.HomePanel;
import view.View;

/**
 * Módulo funcional que reutiliza la lógica del listado de pacientes
 * para mostrar la información personal.
 */
public class PersonalInfoPanel extends HomePanel {
    private static final long serialVersionUID = 1L;

    public PersonalInfoPanel(CardPanel cardParent, View view) {
        super(cardParent, view);
    }
}
