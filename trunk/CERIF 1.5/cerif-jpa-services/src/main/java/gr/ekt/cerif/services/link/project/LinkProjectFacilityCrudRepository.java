package gr.ekt.cerif.services.link.project;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.project.Project_Facility;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkProjectFacilityCrudRepository extends CrudRepository<Project_Facility, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_Facility> findByProject(Project project);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Project_Facility> findByFacility(Facility facility);
}
