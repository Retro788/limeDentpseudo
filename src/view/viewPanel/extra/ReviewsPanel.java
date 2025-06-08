package view.viewPanel.extra;

import view.viewPanel.CardPanel;
import view.viewPanel.HomePanel;
import view.View;

/**
 * Panel de reseñas que reutiliza la funcionalidad de pacientes
 * para permitir agregar y mostrar información.
 */
public class ReviewsPanel extends HomePanel {
    private static final long serialVersionUID = 1L;

    public ReviewsPanel(CardPanel cardParent, View view) {
        super(cardParent, view);
    }
}
