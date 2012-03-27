package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and result publications.
 * 
 */
@Component
public class LinkPersonResultPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Transactional
	public void save(Person_ResultPublication entity) {
		if (entity.getPerson() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both a person and a resultPublication.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ResultPublication> entityList) {
		for (Person_ResultPublication entity : entityList) {
			save(entity);
		}
	}
	
}
