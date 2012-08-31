/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**
 * A repository for links between facilities and classes.
 * 
 */

public interface ClassRepository extends CrudRepository<Class, Long> {
	Class findById(Long id);
    Class findByUri(String uri);
	List<Class> findByScheme(ClassScheme scheme);		
}
