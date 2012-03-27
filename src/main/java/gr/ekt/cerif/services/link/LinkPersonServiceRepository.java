package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and services.
 * 
 */
@Component
public class LinkPersonServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(Person_Service entity) {
		if (entity.getPerson() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a person and a service.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Service> entityList) {
		for (Person_Service entity : entityList) {
			save(entity);
		}
	}
	
}
