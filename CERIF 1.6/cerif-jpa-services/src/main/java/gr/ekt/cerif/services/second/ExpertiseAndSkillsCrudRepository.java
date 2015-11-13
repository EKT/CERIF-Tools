/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for ExpertiseAndSkills.
 * 
 */
public interface ExpertiseAndSkillsCrudRepository extends CrudRepository<ExpertiseAndSkills, Long> {
	
	public List<ExpertiseAndSkills> findAll();
	
	public Page<ExpertiseAndSkills> findAll(Pageable page);

	public ExpertiseAndSkills findById(Long id);

	public List<ExpertiseAndSkills> findByUri(String uri);

	public ExpertiseAndSkills findByUuid(String uuid);

}
