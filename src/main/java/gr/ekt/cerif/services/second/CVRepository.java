/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.CV;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for cvs.
 * 
 */
public interface CVRepository extends CrudRepository<CV, String> {
	
	CV findById(Long id);

}
