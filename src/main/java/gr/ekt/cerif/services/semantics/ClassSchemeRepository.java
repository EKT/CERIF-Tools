/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;


public interface ClassSchemeRepository {
	
	ClassScheme findByUri(String uri);
	
	public ClassScheme save(ClassScheme entity);

	public Iterable<? extends ClassScheme> save(Iterable<? extends ClassScheme> entities);
	
	public void delete(ClassScheme entity);
	
}
