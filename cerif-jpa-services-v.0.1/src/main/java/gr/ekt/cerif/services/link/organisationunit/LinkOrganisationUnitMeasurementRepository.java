package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between organisations and measurements.
 * 
 */
public interface LinkOrganisationUnitMeasurementRepository {
	
	public void delete(OrganisationUnit_Measurement entity); 
	
	public void delete(Iterable<OrganisationUnit_Measurement> entities); 

	public Iterable<OrganisationUnit_Measurement> save(Iterable<OrganisationUnit_Measurement> entities); 
	
	public OrganisationUnit_Measurement save(OrganisationUnit_Measurement entity);
	
	List<OrganisationUnit_Measurement> findByOrganisationUnit(OrganisationUnit organisationUnit);
	
	List<OrganisationUnit_Measurement> findByMeasurement(Measurement measurement);

}
