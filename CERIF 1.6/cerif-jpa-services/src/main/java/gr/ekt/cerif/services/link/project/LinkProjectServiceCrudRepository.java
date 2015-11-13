package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.project.Project_Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectServiceCrudRepository extends CrudRepository<Project_Service, Long> {
	
	List<Project_Service> findByService(Service service);
	
	List<Project_Service> findByProject(Project project);

}
