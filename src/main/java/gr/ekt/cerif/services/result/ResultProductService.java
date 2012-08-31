/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 */
public interface ResultProductService extends CrudRepository<ResultProduct, Long> {
	
	ResultProduct findByUri(String uri);

}
