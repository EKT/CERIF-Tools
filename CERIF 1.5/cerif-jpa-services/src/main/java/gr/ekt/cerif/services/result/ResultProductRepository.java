/**
 * 
 */
package gr.ekt.cerif.services.result;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for products.
 * 
 */
public interface ResultProductRepository {

	public ResultProduct findById(Long id);
	
	public void delete(ResultProduct entity); 
	
	public void delete(Iterable<ResultProduct> entities); 

	public Iterable<ResultProduct> save(Iterable<ResultProduct> entities); 
	
	public ResultProduct save(ResultProduct entity);
	
	List<ResultProduct> findAll();
	
	Page<ResultProduct> findAll(Pageable page);
	
	ResultProduct findByUUID(String uuid);
	
}
