package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitElectronicAddressRepositoryImpl implements LinkOrganisationUnitElectronicAddressRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ElectronicAddressRepository EAddrRepository;
	
	@Autowired
	LinkOrganisationUnitElectronicAddressCrudRepository linkOrganisationUnitElectronicAddressCrudRepository;
	
	@Transactional
	public OrganisationUnit_ElectronicAddress save(OrganisationUnit_ElectronicAddress entity) {
		if (entity.getOrganisationUnit() == null || entity.getElectronicAddress() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an electronic address.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getElectronicAddress().getId() == null) {
			EAddrRepository.save(entity.getElectronicAddress());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_ElectronicAddress> save(Iterable<OrganisationUnit_ElectronicAddress> entityList) {
		for (OrganisationUnit_ElectronicAddress entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
	public List<OrganisationUnit_ElectronicAddress> findByOrganisationUnit(OrganisationUnit orgUnit) {
		return linkOrganisationUnitElectronicAddressCrudRepository.findByOrganisationUnit(orgUnit);
	}

	@Transactional
	public void delete(OrganisationUnit_ElectronicAddress entity) {
		linkOrganisationUnitElectronicAddressCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<OrganisationUnit_ElectronicAddress> entityList) {
		linkOrganisationUnitElectronicAddressCrudRepository.delete(entityList);
	}

}
