package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Measurement;

/**
 * A repository for links between facilities and measurements.
 * 
 */
public interface LinkFacilityMeasurementRepository {

	public void delete(Facility_Measurement entity); 
	
	public void delete(Iterable<Facility_Measurement> entities); 

	public Iterable<Facility_Measurement> save(Iterable<Facility_Measurement> entities); 
	
	public Facility_Measurement save(Facility_Measurement entity);
	
}
