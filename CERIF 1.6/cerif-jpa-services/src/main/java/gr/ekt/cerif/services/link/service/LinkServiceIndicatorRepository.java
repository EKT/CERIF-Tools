package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

/**
 * A repository for links between services and indicators.
 * 
 */
public interface LinkServiceIndicatorRepository {

	public void delete(Service_Indicator entity); 
	
	public void delete(Iterable<Service_Indicator> entities); 

	public Iterable<Service_Indicator> save(Iterable<Service_Indicator> entities); 
	
	public Service_Indicator save(Service_Indicator entity);
	
	List<Service_Indicator> findByIndicator(Indicator Iindicator);
	
	List<Service_Indicator> findByService(Service service);
	
}
