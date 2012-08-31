package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.services.base.PersonRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons.
 * 
 */
@Component
public class LinkPersonPersonRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public void save(Person_Person entity) {
		if (entity.getPerson1() == null || entity.getPerson1() == null) {
			throw new IllegalArgumentException("Please provide both persons.");
		}
		if (entity.getPerson1().getId() == null) {
			personRepository.save(entity.getPerson1());
		}
		if (entity.getPerson2().getId() == null) {
			personRepository.save(entity.getPerson2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Person> entityList) {
		for (Person_Person entity : entityList) {
			save(entity);
		}
	}
	
}
