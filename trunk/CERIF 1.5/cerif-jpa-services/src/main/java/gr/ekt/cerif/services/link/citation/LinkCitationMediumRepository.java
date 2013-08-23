package gr.ekt.cerif.services.link.citation;

import gr.ekt.cerif.entities.link.Citation_Medium;

/**
 * A repository for links between citations and mediums.
 * 
 */
public interface LinkCitationMediumRepository {

	public void delete(Citation_Medium entity); 
	
	public void delete(Iterable<Citation_Medium> entities); 

	public Iterable<Citation_Medium> save(Iterable<Citation_Medium> entities); 
	
	public Citation_Medium save(Citation_Medium entity);
	
}
