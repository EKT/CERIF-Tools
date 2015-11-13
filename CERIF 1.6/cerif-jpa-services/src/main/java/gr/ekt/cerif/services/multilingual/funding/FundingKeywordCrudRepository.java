/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface FundingKeywordCrudRepository extends CrudRepository<FundingKeyword, Long> {
	
	List<FundingKeyword> findByFunding(Funding funding);

}
