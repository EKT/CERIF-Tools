/**
 * 
 */
package gr.ekt.cerif.services.multilingual.classscheme;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**
 * A repository for class scheme descriptions.
 * 
 */
public interface ClassSchemeDescriptionCrudRepository extends CrudRepository<ClassSchemeDescription, Long> {
	
	List<ClassSchemeDescription> findByScheme(ClassScheme scheme);

}
