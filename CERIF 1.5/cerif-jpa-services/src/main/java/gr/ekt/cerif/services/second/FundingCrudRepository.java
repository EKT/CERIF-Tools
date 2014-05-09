/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<Funding> findAll(Pageable page);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Funding findByUri(String Uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Funding findByUuid(String uuid);
	
}
