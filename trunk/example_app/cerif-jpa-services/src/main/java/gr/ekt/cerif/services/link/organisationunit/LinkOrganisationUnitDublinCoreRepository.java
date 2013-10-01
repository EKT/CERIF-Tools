package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;

/**
 * A repository for links between organisations and dublinCores.
 * 
 */
public interface LinkOrganisationUnitDublinCoreRepository {
	
	public void delete(OrganisationUnit_DublinCore entity); 
	
	public void delete(Iterable<OrganisationUnit_DublinCore> entities); 

	public Iterable<OrganisationUnit_DublinCore> save(Iterable<OrganisationUnit_DublinCore> entities); 
	
	public OrganisationUnit_DublinCore save(OrganisationUnit_DublinCore entity);

}
