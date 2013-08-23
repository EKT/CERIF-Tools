/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bonisv
 *
 */
@Component
public class ProjectTitleRepositoryImpl implements ProjectTitleRepository {

	private static final Logger log = LoggerFactory.getLogger(ProjectTitleRepositoryImpl.class);
	
	@Autowired
	private ProjectTitleCrudRepository projectTitleCrudRepository;

	@Override
	public ProjectTitle findByTitle(String title) {
		return projectTitleCrudRepository.findByTitle(title);
	}

	@Override
	public ProjectTitle findByProject(Project project) {
		return projectTitleCrudRepository.findByProject(project);
	}

	@Override
	public void delete(ProjectTitle entity) {
		projectTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ProjectTitle> entities) {
		projectTitleCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<ProjectTitle> save(Iterable<ProjectTitle> entities) {
		return projectTitleCrudRepository.save(entities);
	}

	@Override
	public ProjectTitle save(ProjectTitle entity) {
		return projectTitleCrudRepository.save(entity);
	}
	
}
