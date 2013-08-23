package gr.ekt.cerif.services.link.citation;

import gr.ekt.cerif.entities.link.Citation_Class;

/**
 * A repository for links between citations and classes.
 * 
 */
public interface LinkCitationClassRepository {

	public void delete(Citation_Class entity); 
	
	public void delete(Iterable<Citation_Class> entities); 

	public Iterable<Citation_Class> save(Iterable<Citation_Class> entities); 
	
	public Citation_Class save(Citation_Class entity);
	
}
