package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.result.ResultProduct;
/**
 * A repository for links between resultProducts and facilities.
 * 
 */
public interface LinkResultProductFacilityRepository {

	public void delete(ResultProduct_Facility entity); 
	
	public void delete(Iterable<ResultProduct_Facility> entities); 

	public Iterable<ResultProduct_Facility> save(Iterable<ResultProduct_Facility> entities); 
	
	public ResultProduct_Facility save(ResultProduct_Facility entity);
	
	List<ResultProduct_Facility> findByFacility(Facility facility);
	
	List<ResultProduct_Facility> findByResultProduct(ResultProduct resultProduct);

	
}
