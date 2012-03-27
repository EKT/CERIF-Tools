package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.result.ResultPatentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and result patents.
 * 
 */
@Component
public class LinkPersonResultPatentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Transactional
	public void save(Person_ResultPatent entity) {
		if (entity.getPerson() == null || entity.getResultPatent() == null) {
			throw new IllegalArgumentException("Please provide both a person and a resultPatent.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ResultPatent> entityList) {
		for (Person_ResultPatent entity : entityList) {
			save(entity);
		}
	}
	
}
