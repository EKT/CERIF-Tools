/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultProduct;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 */
public interface ResultProductService extends JpaRepository<ResultProduct, Long> {
	
	ResultProduct findByUri(String uri);

}
