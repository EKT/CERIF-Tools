/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.CV;

/**
 * A repository for cvs.
 * 
 */
public interface CVRepository {
	
	CV findById(Long id);
	
	List<CV> findAll();
	
	Page<CV> findAll(Pageable page);

	List<CV> findByUri(String uri);

	CV findByUuid(String uuid);
	
	void delete(CV entity); 
	
	void delete(Iterable<CV> entities); 

	Iterable<CV> save(Iterable<CV> entities); 
	
	CV save(CV entity);

}
