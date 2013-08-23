package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;

/**
 * A repository for links between resultPatents and facilitys.
 * 
 */
public interface LinkResultPatentFacilityRepository {

	public void delete(ResultPatent_Facility entity); 
	
	public void delete(Iterable<ResultPatent_Facility> entities); 

	public Iterable<ResultPatent_Facility> save(Iterable<ResultPatent_Facility> entities); 
	
	public ResultPatent_Facility save(ResultPatent_Facility entity);
	
}
