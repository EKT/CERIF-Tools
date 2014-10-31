/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import java.util.List;

import gr.ekt.cerif.entities.second.Funding;
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
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FundingDescription> findByFunding(Funding funding);
	
	
}

