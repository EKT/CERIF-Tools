package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Country;

@Component
public class LinkPersonCountryRepositoryImpl implements
		LinkPersonCountryRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonCountryRepositoryImpl.class);
	
	@Autowired
	private LinkPersonCountryCrudRepository linkPersonCountryCrudRepository;

	@Override
	public void delete(Person_Country entity) {
		linkPersonCountryCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Country> entities) {
		linkPersonCountryCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Country> save(Iterable<Person_Country> entities) {
		return linkPersonCountryCrudRepository.save(entities);
	}

	@Override
	public Person_Country save(Person_Country entity) {
		return linkPersonCountryCrudRepository.save(entity);
	}

	@Override
	public List<Person_Country> findByPerson(Person person) {
		return linkPersonCountryCrudRepository.findByPerson(person);
	}

}
