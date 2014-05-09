/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.features.semantics.ClassScheme;


public interface ClassSchemeRepository {
	
	ClassScheme findByUri(String uri);
	
	List<ClassScheme> findAll();

	Page<ClassScheme> findAll(Pageable page);
	
	ClassScheme findByUuid(String uuid);
	
	public ClassScheme save(ClassScheme entity);

	public Iterable<ClassScheme> save(Iterable<ClassScheme> entities);
	
	public void delete(ClassScheme entity);
	
	public void delete(Iterable<ClassScheme> entities);
	
}
