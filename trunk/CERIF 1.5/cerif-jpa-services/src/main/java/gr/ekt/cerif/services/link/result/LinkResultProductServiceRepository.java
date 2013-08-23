package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Service;

/**
 * A repository for links between resultProducts and services.
 * 
 */
public interface LinkResultProductServiceRepository {

	public void delete(ResultProduct_Service entity); 
	
	public void delete(Iterable<ResultProduct_Service> entities); 

	public Iterable<ResultProduct_Service> save(Iterable<ResultProduct_Service> entities); 
	
	public ResultProduct_Service save(ResultProduct_Service entity);
	
}
