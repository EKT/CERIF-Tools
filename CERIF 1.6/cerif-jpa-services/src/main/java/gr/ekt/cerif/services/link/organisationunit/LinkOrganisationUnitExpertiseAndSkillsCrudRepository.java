package gr.ekt.cerif.services.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkOrganisationUnitExpertiseAndSkillsCrudRepository extends CrudRepository<OrganisationUnit_ExpertiseAndSkills, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<OrganisationUnit_ExpertiseAndSkills> findByOrganisationUnit(OrganisationUnit organisationUnit);
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select orgexsk "
			+ "  from OrganisationUnit_ExpertiseAndSkills orgexsk         	"
			+ "  join orgexsk.expertiseAndSkills exsk            	"
			+ "  where exsk = ?1 ")
	List<OrganisationUnit_ExpertiseAndSkills> findByExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills);

}
