/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.Language;

/**
 * @author bonisv
 *
 */
public interface LanguageRepository {

	void delete(Language entity); 
	
	void delete(Iterable<Language> entities); 

	Iterable<Language> save(Iterable<Language> entities); 
	
	Language save(Language entity);
	
	Language findByCode(String code);
	
	List<Language> findAll();
	
	Page<Language> findAll(Pageable page);

	List<Language> findByUri(String uri);

	Language findByUuid(String uuid);
}
