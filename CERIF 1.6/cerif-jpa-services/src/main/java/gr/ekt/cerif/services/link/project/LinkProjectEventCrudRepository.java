package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.second.Event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectEventCrudRepository extends CrudRepository<Project_Event, Long> {
	
	List<Project_Event> findByProject(Project project);
	
	List<Project_Event> findByEvent(Event event);

}
