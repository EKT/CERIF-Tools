/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsKeywordCrudRepository extends CrudRepository<ExpertiseAndSkillsKeyword, Long> {
	
	@Query(value = "select exskkey "
			+ "  from ExpertiseAndSkillsKeyword exskkey         	"
			+ "  join exskkey.expertiseAndSkills exsk            	"
			+ "  where exsk = ?1 ")
	List<ExpertiseAndSkillsKeyword> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
