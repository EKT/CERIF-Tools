package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
/**
 * A repository for links between resultProducts and facilities.
 * 
 */
public interface LinkResultProductFacilityRepository {

	public void delete(ResultProduct_Facility entity); 
	
	public void delete(Iterable<ResultProduct_Facility> entities); 

	public Iterable<ResultProduct_Facility> save(Iterable<ResultProduct_Facility> entities); 
	
	public ResultProduct_Facility save(ResultProduct_Facility entity);
	
}
