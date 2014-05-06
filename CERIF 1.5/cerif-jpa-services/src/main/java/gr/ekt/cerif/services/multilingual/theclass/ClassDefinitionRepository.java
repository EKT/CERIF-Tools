/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.semantics.Class;

/**
 * @author bonisv
 *
 */
public interface ClassDefinitionRepository {

	public void delete(ClassDefinition entity); 
	
	public void delete(Iterable<ClassDefinition> entities); 

	public Iterable<ClassDefinition> save(Iterable<ClassDefinition> entities); 
	
	public ClassDefinition save(ClassDefinition entity);
	
	List<ClassDefinition> findByTheClass(Class theClass);
}
