package gr.ekt.cerif.services.multilingual.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

public interface OrganisationUnitNameRepository {

	OrganisationUnitName findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	public void delete(OrganisationUnitName entity); 
	
	public void delete(Iterable<OrganisationUnitName> entities); 

	public Iterable<OrganisationUnitName> save(Iterable<OrganisationUnitName> entities); 
	
	public OrganisationUnitName save(OrganisationUnitName entity);
	
}
