package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.project.Project_Facility;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectFacilityCrudRepository extends CrudRepository<Project_Facility, Long> {

	List<Project_Facility> findByProject(Project project);
	
	List<Project_Facility> findByFacility(Facility facility);
}
