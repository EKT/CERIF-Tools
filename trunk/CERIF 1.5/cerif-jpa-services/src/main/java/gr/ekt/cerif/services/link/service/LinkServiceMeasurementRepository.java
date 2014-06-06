package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between services and measurements.
 * 
 */
public interface LinkServiceMeasurementRepository {

	public void delete(Service_Measurement entity); 
	
	public void delete(Iterable<Service_Measurement> entities); 

	public Iterable<Service_Measurement> save(Iterable<Service_Measurement> entities); 
	
	public Service_Measurement save(Service_Measurement entity);
	
	List<Service_Measurement> findByMeasurement(Measurement measurement);
	
	List<Service_Measurement> findByService(Service service);
	
}
