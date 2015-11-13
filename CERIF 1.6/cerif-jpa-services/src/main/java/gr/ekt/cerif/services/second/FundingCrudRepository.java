/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for fundings.
 * 
 */
public interface FundingCrudRepository extends CrudRepository<Funding, Long> {

	public Funding findByAcronym(String acronym);

	public Funding findById(Long id);	
	
	public List<Funding> findAll();
	
	public Page<Funding> findAll(Pageable page);
	
	public Funding findByUri(String Uri);
	
	public Funding findByUuid(String uuid);
	
}
