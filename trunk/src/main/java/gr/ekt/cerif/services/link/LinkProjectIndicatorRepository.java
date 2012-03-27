package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.services.second.IndicatorRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and indicators.
 * 
 */
@Component
public class LinkProjectIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Project_Indicator entity) {
		if (entity.getProject() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a project and a indicator.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_Indicator> entityList) {
		for (Project_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
