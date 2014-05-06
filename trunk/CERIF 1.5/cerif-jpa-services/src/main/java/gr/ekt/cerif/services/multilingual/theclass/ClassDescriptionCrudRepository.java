/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ClassDescriptionCrudRepository extends CrudRepository<ClassDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassDescription> findByTheClass(Class theClass);

}
