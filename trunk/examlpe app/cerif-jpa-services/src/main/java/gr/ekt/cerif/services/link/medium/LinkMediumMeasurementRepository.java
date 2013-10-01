package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Measurement;

/**
 * A repository for links between mediums and measurements.
 * 
 */
public interface LinkMediumMeasurementRepository {

	public void delete(Medium_Measurement entity); 
	
	public void delete(Iterable<Medium_Measurement> entities); 

	public Iterable<Medium_Measurement> save(Iterable<Medium_Measurement> entities); 
	
	public Medium_Measurement save(Medium_Measurement entity);
	
}
