/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Language;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class LanguageRepositoryImpl implements LanguageRepository {

	private static final Logger log = LoggerFactory.getLogger(LanguageRepositoryImpl.class);
	
	@Autowired
	private LanguageCrudRepository languageCrudRepository;
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.LanguageRepository#delete(gr.ekt.cerif.entities.second.Language)
	 */
	@Override
	@Transactional
	public void delete(Language entity) {
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

	@Override
	public List<Language> findAll() {
		return languageCrudRepository.findAll();
	}

	@Override
	public Page<Language> findAll(Pageable page) {
		return languageCrudRepository.findAll(page);
	}

	@Override
	public List<Language> findByUri(String uri) {
		return languageCrudRepository.findByUri(uri);
	}

	@Override
	public Language findByUuid(String uuid) {
		return languageCrudRepository.findByUuid(uuid);
	}

}
