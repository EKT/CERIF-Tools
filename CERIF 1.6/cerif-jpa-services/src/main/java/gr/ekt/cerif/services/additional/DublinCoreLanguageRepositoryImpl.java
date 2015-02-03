package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreLanguage;

@Component
public class DublinCoreLanguageRepositoryImpl implements
		DublinCoreLanguageRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreLanguageRepositoryImpl.class);
	
	@Autowired
	private DublinCoreLanguageCrudRepository dublinCoreLanguageCrudRepository;

	@Override
	public void delete(DublinCoreLanguage entity) {
		dublinCoreLanguageCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreLanguage> entities) {
		dublinCoreLanguageCrudRepository.save(entities);
	}

	@Override
	public Iterable<DublinCoreLanguage> save(
			Iterable<DublinCoreLanguage> entities) {
		return dublinCoreLanguageCrudRepository.save(entities);
	}

	@Override
	public DublinCoreLanguage save(DublinCoreLanguage entity) {
		return dublinCoreLanguageCrudRepository.save(entity);
	}

}
