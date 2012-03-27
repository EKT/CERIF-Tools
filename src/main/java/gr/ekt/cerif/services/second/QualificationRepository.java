/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Qualification;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for qualifications.
 * 
 */
public interface QualificationRepository extends CrudRepository<Qualification, String> {

}
