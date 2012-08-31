package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.link.project.Project_DublinCore;
import gr.ekt.cerif.services.additional.DublinCoreRepository;
import gr.ekt.cerif.services.base.ProjectRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between projects and DublinCores.
 * 
 */
@Component
public class LinkProjectDublinCoreRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private DublinCoreRepository dublinCoreRepository;
	
	@Transactional
	public void save(Project_DublinCore entity) {
		if (entity.getProject() == null || entity.getDublinCore() == null) {
			throw new IllegalArgumentException("Please provide both a project and a DublinCore.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		if (entity.getDublinCore().getId() == null) {
			dublinCoreRepository.save(entity.getDublinCore());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Project_DublinCore> entityList) {
		for (Project_DublinCore entity : entityList) {
			save(entity);
		}
	}
	
}
