package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectMediumCrudRepository extends CrudRepository<Project_Medium, Long> {
	
	List<Project_Medium> findByProject(Project project);
	
	List<Project_Medium> findByMedium(Medium medium);

}
