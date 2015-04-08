/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsNameCrudRepository extends CrudRepository<ExpertiseAndSkillsName, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select exskname "
			+ "  from ExpertiseAndSkillsName exskname         	"
			+ "  join exskname.expertiseAndSkills exsk            	"
			+ "  where exsk = ?1 ")
	List<ExpertiseAndSkillsName> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
