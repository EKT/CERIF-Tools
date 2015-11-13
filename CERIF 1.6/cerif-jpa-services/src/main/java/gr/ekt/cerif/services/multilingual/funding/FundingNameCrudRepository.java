/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface FundingNameCrudRepository extends CrudRepository<FundingName, Long>  {

	List<FundingName> findByFunding(Funding funding);
	
	
}

