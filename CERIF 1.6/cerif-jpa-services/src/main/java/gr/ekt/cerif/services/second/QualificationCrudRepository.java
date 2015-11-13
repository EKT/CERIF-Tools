/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Qualification;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for qualifications.
 * 
 */
public interface QualificationCrudRepository extends CrudRepository<Qualification, Long> {
	
	public List<Qualification> findAll();
	
	public Page<Qualification> findAll(Pageable page);

	public Qualification findById(Long id);

	public List<Qualification> findByUri(String uri);

	public Qualification findByUuid(String uuid);

}
