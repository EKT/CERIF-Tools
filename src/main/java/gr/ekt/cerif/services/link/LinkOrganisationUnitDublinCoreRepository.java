package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.additional.DublinCoreRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and dublinCores.
 * 
 */
@Component
public class LinkOrganisationUnitDublinCoreRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	DublinCoreRepository dublinCoreRepository;
	
	@Transactional
	public void save(OrganisationUnit_DublinCore entity) {
		if (entity.getOrganisationUnit() == null || entity.getDublinCore() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a dublinCore.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getDublinCore().getId() == null) {
			dublinCoreRepository.save(entity.getDublinCore());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_DublinCore> entityList) {
		for (OrganisationUnit_DublinCore entity : entityList) {
			save(entity);
		}
	}

}
