package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.result.ResultProduct;

/**
 * A repository for links between resultProducts and services.
 * 
 */
public interface LinkResultProductServiceRepository {

	public void delete(ResultProduct_Service entity); 
	
	public void delete(Iterable<ResultProduct_Service> entities); 

	public Iterable<ResultProduct_Service> save(Iterable<ResultProduct_Service> entities); 
	
	public ResultProduct_Service save(ResultProduct_Service entity);
	
	List<ResultProduct_Service> findByService(Service service);
	
	List<ResultProduct_Service> findByResultProduct(ResultProduct resultProduct);
	
}
