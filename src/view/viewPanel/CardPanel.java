package view.viewPanel;


import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.border.MatteBorder;

import controller.LoginController;
import design.panel.RoundedPanel;
import design.scroll.ScrollBarCustom;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import view.View;



public class CardPanel extends RoundedPanel {
	
	private static final long serialVersionUID = -1680729189874995548L;
	private View view;
	private CardLayout cl;
        private HomePanel homePanel;
        private ProductsPanel uslugePanel;
        private OffersPanel ponudePanel;
        private NewOfferPanel novaPonudaPanel;
        private CalendarPanel calendarPanel;
        private UserSettingsPanel userSettingsPanel;
        private NewMedicalExamPanel noviPregledPanel;
        private PatientDetailsPanel detaljiPanel;
        private NewPatientPanel noviPacijentPanel;
        private JScrollPane homeScroll;
        private JScrollPane uslugeScroll;
        private JScrollPane ponudeScroll;
        private JScrollPane novaPonudaScroll;
        private JScrollPane calendarScroll;
        private JScrollPane userSettingsScroll;
        private JScrollPane noviPregledScroll;
        private JScrollPane detaljiScroll;
        private JScrollPane noviPacijentScroll;
        @SuppressWarnings( "unused" )
        private LoginController loginController;
	
	/**
	 *
	 * Constructs a new CardPanel object with the specified View / JFrame object.
	 * Initializes the CardLayout object and sets the background, foreground,
	 * opacity, and border of the panel.
	 *
	 * @param view the View object to use
	 */
	public CardPanel( View view ) {
		
		super( 20 );
		
		this.view = view;
		this.cl = new CardLayout();
		setLayout( cl );
		
		setBackground( Color.white );
		setForeground( Color.white );
		setOpaque( false );
		setBorder( new MatteBorder( 1 , 1 , 1 , 1 , Color.white ) );
		initComponents();
		initLayout();
		
	}
	
	
	/**
	 *
	 * Initializes the HomePanel, UslugePanel, PonudePanel, NovaPonudaPanel,
	 * UserSettingsPanel, NoviPregledPanel, DetaljiPanel, and NoviPacijentPanel
	 * objects and sets them to their corresponding variables.
	 */
	private void initComponents() {
		
                homePanel = new HomePanel( this , view );
                uslugePanel = new ProductsPanel( this , view );
                ponudePanel = new OffersPanel( this , view );
                novaPonudaPanel = new NewOfferPanel( this , view );
                calendarPanel = new CalendarPanel( this , view );
                userSettingsPanel = new UserSettingsPanel( this , view );
                userSettingsPanel.setBackground( new Color( 255 , 255 , 255 ) );
                userSettingsPanel.setShadowColor( new Color( 255 , 255 , 255 ) );
                noviPregledPanel = new NewMedicalExamPanel( this , view );
                homePanel.setNoviPregledPanel( noviPregledPanel );
                detaljiPanel = new PatientDetailsPanel( this , view );
                homePanel.setDetaljiPanel( detaljiPanel );
                noviPacijentPanel = new NewPatientPanel( this , view );

                homeScroll = createScrollPane( homePanel );
                uslugeScroll = createScrollPane( uslugePanel );
                ponudeScroll = createScrollPane( ponudePanel );
                novaPonudaScroll = createScrollPane( novaPonudaPanel );
                calendarScroll = createScrollPane( calendarPanel );
                userSettingsScroll = createScrollPane( userSettingsPanel );
                noviPregledScroll = createScrollPane( noviPregledPanel );
                detaljiScroll = createScrollPane( detaljiPanel );
                noviPacijentScroll = createScrollPane( noviPacijentPanel );
		
	}
	
	
	/**
	 *
	 * Adds the HomePanel, UslugePanel, PonudePanel, NovaPonudaPanel,
	 * UserSettingsPanel, NoviPregledPanel, DetaljiPanel, and NoviPacijentPanel
	 * objects to the CardLayout object with their corresponding names.
	 */
	private void initLayout() {
		
                add( homeScroll , "homePanel" );
                add( uslugeScroll , "uslugePanel" );
                add( ponudeScroll , "ponudePanel" );
                add( novaPonudaScroll , "novaPonudaPanel" );
                add( calendarScroll , "calendarPanel" );
                add( userSettingsScroll , "userSettingsPanel" );
                add( noviPregledScroll , "noviPregledPanel" );
                add( detaljiScroll , "detaljiPanel" );
                add( noviPacijentScroll , "noviPacijentPanel" );
		
	}
	
	
	/**
	 *
	 * Show the specified card by using CardLayout.
	 *
	 * @param card the card to be shown
	 */
	public void showCard( String card ) {
		
		cl.show( this , card );
		clearCard( card );
		
	}
	
	
	/**
	 *
	 * Clear all input fields and reset the state of the specified panel to its
	 * initial state.
	 *
	 * @param card the card whose panel is to be cleared
	 */
	public void clearCard( String card ) {
		
		switch (card) {
			
			case "homePanel":
				homePanel.clearAll();
				break;
			
			case "uslugePanel":
				uslugePanel.clearAll();
				break;
			
			case "ponudePanel":
				ponudePanel.clearAll();
				break;
			
                        case "novaPonudaPanel":
                                novaPonudaPanel.clearAll();
                                break;

                        case "calendarPanel":
                                calendarPanel.clearAll();
                                break;
			
			case "noviPacijentPanel":
				noviPacijentPanel.clearAll();
				break;
			
		}
		
	}
	
	
	/**
	 *
	 * Clear all input fields and reset the state of the homePanel to its initial
	 * state.
	 */
	public void clearHomePanel() {
		
		homePanel.clearAll();
		
	}
	
	
	/**
	 *
	 * Clear all input fields and reset the state of the uslugePanel to its initial
	 * state.
	 */
	public void clearUslugePanel() {
		
		uslugePanel.clearAll();
		
	}
	
	
	/**
	 *
	 * Clear all input fields and reset the state of the ponudePanel to its initial
	 * state.
	 */
	public void clearPonudePanel() {
		
		ponudePanel.clearAll();
		
	}
	
	
	/**
	 *
	 * Clear all input fields and reset the state of the novaPonudaPanel to its
	 * initial state.
	 */
	public void clearNovaPonudaPanel() {
		
		novaPonudaPanel.clearAll();
		
	}
	
	
	/**
	 *
	 * Get the CardLayout object used by this panel.
	 *
	 * @return the CardLayout object used by this panel
	 */
	public CardLayout getCardLayout() {
		
		return cl;
		
	}
	
	
	/**
	 *
	 * Set the LoginController object to be used by this panel and its child
	 * components.
	 *
	 * @param loginController the LoginController object to be set
	 */
	public void setLoginController( LoginController loginController ) {
		
		this.loginController = loginController;
		userSettingsPanel.setLoginController( loginController );
		noviPregledPanel.setLoginController( loginController );
		novaPonudaPanel.setLoginController( loginController );
		
	}
	
	
	/**
	 *
	 * Get the UserSettingsPanel object used by this panel.
	 *
	 * @return the UserSettingsPanel object used by this panel
	 */
        public UserSettingsPanel getUserSettingsPanel() {

                return userSettingsPanel;

        }

       private JScrollPane createScrollPane( java.awt.Component comp ) {
               JScrollPane sp = new JScrollPane( comp );
               ScrollBarCustom sc = new ScrollBarCustom( 80 );
               sc.setUnitIncrement( 5 );
               sp.setVerticalScrollBar( sc );
               sp.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
               sp.setBorder( null );
               sp.getViewport().setBackground( Color.white );
               return sp;
       }
	
}
