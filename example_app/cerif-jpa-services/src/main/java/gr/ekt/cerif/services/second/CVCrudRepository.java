/**
 * 
 */
package gr.ekt.cerif.services.second;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.CV;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CVCrudRepository extends CrudRepository<CV, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	CV findById(Long id);
	
}
