package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and organisationUnits.
 * 
 */
@Component
public class LinkPersonOrganisationUnitRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private OrganisationUnitRepository organisationUnitRepository;
	
	@Transactional
	public void save(Person_OrganisationUnit entity) {
		if (entity.getPerson() == null || entity.getOrganisationUnit() == null) {
			throw new IllegalArgumentException("Please provide both a person and a organisationUnit.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationUnitRepository.save(entity.getOrganisationUnit());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_OrganisationUnit> entityList) {
		for (Person_OrganisationUnit entity : entityList) {
			save(entity);
		}
	}
	
}
