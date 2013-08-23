package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_Funding;

/**
 * A repository for links between services and fundings.
 * 
 */
public interface LinkServiceFundingRepository {

	public void delete(Service_Funding entity); 
	
	public void delete(Iterable<Service_Funding> entities); 

	public Iterable<Service_Funding> save(Iterable<Service_Funding> entities); 
	
	public Service_Funding save(Service_Funding entity);
	
}
