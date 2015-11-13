package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_DublinCore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectDublinCoreCrudRepository extends CrudRepository<Project_DublinCore, Long> {
	
	List<Project_DublinCore> findByProject(Project project);

}
