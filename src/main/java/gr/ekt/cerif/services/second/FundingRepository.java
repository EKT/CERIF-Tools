/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.FundingList;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for fundings.
 * 
 */
public interface FundingRepository extends CrudRepository<Funding, Long> {

	Funding findByAcronym(String acronym);

	Funding findById(Long id);	
	
	List<Funding> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select new gr.ekt.cerif.entities.second.FundingList(" +
			   "       f.id,				" +
			   "	   fn.name)			" +
			   "  from Funding f 				" +   
			   "  left join f.names fn 		")			   		   
	List<FundingList> findAllFundingNames();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select f " +
			   "  from Funding f 			" +   
			   "  left join f.names fn		" +
			   "  where fn.name=?1" )
	Funding findByName(String name);
}
