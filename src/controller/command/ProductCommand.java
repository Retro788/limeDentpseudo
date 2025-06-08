package controller.command;


import model.Product;


public interface ProductCommand {
	
	/**
	 * Executes the command.
	 */
	void execute();
	
	/**
	 * Undoes the command.
	 */
	void undo();
	
	/**
	 *
	 * Returns a String containing information about the Product object associated
	 * with this command.
	 *
	 * @return a String containing the product information
	 */
	String getProductInfo();
	
	/**
	 *
	 * Returns the Product object associated with this command.
	 *
	 * @return the Product object
	 */
	Product getProduct();
	
}
