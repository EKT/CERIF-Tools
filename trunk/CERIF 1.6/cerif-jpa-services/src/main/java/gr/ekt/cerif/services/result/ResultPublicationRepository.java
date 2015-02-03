/**
 * 
 */
package gr.ekt.cerif.services.result;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.result.ResultPublication;

/**
 * A repository for publications.
 * 
 */
public interface ResultPublicationRepository {

	ResultPublication findByUri(String uri);
	
	ResultPublication findById(Long id);

	void delete(ResultPublication entity); 
	
	void delete(Iterable<ResultPublication> entities); 

	Iterable<ResultPublication> save(Iterable<ResultPublication> entities); 
	
	ResultPublication save(ResultPublication entity);
	
	List<ResultPublication> findAll();
	
	Page<ResultPublication> findAll(Pageable page);
	
	ResultPublication findByUuid(String uuid);
}
