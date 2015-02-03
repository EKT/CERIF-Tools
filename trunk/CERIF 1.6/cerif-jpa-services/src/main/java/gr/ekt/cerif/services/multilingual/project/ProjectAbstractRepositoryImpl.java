package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.second.LanguageCrudRepository;

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
	
	@Autowired
	private ProjectAbstractCrudRepository projectAbstractCrudRepository;
	
	public List<ProjectAbstract> findByProject(Project project) {
		return projectAbstractCrudRepository.findByProject(project);
	}

	@Transactional
	public ProjectAbstract save(ProjectAbstract entity) {
		return projectAbstractCrudRepository.save(entity);
	}

	@Transactional
	public void delete(ProjectAbstract entity) {
		projectAbstractCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(List<ProjectAbstract> entities) {
		projectAbstractCrudRepository.delete(entities);
	}

	@Override
	public void delete(Iterable<ProjectAbstract> entities) {
		projectAbstractCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ProjectAbstract> save(Iterable<ProjectAbstract> entities) {
		return projectAbstractCrudRepository.save(entities);
	}

}
