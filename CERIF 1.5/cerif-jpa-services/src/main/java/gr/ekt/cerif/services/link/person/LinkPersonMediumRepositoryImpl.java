package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonMediumRepositoryImpl implements LinkPersonMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonMediumRepositoryImpl.class);

	@Autowired
	private LinkPersonMediumCrudRepository linkPersonMediumCrudRepository;
	
	
	@Transactional
	public Person_Medium save(Person_Medium entity) {
		return linkPersonMediumCrudRepository.save(entity);
	}

	@Transactional
	public Iterable<? extends Person_Medium> save(Iterable<? extends Person_Medium> entityList) {
		return linkPersonMediumCrudRepository.save(entityList);
	}
	
	public List<Person_Medium> findByPerson(Person person) {
		return linkPersonMediumCrudRepository.findByPerson(person);
	}

	@Transactional
	public void delete(Person_Medium entity) {
		linkPersonMediumCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<? extends Person_Medium> entities) {
		linkPersonMediumCrudRepository.delete(entities);
	}

	@Override
	public List<Person_Medium> findByMedium(Medium medium) {
		return linkPersonMediumCrudRepository.findByMedium(medium);
	}
	
}
