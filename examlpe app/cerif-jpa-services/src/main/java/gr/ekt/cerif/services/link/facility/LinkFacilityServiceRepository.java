package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Service;

/**
 * A repository for links between facilities and services.
 * 
 */
public interface LinkFacilityServiceRepository {

	public void delete(Facility_Service entity); 
	
	public void delete(Iterable<Facility_Service> entities); 

	public Iterable<Facility_Service> save(Iterable<Facility_Service> entities); 
	
	public Facility_Service save(Facility_Service entity);
	
}
