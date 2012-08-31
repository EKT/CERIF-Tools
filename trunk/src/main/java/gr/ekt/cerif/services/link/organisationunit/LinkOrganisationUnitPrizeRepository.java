package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.PrizeRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and prizes.
 * 
 */
@Component
public class LinkOrganisationUnitPrizeRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	PrizeRepository prizeRepository;
	
	@Transactional
	public void save(OrganisationUnit_Prize entity) {
		if (entity.getOrganisationUnit() == null || entity.getPrize() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an prize.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getPrize().getId() == null) {
			prizeRepository.save(entity.getPrize());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Prize> entityList) {
		for (OrganisationUnit_Prize entity : entityList) {
			save(entity);
		}
	}

}
