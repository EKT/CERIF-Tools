/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsRepository {

	void delete(ExpertiseAndSkills entity); 
	
	void delete(Iterable<ExpertiseAndSkills> entities); 

	Iterable<ExpertiseAndSkills> save(Iterable<ExpertiseAndSkills> entities); 
	
	ExpertiseAndSkills save(ExpertiseAndSkills entity);
	
	List<ExpertiseAndSkills> findAll();
	
	Page<ExpertiseAndSkills> findAll(Pageable page);

	ExpertiseAndSkills findById(Long id);

	List<ExpertiseAndSkills> findByUri(String uri);

	ExpertiseAndSkills findByUuid(String uuid);
}
