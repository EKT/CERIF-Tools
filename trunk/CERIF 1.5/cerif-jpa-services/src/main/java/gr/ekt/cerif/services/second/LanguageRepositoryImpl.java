/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Language_Class;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.LanguageName;
import gr.ekt.cerif.services.link.language.LinkLanguageClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonLanguageRepository;
import gr.ekt.cerif.services.multilingual.language.LanguageNameRepository;

/**
 * @author bonisv
 *
 */
@Component
public class LanguageRepositoryImpl implements LanguageRepository {

	private static final Logger log = LoggerFactory.getLogger(LanguageRepositoryImpl.class);
	
	@Autowired
	private LanguageCrudRepository languageCrudRepository;
	
	@Autowired
	private LinkLanguageClassRepository linkLanguageClassRepository;
	
	@Autowired
	private LanguageNameRepository languageNameRepository;
	
	@Autowired
	private LinkPersonLanguageRepository linkPersonLanguageRepository;
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.LanguageRepository#delete(gr.ekt.cerif.entities.second.Language)
	 */
	@Override
	@Transactional
	public void delete(Language entity) {
		List<Language_Class> langcl = linkLanguageClassRepository.findByLanguage(entity);
		if (langcl != null) linkLanguageClassRepository.delete(langcl);
		entity.setLanguages_classes(null);
		
		List<LanguageName> langNameOf = languageNameRepository.findByLanguageOfName(entity);
		if (langNameOf != null) languageNameRepository.delete(langNameOf);
		entity.setLanguageNames(null);
		
		List<LanguageName> langName = languageNameRepository.findByLanguage(entity);
		if (langName != null) languageNameRepository.delete(langName);
		entity.setNames(null);
		
		List<Person_Language> persLang = linkPersonLanguageRepository.findByLanguage(entity);
		if (persLang != null) linkPersonLanguageRepository.delete(persLang);
		entity.setPersons_languages(null);
		
		entity = languageCrudRepository.save(entity);
		languageCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.LanguageRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Language> entities) {
		languageCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.LanguageRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Language> save(Iterable<Language> entities) {
		return languageCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.LanguageRepository#save(gr.ekt.cerif.entities.second.Language)
	 */
	@Override
	public Language save(Language entity) {
		return languageCrudRepository.save(entity);
	}

	@Override
	public Language findByCode(String code) {
		return languageCrudRepository.findByCode(code);
	}

}
