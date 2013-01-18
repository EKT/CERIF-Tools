/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for mediums.
 * 
 */
public interface MediumRepository extends CrudRepository<Medium, Long> {

	Medium findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select med	" +		   
			   "  from ResultPublication respub		" +
			   "  left join respub.resultPublications_medium mediumrespub	" +
			   "  left join mediumrespub.medium med   " +
			   "  where respub.id = ?1        ")
	List<Medium> findByResPubId(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select med	" +		   
			   "  from Person pers		" +
			   "  left join pers.persons_medium mediumpers	" +
			   "  left join mediumpers.medium med   " +
			   "  where pers.id = ?1        ")
	List<Medium> findByPersonId(Long id);

}
