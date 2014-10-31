package gr.ekt.cerif.services.link.facility;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between facilities and measurements.
 * 
 */
public interface LinkFacilityMeasurementRepository {

	public void delete(Facility_Measurement entity); 
	
	public void delete(Iterable<Facility_Measurement> entities); 

	public Iterable<Facility_Measurement> save(Iterable<Facility_Measurement> entities); 
	
	public Facility_Measurement save(Facility_Measurement entity);
	
	List<Facility_Measurement> findByMeasurement(Measurement measurement);
	
	List<Facility_Measurement> findByFacility(Facility facility);
	
}
