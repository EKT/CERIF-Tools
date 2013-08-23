/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.features.multilingual.ClassEx;

/**
 * @author bonisv
 *
 */
public interface ClassExRepository {

	public void delete(ClassEx entity); 
	
	public void delete(Iterable<ClassEx> entities); 

	public Iterable<ClassEx> save(Iterable<ClassEx> entities); 
	
	public ClassEx save(ClassEx entity);
}
