package gr.ekt.cerif.services.link.medium;

import java.util.List;

import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.second.Medium;

/**
 * A repository for links between mediums.
 * 
 */
public interface LinkMediumMediumRepository {

	public void delete(Medium_Medium entity); 
	
	public void delete(Iterable<Medium_Medium> entities); 

	public Iterable<Medium_Medium> save(Iterable<Medium_Medium> entities); 
	
	public Medium_Medium save(Medium_Medium entity);
	
	List<Medium_Medium> findByMedium1(Medium medium);
	
	List<Medium_Medium> findByMedium2(Medium medium);
	
}
