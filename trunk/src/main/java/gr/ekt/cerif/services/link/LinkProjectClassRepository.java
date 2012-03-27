/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_Classification;
import gr.ekt.cerif.services.semantics.ClassRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and classes.
 * 
 */
@Component
public class LinkProjectClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Project_Classification entity) {
		if (entity.getProject() == null || entity.getClass() == null) {
			throw new IllegalArgumentException("Please provide both a project and a class.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Classification> entityList) {
		for (Project_Classification entity : entityList) {
			save(entity);
		}
	}
	
}
