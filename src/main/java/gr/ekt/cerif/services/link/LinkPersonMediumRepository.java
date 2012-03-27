package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and countries.
 * 
 */
@Component
public class LinkPersonMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Person_Medium entity) {
		if (entity.getPerson() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a person and a medium.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Medium> entityList) {
		for (Person_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
