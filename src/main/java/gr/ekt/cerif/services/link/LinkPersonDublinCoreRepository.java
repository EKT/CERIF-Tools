package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_DublinCore;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.additional.DublinCoreRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and dublinCorees.
 * 
 */
@Component
public class LinkPersonDublinCoreRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DublinCoreRepository dublinCoreRepository;
	
	@Transactional
	public void save(Person_DublinCore entity) {
		if (entity.getPerson() == null || entity.getDublinCore() == null) {
			throw new IllegalArgumentException("Please provide both a person and a dublinCore.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getDublinCore().getId() == null) {
			dublinCoreRepository.save(entity.getDublinCore());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_DublinCore> entityList) {
		for (Person_DublinCore entity : entityList) {
			save(entity);
		}
	}
	
}
