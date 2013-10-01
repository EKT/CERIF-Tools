package gr.ekt.cerif.services.link.measurement;

import gr.ekt.cerif.entities.link.Measurement_Class;

/**
 * A repository for links between measurements and classes.
 * 
 */
public interface LinkMeasurementClassRepository {

	public void delete(Measurement_Class entity); 
	
	public void delete(Iterable<Measurement_Class> entities); 

	public Iterable<Measurement_Class> save(Iterable<Measurement_Class> entities); 
	
	public Measurement_Class save(Measurement_Class entity);
	
}
