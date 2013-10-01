/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;


public interface ClassSchemeRepository {
	
	ClassScheme findByUri(String uri);
	
	public ClassScheme save(ClassScheme entity);

	public Iterable<ClassScheme> save(Iterable<ClassScheme> entities);
	
	public void delete(ClassScheme entity);
	
	public void delete(Iterable<ClassScheme> entities);
	
}
