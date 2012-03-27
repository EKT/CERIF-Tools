/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
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
public class LinkOrganisationPAddrRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	PostalAddressRepository PAddrRepository;
	
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
	
	@Transactional
	public void save(List<OrganisationUnit_PostalAddress> entityList) {
		for (OrganisationUnit_PostalAddress entity : entityList) {
			save(entity);
		}
	}

}
