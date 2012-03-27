/**
 * 
 */
package gr.ekt.cerif.services.additional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.services.base.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for person translation entities.
 * 
 */
@Component
public class PersonNameRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	PersonRepository personRepository;
	
	@Transactional
	public void save(PersonName entity) {
		if (entity.getPerson() == null) {
			throw new IllegalArgumentException("Please provide a person.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<PersonName> entityList) {
		for (PersonName entity : entityList) {
			save(entity);
		}
	}

}

