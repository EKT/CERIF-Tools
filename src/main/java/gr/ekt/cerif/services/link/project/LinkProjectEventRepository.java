/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and eventes.
 * 
 */
@Component
public class LinkProjectEventRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void save(Project_Event entity) {
		if (entity.getProject() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both a project and a event.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Event> entityList) {
		for (Project_Event entity : entityList) {
			save(entity);
		}
	}
	
}
