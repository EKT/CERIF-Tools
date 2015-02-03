package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

/**
 * A repository for links between organisations and result patents.
 * 
 */
public interface LinkOrganisationUnitResultPatentRepository {
	
	public void delete(OrganisationUnit_ResultPatent entity); 
	
	public void delete(Iterable<OrganisationUnit_ResultPatent> entities); 

	public Iterable<OrganisationUnit_ResultPatent> save(Iterable<OrganisationUnit_ResultPatent> entities); 
	
	public OrganisationUnit_ResultPatent save(OrganisationUnit_ResultPatent entity);
	
	List<OrganisationUnit_ResultPatent> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
