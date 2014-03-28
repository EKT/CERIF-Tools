package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitElectronicAddressRepositoryImpl implements LinkOrganisationUnitElectronicAddressRepository {
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	ElectronicAddressRepository EAddrRepository;
	
	@Autowired
	LinkOrganisationUnitElectronicAddressCrudRepository linkOrganisationUnitElectronicAddressCrudRepository;
	
	@Transactional
	public OrganisationUnit_ElectronicAddress save(OrganisationUnit_ElectronicAddress entity) {
		return linkOrganisationUnitElectronicAddressCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_ElectronicAddress> save(Iterable<OrganisationUnit_ElectronicAddress> entityList) {
		return linkOrganisationUnitElectronicAddressCrudRepository.save(entityList);
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

	@Override
	public List<OrganisationUnit_ElectronicAddress> findByElectronicAddress(
			ElectronicAddress electronicAddress) {
		return linkOrganisationUnitElectronicAddressCrudRepository.findByElectronicAddress(electronicAddress);
	}

}
