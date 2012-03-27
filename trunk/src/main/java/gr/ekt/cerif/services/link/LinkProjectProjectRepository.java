/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and organisations.
 * 
 */
@Component
public class LinkProjectProjectRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;	
	
	@Transactional
	public void save(Project_Project entity) {
		if (entity.getProject1() == null || entity.getProject2() == null) {
			throw new IllegalArgumentException("Please provide both projects you want to connect.");
		}
		if (entity.getProject1().getId() == null) {
			projectRepository.save(entity.getProject1());
		}
		if (entity.getProject2().getId() == null) {
			projectRepository.save(entity.getProject2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Project> entityList) {
		for (Project_Project entity : entityList) {
			save(entity);
		}
	}
	
}
