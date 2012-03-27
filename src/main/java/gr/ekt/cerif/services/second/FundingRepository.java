/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for Fundings.
 * 
 */
public interface FundingRepository extends CrudRepository<Funding, String> {

}
