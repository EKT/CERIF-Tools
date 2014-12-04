/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface FundingKeywordCrudRepository extends CrudRepository<FundingKeyword, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<FundingKeyword> findByFunding(Funding funding);

}
