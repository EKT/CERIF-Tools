package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and indicators.
 * 
 */
@Component
public class LinkPersonIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Person_Indicator entity) {
		if (entity.getPerson() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a person and a indicator.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Indicator> entityList) {
		for (Person_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
