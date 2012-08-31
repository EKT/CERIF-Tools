/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and ResultPatents.
 * 
 */
@Component
public class LinkProjectResultPatentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Transactional
	public void save(Project_ResultPatent entity) {
		if (entity.getProject() == null || entity.getResultPatent() == null) {
			throw new IllegalArgumentException("Please provide both a project and a ResultPatent.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_ResultPatent> entityList) {
		for (Project_ResultPatent entity : entityList) {
			save(entity);
		}
	}
	
}
