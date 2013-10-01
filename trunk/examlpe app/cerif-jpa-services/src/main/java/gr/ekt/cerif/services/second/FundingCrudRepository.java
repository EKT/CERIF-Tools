/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for fundings.
 * 
 */
public interface FundingCrudRepository extends CrudRepository<Funding, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Funding findByAcronym(String acronym);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Funding findById(Long id);	
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Funding> findAll();
	
}
