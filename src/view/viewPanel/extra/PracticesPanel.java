package view.viewPanel.extra;

import view.viewPanel.CardPanel;
import view.viewPanel.HomePanel;
import view.View;

/**
 * Panel de prácticas reutilizando el listado de pacientes como base
 * para permitir agregar y eliminar registros.
 */
public class PracticesPanel extends HomePanel {
    private static final long serialVersionUID = 1L;

    public PracticesPanel(CardPanel cardParent, View view) {
        super(cardParent, view);
    }
}
