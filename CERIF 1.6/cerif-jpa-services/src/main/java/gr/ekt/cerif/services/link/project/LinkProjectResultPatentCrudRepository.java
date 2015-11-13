package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectResultPatentCrudRepository extends CrudRepository<Project_ResultPatent, Long> {
	
	List<Project_ResultPatent> findByProject(Project project);
	
	List<Project_ResultPatent> findByResultPatent(ResultPatent resultPatent);

}
