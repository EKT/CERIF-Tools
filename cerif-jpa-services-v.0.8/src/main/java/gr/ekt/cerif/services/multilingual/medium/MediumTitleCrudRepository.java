/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumTitle;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface MediumTitleCrudRepository extends CrudRepository<MediumTitle, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<MediumTitle> findByMedium(Medium medium);

}
