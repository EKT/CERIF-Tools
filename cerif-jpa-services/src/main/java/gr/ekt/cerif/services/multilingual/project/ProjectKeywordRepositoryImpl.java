/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ProjectKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class ProjectKeywordRepositoryImpl implements ProjectKeywordRepository{
	
	private static final Logger log = LoggerFactory.getLogger(ProjectKeywordRepositoryImpl.class);
	
	@Autowired
	private ProjectKeywordCrudRepository projectKeywordCrudRepository;

	@Override
	public void delete(ProjectKeyword entity) {
		projectKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ProjectKeyword> entities) {
		projectKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ProjectKeyword> save(Iterable<ProjectKeyword> entities) {
		return projectKeywordCrudRepository.save(entities);
	}

	@Override
	public ProjectKeyword save(ProjectKeyword entity) {
		return projectKeywordCrudRepository.save(entity);
	}

}
