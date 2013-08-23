package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;

/**
 * A repository for links between resultPublications and facilities.
 * 
 */
public interface LinkResultPublicationFacilityRepository {

	public void delete(ResultPublication_Facility entity); 
	
	public void delete(Iterable<ResultPublication_Facility> entities); 

	public Iterable<ResultPublication_Facility> save(Iterable<ResultPublication_Facility> entities); 
	
	public ResultPublication_Facility save(ResultPublication_Facility entity);
	
}
