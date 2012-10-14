package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and facilities.
 * 
 */
@Component
public class LinkPersonFacilityRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Transactional
	public void save(Person_Facility entity) {
		if (entity.getPerson() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both a person and a facility.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Facility> entityList) {
		for (Person_Facility entity : entityList) {
			save(entity);
		}
	}
	
}
