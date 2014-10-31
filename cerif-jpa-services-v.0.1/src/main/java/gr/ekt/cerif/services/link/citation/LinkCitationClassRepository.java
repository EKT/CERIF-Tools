package gr.ekt.cerif.services.link.citation;

import java.util.List;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between citations and classes.
 * 
 */
public interface LinkCitationClassRepository {

	public void delete(Citation_Class entity); 
	
	public void delete(Iterable<Citation_Class> entities); 

	public Iterable<Citation_Class> save(Iterable<Citation_Class> entities); 
	
	public Citation_Class save(Citation_Class entity);
	
	List<Citation_Class> findByCitation(Citation citation);
	
	List<Citation_Class> findBytheClass(Class theClass);
	
}
