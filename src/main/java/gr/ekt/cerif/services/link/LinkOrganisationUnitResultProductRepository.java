package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.result.ResultProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and result products.
 * 
 */
@Component
public class LinkOrganisationUnitResultProductRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ResultProductRepository resultProductRepository;
	
	@Transactional
	public void save(OrganisationUnit_ResultProduct entity) {
		if (entity.getOrganisationUnit() == null || entity.getResultProduct() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a result product.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_ResultProduct> entityList) {
		for (OrganisationUnit_ResultProduct entity : entityList) {
			save(entity);
		}
	}

}
