/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for publications.
 * 
 */
public interface ResultPublicationRepository extends CrudRepository<ResultPublication, String> {

}
