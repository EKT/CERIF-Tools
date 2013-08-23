package gr.ekt.cerif.services.link.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Language_Class;

@Component
public class LinkLanguageClassRepositoryImpl implements
		LinkLanguageClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkLanguageClassRepositoryImpl.class);
	
	@Autowired
	private LinkLanguageClassCrudRepository linkLanguageClassCrudRepository;

	@Override
	public void delete(Language_Class entity) {
		linkLanguageClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Language_Class> entities) {
		linkLanguageClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Language_Class> save(Iterable<Language_Class> entities) {
		return linkLanguageClassCrudRepository.save(entities);
	}

	@Override
	public Language_Class save(Language_Class entity) {
		return linkLanguageClassCrudRepository.save(entity);
	}

}
