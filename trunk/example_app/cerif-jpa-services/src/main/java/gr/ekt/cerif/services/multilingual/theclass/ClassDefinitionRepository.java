/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.features.multilingual.ClassDefinition;

/**
 * @author bonisv
 *
 */
public interface ClassDefinitionRepository {

	public void delete(ClassDefinition entity); 
	
	public void delete(Iterable<ClassDefinition> entities); 

	public Iterable<ClassDefinition> save(Iterable<ClassDefinition> entities); 
	
	public ClassDefinition save(ClassDefinition entity);
}
