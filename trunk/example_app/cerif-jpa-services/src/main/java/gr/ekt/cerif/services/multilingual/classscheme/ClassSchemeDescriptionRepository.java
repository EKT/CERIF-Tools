/**
 * 
 */
package gr.ekt.cerif.services.multilingual.classscheme;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;

/**
 * @author bonisv
 *
 */
public interface ClassSchemeDescriptionRepository {
	
	public void delete(ClassSchemeDescription entity); 
	
	public void delete(Iterable<ClassSchemeDescription> entities); 

	public Iterable<ClassSchemeDescription> save(Iterable<ClassSchemeDescription> entities); 
	
	public ClassSchemeDescription save(ClassSchemeDescription entity);

}
