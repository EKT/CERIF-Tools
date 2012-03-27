/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and ResultPublications.
 * 
 */
@Component
public class LinkProjectResultPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Transactional
	public void save(Project_ResultPublication entity) {
		if (entity.getProject() == null || entity.getResultPublication() == null) {
			throw new IllegalArgumentException("Please provide both a project and a ResultPublication.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_ResultPublication> entityList) {
		for (Project_ResultPublication entity : entityList) {
			save(entity);
		}
	}
	
}
