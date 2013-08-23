package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Medium;

/**
 * A repository for links between mediums.
 * 
 */
public interface LinkMediumMediumRepository {

	public void delete(Medium_Medium entity); 
	
	public void delete(Iterable<Medium_Medium> entities); 

	public Iterable<Medium_Medium> save(Iterable<Medium_Medium> entities); 
	
	public Medium_Medium save(Medium_Medium entity);
	
}
