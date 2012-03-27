package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations.
 * 
 */
@Component
public class LinkOrganisationUnitOrganisationUnitRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Transactional
	public void save(OrganisationUnit_OrganisationUnit entity) {
		if (entity.getOrganisationUnit1() == null || entity.getOrganisationUnit2() == null) {
			throw new IllegalArgumentException("Please provide both organisations.");
		}
		if (entity.getOrganisationUnit1().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit1());
		}
		if (entity.getOrganisationUnit2().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_OrganisationUnit> entityList) {
		for (OrganisationUnit_OrganisationUnit entity : entityList) {
			save(entity);
		}
	}

}
