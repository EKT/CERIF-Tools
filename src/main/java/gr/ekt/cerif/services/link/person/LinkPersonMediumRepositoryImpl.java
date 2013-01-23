package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonMediumRepositoryImpl implements LinkPersonMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private LinkPersonMediumCrudRepository linkPersonMediumCrudRepository;
	
	@Transactional
	public Person_Medium save(Person_Medium entity) {
		if (entity.getPerson() == null) {
			throw new IllegalArgumentException("Please provide a person.");
		}
		if (entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide a medium.");
		}
		/**
		if (entity.getPerson() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a person and a medium.");
		}
		*/
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		return entityManager.merge(entity);
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
}
