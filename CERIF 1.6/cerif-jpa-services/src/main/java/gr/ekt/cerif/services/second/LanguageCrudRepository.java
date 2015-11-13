/**
 * 
 */
package gr.ekt.cerif.services.second;


import gr.ekt.cerif.entities.second.Language;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface LanguageCrudRepository extends CrudRepository<Language, String> {
	
	public Language findByCode(String code);
	
	public List<Language> findAll();
	
	public Page<Language> findAll(Pageable page);

	public List<Language> findByUri(String uri);

	public Language findByUuid(String uuid);
	
}
