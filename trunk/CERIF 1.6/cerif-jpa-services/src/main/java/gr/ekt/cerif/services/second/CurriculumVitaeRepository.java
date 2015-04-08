/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.CurriculumVitae;

/**
 * A repository for cvs.
 * 
 */
public interface CurriculumVitaeRepository {
	
	CurriculumVitae findById(Long id);
	
	List<CurriculumVitae> findAll();
	
	Page<CurriculumVitae> findAll(Pageable page);

	List<CurriculumVitae> findByUri(String uri);

	CurriculumVitae findByUuid(String uuid);
	
	void delete(CurriculumVitae entity); 
	
	void delete(Iterable<CurriculumVitae> entities); 

	Iterable<CurriculumVitae> save(Iterable<CurriculumVitae> entities); 
	
	CurriculumVitae save(CurriculumVitae entity);

}
