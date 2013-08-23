/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.features.multilingual.ClassDescription;

/**
 * @author bonisv
 *
 */
public interface ClassDescriptionRepository {

	public void delete(ClassDescription entity); 
	
	public void delete(Iterable<ClassDescription> entities); 

	public Iterable<ClassDescription> save(Iterable<ClassDescription> entities); 
	
	public ClassDescription save(ClassDescription entity);
}
