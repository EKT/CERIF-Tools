package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.link.LinkFundingClassService;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and products.
 * 
 */
@Component
public class LinkOrganisationUnitPAddrServiceImpl implements LinkOrganisationUnitPAddrService {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	PostalAddressRepository PAddrRepository;
	
	@Override
	@Transactional
	public void save(OrganisationUnit_PostalAddress entity) {
		if (entity.getOrganisationUnit() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a product.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getPostalAddress().getId() == null) {
			PAddrRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Override
	@Transactional
	public void save(List<? extends OrganisationUnit_PostalAddress> entities) {
		for (OrganisationUnit_PostalAddress entity : entities) {
			save(entity);
		}
	}

}
