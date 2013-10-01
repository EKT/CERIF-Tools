/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Qualification;

/**
 * @author bonisv
 *
 */
public interface QualificationRepository {

	public void delete(Qualification entity); 
	
	public void delete(Iterable<Qualification> entities); 

	public Iterable<Qualification> save(Iterable<Qualification> entities); 
	
	public Qualification save(Qualification entity);
}
