package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;

import java.util.List;

/**
 * A repository for links between organisations and electronic addresses.
 * 
 */
public interface LinkOrganisationUnitElectronicAddressRepository {
	
	List<OrganisationUnit_ElectronicAddress> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	public OrganisationUnit_ElectronicAddress save(OrganisationUnit_ElectronicAddress entity);
	
	public Iterable<OrganisationUnit_ElectronicAddress> save(Iterable<OrganisationUnit_ElectronicAddress> entityList);
	
	void delete(OrganisationUnit_ElectronicAddress entity);
	
	void delete(Iterable<OrganisationUnit_ElectronicAddress> entityList);

}
