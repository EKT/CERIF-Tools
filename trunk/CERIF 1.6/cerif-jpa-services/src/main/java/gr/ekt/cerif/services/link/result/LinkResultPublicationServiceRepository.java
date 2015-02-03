package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultPublication;


import java.util.List;

/**
 * A repository for links between resultPublications and services.
 * 
 */
public interface LinkResultPublicationServiceRepository {

	public void delete(ResultPublication_Service entity); 
	
	public void delete(Iterable<ResultPublication_Service> entities); 

	public Iterable<ResultPublication_Service> save(Iterable<ResultPublication_Service> entities); 
	
	public ResultPublication_Service save(ResultPublication_Service entity);
	
	List<ResultPublication_Service> findByService(Service service);
	
	List<ResultPublication_Service> findByResultPublication(ResultPublication resultPublication);
	
}
