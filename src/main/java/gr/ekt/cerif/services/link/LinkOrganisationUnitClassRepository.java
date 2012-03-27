package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and classes.
 * 
 */
@Component
public class LinkOrganisationUnitClassRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	@Transactional
	public void save(OrganisationUnit_Class entity) {
		if (entity.getOrganisationUnit() == null || entity.getClass() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a class.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Class> entityList) {
		for (OrganisationUnit_Class entity : entityList) {
			save(entity);
		}
	}

}
