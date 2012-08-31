/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for facilities.
 * 
 */
public interface FundingRepository extends CrudRepository<Funding, String> {

	public Funding findByAcronym(String acronym);
	public Funding findById(Long id);	
}
