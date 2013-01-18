package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitPostalAddressRepositoryImpl implements LinkOrganisationUnitPostalAddressRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	PostalAddressRepository PAddrRepository;
	
	@Autowired
	LinkOrganisationUnitPostalAddressCrudRepository linkOrganisationUnitPAddrCrudRepository;
	
	public List<OrganisationUnit_PostalAddress> findByPostalAddress(PostalAddress postalAddress) {
		return linkOrganisationUnitPAddrCrudRepository.findByPostalAddress(postalAddress);
	}

	public List<OrganisationUnit_PostalAddress> findByOrganisationUnit(OrganisationUnit organisationUnit) {
		return linkOrganisationUnitPAddrCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	public OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryName(String organisationUnitName, String cName) {
		return linkOrganisationUnitPAddrCrudRepository.findByOrganisationUnitNameAndCountryName(organisationUnitName, cName);
	}

	public OrganisationUnit_PostalAddress findByOrganisationUnitName(String organisationUnitName) {
		return linkOrganisationUnitPAddrCrudRepository.findByOrganisationUnitName(organisationUnitName);
	}

	public OrganisationUnit_PostalAddress findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String ccode) {
		return linkOrganisationUnitPAddrCrudRepository.findByOrganisationUnitNameAndCountryCode(organisationUnitName, ccode);
	}
	
	@Transactional
	public OrganisationUnit_PostalAddress save(OrganisationUnit_PostalAddress entity) {
		if (entity.getOrganisationUnit() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and a product.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getPostalAddress().getId() == null) {
			PAddrRepository.save(entity.getPostalAddress());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<? extends OrganisationUnit_PostalAddress> save(Iterable<? extends OrganisationUnit_PostalAddress> entities) {
		for (OrganisationUnit_PostalAddress entity : entities) {
			save(entity);
		}
		return entities;
	}
	
	@Transactional
	public void delete(OrganisationUnit_PostalAddress entity) {
		linkOrganisationUnitPAddrCrudRepository.delete(entity);
	}

}
