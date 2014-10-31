/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.features.semantics.ClassScheme;


public interface ClassSchemeRepository {
	
	ClassScheme findById(Long id);
	
	ClassScheme findByUri(String uri);
	
	List<ClassScheme> findAll();

	Page<ClassScheme> findAll(Pageable page);
	
	ClassScheme findByUuid(String uuid);
	
	ClassScheme save(ClassScheme entity);

	Iterable<ClassScheme> save(Iterable<ClassScheme> entities);
	
	void delete(ClassScheme entity);
	
	void delete(Iterable<ClassScheme> entities);
	
}
