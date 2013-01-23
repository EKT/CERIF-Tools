package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Project;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectProjectCrudRepository extends CrudRepository<Project_Project, Long> {
	
	List<Project_Project> findByProject1(Project project);
	
	List<Project_Project> findByProject2(Project project);

}
