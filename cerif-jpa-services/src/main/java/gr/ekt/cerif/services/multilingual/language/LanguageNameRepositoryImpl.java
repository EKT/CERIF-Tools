/**
 * 
 */
package gr.ekt.cerif.services.multilingual.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.LanguageName;

/**
 * @author bonisv
 *
 */
@Component
public class LanguageNameRepositoryImpl implements LanguageNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LanguageNameRepositoryImpl.class);
	
	@Autowired
	private LanguageNameCrudRepository languageNameCrudRepository;

	@Override
	public void delete(LanguageName entity) {
		languageNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<LanguageName> entities) {
		languageNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<LanguageName> save(Iterable<LanguageName> entities) {
		return languageNameCrudRepository.save(entities);
	}

	@Override
	public LanguageName save(LanguageName entity) {
		return languageNameCrudRepository.save(entity);
	}

}
