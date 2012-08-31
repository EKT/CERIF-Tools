package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.services.base.PersonRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between personNames and persons.
 * 
 */
@Component
public class LinkPersonNamePersonRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public void save(PersonName_Person entity) {
		if (entity.getPerson1() == null || entity.getPerson2() == null) {
			throw new IllegalArgumentException("Please provide both a personName and a person.");
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
	public void save(List<PersonName_Person> entityList) {
		for (PersonName_Person entity : entityList) {
			save(entity);
		}
	}
	
}
