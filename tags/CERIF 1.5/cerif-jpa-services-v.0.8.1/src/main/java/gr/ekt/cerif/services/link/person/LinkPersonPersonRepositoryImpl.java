package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Person;

@Component
public class LinkPersonPersonRepositoryImpl implements
		LinkPersonPersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonPersonRepositoryImpl.class);
	
	@Autowired
	private LinkPersonPersonCrudRepository linkPersonPersonCrudRepository;

	@Override
	public void delete(Person_Person entity) {
		linkPersonPersonCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Person> entities) {
		linkPersonPersonCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Person> save(Iterable<Person_Person> entities) {
		return linkPersonPersonCrudRepository.save(entities);
	}

	@Override
	public Person_Person save(Person_Person entity) {
		return linkPersonPersonCrudRepository.save(entity);
	}

	@Override
	public List<Person_Person> findByPerson1(Person person) {
		return linkPersonPersonCrudRepository.findByPerson1(person);
	}

	@Override
	public List<Person_Person> findByPerson2(Person person) {
		return linkPersonPersonCrudRepository.findByPerson2(person);
	}

}
