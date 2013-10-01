package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_Language;

@Component
public class LinkPersonLanguageRepositoryImpl implements LinkPersonLanguageRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonLanguageRepositoryImpl.class);
	
	@Autowired
	private LinkPersonLanguageCrudRepository linkPersonLanguageCrudRepository;

	@Override
	public void delete(Person_Language entity) {
		linkPersonLanguageCrudRepository.save(entity);		
	}

	@Override
	public void delete(Iterable<Person_Language> entities) {
		linkPersonLanguageCrudRepository.save(entities);		
	}

	@Override
	public Iterable<Person_Language> save(Iterable<Person_Language> entities) {
		return linkPersonLanguageCrudRepository.save(entities);
	}

	@Override
	public Person_Language save(Person_Language entity) {
		return linkPersonLanguageCrudRepository.save(entity);
	}

}
