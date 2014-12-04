package gr.ekt.cerif.services.link.facility;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between facilities and mediums.
 * 
 */
public interface LinkFacilityMediumRepository {

	public void delete(Facility_Medium entity); 
	
	public void delete(Iterable<Facility_Medium> entities); 

	public Iterable<Facility_Medium> save(Iterable<Facility_Medium> entities); 
	
	public Facility_Medium save(Facility_Medium entity);
	
	List<Facility_Medium> findByMedium(Medium medium);
	
	List<Facility_Medium> findByFacility(Facility facility);
	
}
