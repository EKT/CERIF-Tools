/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.CurriculumVitae;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface CurriculumVitaeCrudRepository extends CrudRepository<CurriculumVitae, Long> {

	public CurriculumVitae findById(Long id);
	
	public List<CurriculumVitae> findAll();
	
	public Page<CurriculumVitae> findAll(Pageable page);

	public List<CurriculumVitae> findByUri(String uri);

	public CurriculumVitae findByUuid(String uuid);
	
}
