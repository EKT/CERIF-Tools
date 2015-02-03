package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;

public interface LinkOrganisationUnitClassRepository {
	
	List <OrganisationUnit_Class> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	public void delete(OrganisationUnit_Class entity); 
	
	public void delete(Iterable<OrganisationUnit_Class> entities); 

	public Iterable<OrganisationUnit_Class> save(Iterable<OrganisationUnit_Class> entities); 
	
	public OrganisationUnit_Class save(OrganisationUnit_Class entity);

}
