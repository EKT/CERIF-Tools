package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.QualificationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and qualifications.
 * 
 */
@Component
public class LinkPersonQualificationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private QualificationRepository qualificationRepository;
	
	@Transactional
	public void save(Person_Qualification entity) {
		if (entity.getPerson() == null || entity.getQualification() == null) {
			throw new IllegalArgumentException("Please provide both a person and a qualification.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getQualification().getId() == null) {
			qualificationRepository.save(entity.getQualification());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Qualification> entityList) {
		for (Person_Qualification entity : entityList) {
			save(entity);
		}
	}
	
}
