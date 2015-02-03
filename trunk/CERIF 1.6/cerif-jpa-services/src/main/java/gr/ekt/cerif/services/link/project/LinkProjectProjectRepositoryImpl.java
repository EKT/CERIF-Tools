package gr.ekt.cerif.services.link.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkProjectProjectRepositoryImpl implements LinkProjectProjectRepository {
	
	@Autowired
	private LinkProjectProjectCrudRepository linkProjectProjectCrudRepository;
	
	@Transactional
	public Project_Project save(Project_Project entity) {
		return linkProjectProjectCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Project_Project> save(Iterable<Project_Project> entityList) {
		return linkProjectProjectCrudRepository.save(entityList);
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
	public void delete(Iterable<Project_Project> entities) {
		linkProjectProjectCrudRepository.delete(entities);
	}
}
