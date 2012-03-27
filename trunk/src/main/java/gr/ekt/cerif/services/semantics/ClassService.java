/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 */
public interface ClassService extends CrudRepository<gr.ekt.cerif.features.semantics.Class, Long> {
	
	gr.ekt.cerif.features.semantics.Class findByUri(String uri);

}
