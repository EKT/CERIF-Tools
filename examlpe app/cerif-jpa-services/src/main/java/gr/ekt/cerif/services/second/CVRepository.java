/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.CV;

/**
 * A repository for cvs.
 * 
 */
public interface CVRepository {
	
	CV findById(Long id);
	
	public void delete(CV entity); 
	
	public void delete(Iterable<CV> entities); 

	public Iterable<CV> save(Iterable<CV> entities); 
	
	public CV save(CV entity);

}
