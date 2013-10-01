
package gr.ekt.cerif.services.multilingual.classscheme;

import gr.ekt.cerif.features.multilingual.ClassSchemeName;


/**
 * A repository for ClassSchemeName.
 * 
 */
public interface ClassSchemeNameRepository {
	
	ClassSchemeName findByName(String name);
	
	public void delete(ClassSchemeName entity); 
	
	public void delete(Iterable<ClassSchemeName> entities); 

	public Iterable<ClassSchemeName> save(Iterable<ClassSchemeName> entities); 
	
	public ClassSchemeName save(ClassSchemeName entity);
	
}
