/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * A repository for links between facilities and classes.
 * 
 */

public interface ClassRepository {

	Class findById(Long id);
    
	List<Class> findByUri(String uri);
	
	List<Class> findByUuid(String uuid);
	
	List<Class> findByScheme(ClassScheme scheme);
	
	void delete(Class entity);
	
	void delete(Iterable<Class> entityList);
	
	Iterable<Class> save(Iterable<Class> entityList);
	
	Class save(Class entity);
	
	Class findOne(Long id);
	
	List<Class> findAll();
	
	Page<Class> findAll(Pageable page);
	
	List<Class> findByUuidAndScheme(String uuid, ClassScheme scheme);
	
	Class findByUuidAndSchemeUuid(String uuid, String schemeUuid);
	
}
