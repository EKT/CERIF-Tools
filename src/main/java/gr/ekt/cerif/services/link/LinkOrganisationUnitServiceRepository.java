package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and services.
 * 
 */
@Component
public class LinkOrganisationUnitServiceRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Transactional
	public void save(OrganisationUnit_Service entity) {
		if (entity.getOrganisationUnit() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an service.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Service> entityList) {
		for (OrganisationUnit_Service entity : entityList) {
			save(entity);
		}
	}

}
