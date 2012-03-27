/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 */
public interface ClassSchemeService extends CrudRepository<ClassScheme, Long> {
	
	ClassScheme findByUri(String uri);

}
