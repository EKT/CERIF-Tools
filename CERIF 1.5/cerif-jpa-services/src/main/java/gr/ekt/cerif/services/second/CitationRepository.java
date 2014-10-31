package gr.ekt.cerif.services.second;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Citation;

/**
 * A repository for Citations.
 * @author bonisv
 *
 */
public interface CitationRepository {

	void delete(Citation entity); 
	
	void delete(Iterable<Citation> entities); 

	Iterable<Citation> save(Iterable<Citation> entities); 
	
	Citation save(Citation entity);
	
	List<Citation> findAll();
	
	Page<Citation> findAll(Pageable page);

	Citation findById(Long id);

	List<Citation> findByUri(String uri);

	Citation findByUuid(String uuid);
}
