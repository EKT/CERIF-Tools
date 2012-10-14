/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPatent;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for patents.
 * 
 */
public interface ResultPatentRepository extends CrudRepository<ResultPatent, String> {

}
