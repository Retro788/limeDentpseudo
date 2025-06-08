package view.viewPanel.extra;

import view.viewPanel.CardPanel;
import view.viewPanel.HomePanel;
import view.View;

/**
 * Panel de publicaciones que reutiliza la interfaz de pacientes
 * para ilustrar su funcionamiento.
 */
public class PublicationsPanel extends HomePanel {
    private static final long serialVersionUID = 1L;

    public PublicationsPanel(CardPanel cardParent, View view) {
        super(cardParent, view);
    }
}
