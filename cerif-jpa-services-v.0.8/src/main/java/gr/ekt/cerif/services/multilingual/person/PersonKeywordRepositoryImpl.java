package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonKeyword;


@Component
public class PersonKeywordRepositoryImpl implements PersonKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PersonKeywordRepositoryImpl.class);
	
	@Autowired
	private PersonKeywordCrudRepository personKeywordCrudRepository;

	@Override
	public void delete(PersonKeyword entity) {
		personKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PersonKeyword> entities) {
		personKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PersonKeyword> save(Iterable<PersonKeyword> entities) {
		return personKeywordCrudRepository.save(entities);
	}

	@Override
	public PersonKeyword save(PersonKeyword entity) {
		return personKeywordCrudRepository.save(entity);
	}

	@Override
	public List<PersonKeyword> findByPerson(Person person) {
		return personKeywordCrudRepository.findByPerson(person);
	}

}
