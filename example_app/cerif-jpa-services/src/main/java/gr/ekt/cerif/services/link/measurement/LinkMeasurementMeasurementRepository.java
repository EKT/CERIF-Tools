package gr.ekt.cerif.services.link.measurement;

import gr.ekt.cerif.entities.link.Measurement_Measurement;

/**
 * A repository for links between measurements.
 * 
 */
public interface LinkMeasurementMeasurementRepository {

	public void delete(Measurement_Measurement entity); 
	
	public void delete(Iterable<Measurement_Measurement> entities); 

	public Iterable<Measurement_Measurement> save(Iterable<Measurement_Measurement> entities); 
	
	public Measurement_Measurement save(Measurement_Measurement entity);
	
}
