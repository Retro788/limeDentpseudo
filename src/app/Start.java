package app;


import javax.swing.SwingUtilities;

import model.DatabaseConnectionThread;
import view.ViewLogin;



public class Start {
	
    /**
     * Punto de entrada de la aplicación. Inicializa la ventana de
     * autenticación y arranca el hilo que mantiene la conexión con la base de
     * datos.
     *
     * @param args argumentos de línea de comandos
     */
	public static void main( String[] args ) {
		
        /**
         * Abre la ventana de inicio de sesión utilizando SwingUtilities.invokeLater
         * para garantizar que se ejecute en el hilo de eventos de Swing.
         */
		SwingUtilities.invokeLater( () -> {
			
			ViewLogin viewLogin = new ViewLogin();
			viewLogin.setVisible( true );
			
		} );
		
        /**
         * Inicia el hilo de conexión a la base de datos.
         */
		DatabaseConnectionThread databaseConnectionThread = new DatabaseConnectionThread();
		databaseConnectionThread.start();
		
	}
	
}
