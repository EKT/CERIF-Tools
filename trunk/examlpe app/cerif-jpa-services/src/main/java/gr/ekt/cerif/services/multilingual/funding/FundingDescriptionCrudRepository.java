/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingDescription;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface FundingDescriptionCrudRepository extends CrudRepository<FundingDescription, Long>  {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	FundingDescription findByDescription(String descr);
	
	
}

