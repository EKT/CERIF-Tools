package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonClassRepositoryImpl implements LinkPersonClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonClassRepositoryImpl.class);
	
	@Autowired
	private LinkPersonClassCrudRepository linkPersonClassCrudRepository;
	
	
	@Transactional
	public Person_Class save(Person_Class entity) {
		return linkPersonClassCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Person_Class> save(Iterable<Person_Class> entityList) {
		return linkPersonClassCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(Person_Class entity) {
		linkPersonClassCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Person_Class> entityList) {
		linkPersonClassCrudRepository.delete(entityList);
	}

	@Override
	public List<Person_Class> findByPerson(Person person) {
		return linkPersonClassCrudRepository.findByPerson(person);
	}

	@Override
	public Person_Class findByPersonAndTheClass(Person person, Class theClass) {
		return linkPersonClassCrudRepository.findByPersonAndTheClass(person, theClass);
	}
	
}
