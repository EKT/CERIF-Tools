/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingDescription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface FundingDescriptionCrudRepository extends CrudRepository<FundingDescription, Long>  {

	FundingDescription findByDescription(String descr);
	
	List<FundingDescription> findByFunding(Funding funding);
	
	
}

