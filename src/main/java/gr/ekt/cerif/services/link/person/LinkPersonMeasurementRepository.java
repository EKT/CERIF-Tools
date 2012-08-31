package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and measurements.
 * 
 */
@Component
public class LinkPersonMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Person_Measurement entity) {
		if (entity.getPerson() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a person and a measurement.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Measurement> entityList) {
		for (Person_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
