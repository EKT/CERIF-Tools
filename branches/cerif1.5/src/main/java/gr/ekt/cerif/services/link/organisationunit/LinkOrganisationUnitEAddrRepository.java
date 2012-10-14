package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and electronic addresses.
 * 
 */
@Component
public class LinkOrganisationUnitEAddrRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ElectronicAddressRepository EAddrRepository;
	
	@Transactional
	public void save(OrganisationUnit_ElectronicAddress entity) {
		if (entity.getOrganisationUnit() == null || entity.getElectronicAddress() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an electronic address.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getElectronicAddress().getId() == null) {
			EAddrRepository.save(entity.getElectronicAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_ElectronicAddress> entityList) {
		for (OrganisationUnit_ElectronicAddress entity : entityList) {
			save(entity);
		}
	}

}
