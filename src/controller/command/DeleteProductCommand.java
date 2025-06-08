package controller.command;


import dao.ProductDAO;
import model.Product;



public class DeleteProductCommand implements ProductCommand {
	
	private Product product;
	private ProductDAO productDAO;
	
	/**
	 *
	 * Constructs a new DeleteProductCommand object with the given Product and
	 * initializes the ProductDAO.
	 *
	 * @param product the Product object to be deleted
	 */
	public DeleteProductCommand( Product product ) {
		
		this.product = product;
		this.productDAO = new ProductDAO();
		
	}
	
	
	/**
	 *
	 * Returns a String containing the name of the Product object to be deleted.
	 *
	 * @return the name of the Product object
	 */
	@Override
	public String getProductInfo() {
		
		return product.getName();
		
	}
	
	
	/**
	 *
	 * Deletes the Product object from the database and prints its information to
	 * the console.
	 */
	@Override
	public void execute() {
		
		System.out.println(
				"Product Info Execute: " + product.getId() + " - " + product.getName() + " - " + product.getPrice() );
		productDAO.deleteProduct( product );
		
	}
	
	
	/**
	 *
	 * Adds the previously deleted Product object back to the database and prints
	 * its information to the console.
	 */
	@Override
	public void undo() {
		
		System.out.println(
				"Product Info undo: " + product.getId() + " - " + product.getName() + " - " + product.getPrice() );
		productDAO.addProduct( product );
		
	}
	
	
	/**
	 *
	 * Returns the Product object associated with this DeleteProductCommand.
	 *
	 * @return the Product object to be deleted
	 */
	@Override
	public Product getProduct() {
		
		return product;
		
	}
	
}
