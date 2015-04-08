/**
 * 
 */
package gr.ekt.cerif.services.multilingual.expertiseandskills;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface ExpertiseAndSkillsDescriptionCrudRepository extends CrudRepository<ExpertiseAndSkillsDescription, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select exskds "
			+ "  from ExpertiseAndSkillsDescription exskds          	"
			+ "  join exskds.expertiseAndSkills exsk            	"
			+ "  where exsk = ?1 ")
	List<ExpertiseAndSkillsDescription> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
