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

	ResultProduct findById(Long id);
	
	void delete(ResultProduct entity); 
	
	void delete(Iterable<ResultProduct> entities); 

	Iterable<ResultProduct> save(Iterable<ResultProduct> entities); 
	
	ResultProduct save(ResultProduct entity);
	
	List<ResultProduct> findAll();
	
	Page<ResultProduct> findAll(Pageable page);
	
	ResultProduct findByUuid(String uuid);
	
	List<ResultProduct> findByUri(String uri);
	
}
