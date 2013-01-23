package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.services.base.ProjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkProjectProjectRepositoryImpl implements LinkProjectProjectRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private LinkProjectProjectCrudRepository linkProjectProjectCrudRepository;
	
	@Transactional
	public Project_Project save(Project_Project entity) {
		if (entity.getProject1() == null || entity.getProject2() == null) {
			throw new IllegalArgumentException("Please provide both projects you want to connect.");
		}
		if (entity.getProject1().getId() == null) {
			projectRepository.save(entity.getProject1());
		}
		if (entity.getProject2().getId() == null) {
			projectRepository.save(entity.getProject2());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<Project_Project> save(Iterable<Project_Project> entityList) {
		for (Project_Project entity : entityList) {
			save(entity);
		}
		return entityList;
	}

	public List<Project_Project> findByProject1(Project project) {
		return linkProjectProjectCrudRepository.findByProject1(project);
	}

	public List<Project_Project> findByProject2(Project project) {
		return linkProjectProjectCrudRepository.findByProject2(project);
	}

	@Transactional
	public void delete(Project_Project entity) {
		linkProjectProjectCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<? extends Project_Project> entities) {
		linkProjectProjectCrudRepository.delete(entities);
	}
}
