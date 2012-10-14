package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and mediums.
 * 
 */
@Component
public class LinkProjectMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Project_Medium entity) {
		if (entity.getProject() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a project and a Medium.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Medium> entityList) {
		for (Project_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
