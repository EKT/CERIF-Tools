/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_PrizeAward;
import gr.ekt.cerif.services.second.PrizeRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and Facilities.
 * 
 */
@Component
public class LinkProjectPrizeAwardRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private PrizeRepository prizeRepository;
	
	@Transactional
	public void save(Project_PrizeAward entity) {
		if (entity.getProject() == null || entity.getPrizeAward() == null) {
			throw new IllegalArgumentException("Please provide both a project and a PrizeAward.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getPrizeAward().getId() == null) {
			prizeRepository.save(entity.getPrizeAward());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_PrizeAward> entityList) {
		for (Project_PrizeAward entity : entityList) {
			save(entity);
		}
	}
	
}
