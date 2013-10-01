package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Indicator;

/**
 * A repository for links between facilities and indicators.
 * 
 */
public interface LinkFacilityIndicatorRepository {

	public void delete(Facility_Indicator entity); 
	
	public void delete(Iterable<Facility_Indicator> entities); 

	public Iterable<Facility_Indicator> save(Iterable<Facility_Indicator> entities); 
	
	public Facility_Indicator save(Facility_Indicator entity);
	
}
