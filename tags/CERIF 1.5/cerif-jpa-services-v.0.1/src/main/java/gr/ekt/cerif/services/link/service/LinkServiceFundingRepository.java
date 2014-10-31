package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.second.Funding;

/**
 * A repository for links between services and fundings.
 * 
 */
public interface LinkServiceFundingRepository {

	public void delete(Service_Funding entity); 
	
	public void delete(Iterable<Service_Funding> entities); 

	public Iterable<Service_Funding> save(Iterable<Service_Funding> entities); 
	
	public Service_Funding save(Service_Funding entity);
	
	List<Service_Funding> findByFunding(Funding funding);
	
	List<Service_Funding> findByService(Service service);
	
}
