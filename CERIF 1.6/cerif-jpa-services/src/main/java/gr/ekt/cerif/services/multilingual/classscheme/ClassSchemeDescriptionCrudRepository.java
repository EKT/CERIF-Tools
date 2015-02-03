/**
 * 
 */
package gr.ekt.cerif.services.multilingual.classscheme;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;


/**
 * A repository for class scheme descriptions.
 * 
 */
public interface ClassSchemeDescriptionCrudRepository extends CrudRepository<ClassSchemeDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassSchemeDescription> findByScheme(ClassScheme scheme);

}
