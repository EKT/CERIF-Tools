/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for languages.
 * 
 */
public interface GeographicBoundingBoxCrudRepository extends CrudRepository<GeographicBoundingBox, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<GeographicBoundingBox> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<GeographicBoundingBox> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public GeographicBoundingBox findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<GeographicBoundingBox> findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public GeographicBoundingBox findByUuid(String uuid);

}
