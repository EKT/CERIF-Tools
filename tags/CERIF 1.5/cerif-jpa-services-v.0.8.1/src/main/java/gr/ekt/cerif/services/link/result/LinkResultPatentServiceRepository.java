package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.result.ResultPatent;

/**
 * A repository for links between resultPatents and services.
 * 
 */
public interface LinkResultPatentServiceRepository {

	public void delete(ResultPatent_Service entity); 
	
	public void delete(Iterable<ResultPatent_Service> entities); 

	public Iterable<ResultPatent_Service> save(Iterable<ResultPatent_Service> entities); 
	
	public ResultPatent_Service save(ResultPatent_Service entity);
	
	List<ResultPatent_Service> findByService(Service service);
	
	List<ResultPatent_Service> findByResultPatent(ResultPatent resultPatent);
	
}
