
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.repository.CrudRepository;


/**
 * A repository for ClassTerm.
 * 
 */
public interface ClassTermRepository extends CrudRepository<ClassTerm, Long> {
	
	ClassTerm findByTerm(String term);
	
	ClassTerm findByTheClass(Class existInfras);
}
