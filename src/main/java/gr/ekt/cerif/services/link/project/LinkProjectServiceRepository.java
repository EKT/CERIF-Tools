/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and Services.
 * 
 */
@Component
public class LinkProjectServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(Project_Service entity) {
		if (entity.getProject() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a project and a Service.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Service> entityList) {
		for (Project_Service entity : entityList) {
			save(entity);
		}
	}
	
}
