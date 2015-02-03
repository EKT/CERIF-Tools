package gr.ekt.cerif.services.link.medium;

import java.util.List;

import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;
/**
 * A repository for links between mediums and classes.
 * 
 */
public interface LinkMediumClassRepository {

	public void delete(Medium_Class entity); 
	
	public void delete(Iterable<Medium_Class> entities); 

	public Iterable<Medium_Class> save(Iterable<Medium_Class> entities); 
	
	public Medium_Class save(Medium_Class entity);
	
	List<Medium_Class> findByMedium(Medium medium);
	
	List<Medium_Class> findBytheClass(Class theClass);
	
}
