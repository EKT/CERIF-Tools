package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.CVRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and cvs.
 * 
 */
@Component
public class LinkPersonCvRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CVRepository cvRepository;
	
	@Transactional
	public void save(Person_Cv entity) {
		if (entity.getPerson() == null || entity.getCv() == null) {
			throw new IllegalArgumentException("Please provide both a person and a cv.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getCv().getId() == null) {
			cvRepository.save(entity.getCv());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Cv> entityList) {
		for (Person_Cv entity : entityList) {
			save(entity);
		}
	}
	
	public void delete(Person_Cv entity) {
		entityManager.remove(entity);
	}
	
}
