package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between organisations and result publications.
 * 
 */
public interface LinkOrganisationUnitResultPublicationRepository {
	
	OrganisationUnit_ResultPublication save(OrganisationUnit_ResultPublication entity);
	
	Iterable<OrganisationUnit_ResultPublication> save(Iterable<OrganisationUnit_ResultPublication> entityList);
	
	void delete(OrganisationUnit_ResultPublication entity);
	
	void delete(Iterable<OrganisationUnit_ResultPublication> entityList);
	
	OrganisationUnit_ResultPublication findById(Long orgunitrespubId);
	
	List<OrganisationUnit_ResultPublication> findByOrganisationUnit(OrganisationUnit orgUnit);
	
	List<OrganisationUnit_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
	OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId);	
	
	List<OrganisationUnit_ResultPublication> findByOrganisationUnitAndResultPublicationAndTheClass(OrganisationUnit orgUnit, ResultPublication resultPublication, Class theClass);
	
	List<OrganisationUnit_ResultPublication> findByResultPublicationAndTheClass(ResultPublication resultPublication, Class theClass);

}
