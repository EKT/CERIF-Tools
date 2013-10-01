/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingName;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface FundingNameCrudRepository extends CrudRepository<FundingName, Long>  {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	FundingName findByName(String title);
	
	
}

