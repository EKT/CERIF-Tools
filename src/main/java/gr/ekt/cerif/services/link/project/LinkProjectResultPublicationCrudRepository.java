package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublication;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectResultPublicationCrudRepository extends CrudRepository<Project_ResultPublication, Long> {

	List<Project_ResultPublication> findByProject(Project project);
	
	List<Project_ResultPublication> findByResultPublication(ResultPublication resultPublication);
	
}
