/**
 * 
 */
package gr.ekt.cerif.services.result;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for products.
 * 
 */
public interface ResultProductRepository {

	public void delete(ResultProduct entity); 
	
	public void delete(Iterable<ResultProduct> entities); 

	public Iterable<ResultProduct> save(Iterable<ResultProduct> entities); 
	
	public ResultProduct save(ResultProduct entity);
	
	List<ResultProduct> findAll();
	
}
