/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.second.Qualification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for qualifications.
 * 
 */
public interface QualificationCrudRepository extends CrudRepository<Qualification, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Qualification> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Qualification> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Qualification findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Qualification> findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Qualification findByUuid(String uuid);

}
