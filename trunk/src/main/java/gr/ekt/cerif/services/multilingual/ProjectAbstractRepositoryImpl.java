package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectAbstractRepositoryImpl implements ProjectAbstractRepository {
	private static final Logger log = LoggerFactory.getLogger(ProjectAbstractRepositoryImpl.class);
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	private ProjectAbstractCrudRepository projectAbstractCrudRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	public List<ProjectAbstract> findByProject(Project project) {
		return projectAbstractCrudRepository.findByProject(project);
	}

	@Transactional
	public ProjectAbstract save(ProjectAbstract entity) {
		if (entity.getProject() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			if (entity.getProject() == null)
				log.info("project");
			
			if (entity.getTranslation() == null)
				log.info("translation");
			
			if (entity.getLanguage() ==null)
				log.info("language");
			
			throw new IllegalArgumentException("Please provide a project, a translation and a language.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		languageRepository.save(entity.getLanguage());
		return entityManager.merge(entity);
	}

	@Transactional
	public Iterable<? extends ProjectAbstract> save(Iterable<? extends ProjectAbstract> entities) {
		for (ProjectAbstract entity : entities) {
			save(entity);
		}
		return entities;
	}

	@Transactional
	public void delete(ProjectAbstract entity) {
		projectAbstractCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(List<ProjectAbstract> entities) {
		projectAbstractCrudRepository.delete(entities);
	}

}
