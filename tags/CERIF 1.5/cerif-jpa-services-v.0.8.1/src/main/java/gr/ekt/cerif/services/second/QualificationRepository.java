/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Qualification;

/**
 * @author bonisv
 *
 */
public interface QualificationRepository {

	void delete(Qualification entity); 
	
	void delete(Iterable<Qualification> entities); 

	Iterable<Qualification> save(Iterable<Qualification> entities); 
	
	Qualification save(Qualification entity);
	
	List<Qualification> findAll();
	
	Page<Qualification> findAll(Pageable page);

	Qualification findById(Long id);

	List<Qualification> findByUri(String uri);

	Qualification findByUuid(String uuid);
}
