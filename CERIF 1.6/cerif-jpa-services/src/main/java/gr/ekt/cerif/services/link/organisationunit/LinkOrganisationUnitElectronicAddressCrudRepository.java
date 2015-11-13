package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitElectronicAddressCrudRepository extends CrudRepository<OrganisationUnit_ElectronicAddress, Long> {

	List<OrganisationUnit_ElectronicAddress> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ElectronicAddress> findByElectronicAddress(ElectronicAddress electronicAddress);
	
}
