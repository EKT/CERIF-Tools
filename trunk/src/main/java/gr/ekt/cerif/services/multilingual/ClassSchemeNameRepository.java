
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ClassSchemeName;


/**
 * A repository for ClassSchemeName.
 * 
 */
public interface ClassSchemeNameRepository {
	
	ClassSchemeName findByName(String name);
	
	ClassSchemeName save(ClassSchemeName entity);
	
	Iterable<? extends ClassSchemeName> save(Iterable<? extends ClassSchemeName> entities);
	
	void delete(ClassSchemeName entity);
	
}
