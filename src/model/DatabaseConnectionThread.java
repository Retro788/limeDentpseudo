package model;


import java.sql.SQLException;



public class DatabaseConnectionThread extends Thread {
	
	private final static int SLEEP_TIME = 15 * 1000;
	private boolean running;
	private Database database;
	
	/**
	 *
	 * Constructor that initializes the instance variables
	 */
	public DatabaseConnectionThread() {
		
		running = true;
		database = Database.getDatabase();
		
	}
	
	
	/**
	 *
	 * Sets the running to false, which will cause the thread to stop running
	 */
	public void stopThread() {
		
		running = false;
		
	}
	
	
	/**
	 *
	 * The run() method is called when the thread is started, and it contains the
	 * logic for checking the database connection status and attempting to reconnect
	 * if necessary.
	 */
	@SuppressWarnings( "static-access" )
	@Override
	public void run() {
		
		Thread.currentThread().setName( "Database Connection Thread" );
		
		while ( running ) {
			
			try {
				
				if ( database.getConnection().isClosed() ) {
					
					System.out.println( "Database disconnected...Trying to connect again" );
					Database.connect();
					
				} else {
					
					System.out.println( "Database connected...Running on thread " + Thread.currentThread().getName() );
					
				}
				
				Thread.sleep( SLEEP_TIME );
				
			} catch ( InterruptedException | SQLException e ) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}
