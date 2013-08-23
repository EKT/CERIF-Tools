package gr.ekt.cerif.services.multilingual.service;

import gr.ekt.cerif.features.multilingual.ServiceKeyword;

public interface ServiceKeywordRepository {
	
	public void delete(ServiceKeyword entity); 
	
	public void delete(Iterable<ServiceKeyword> entities); 

	public Iterable<ServiceKeyword> save(Iterable<ServiceKeyword> entities); 
	
	public ServiceKeyword save(ServiceKeyword entity);

}
