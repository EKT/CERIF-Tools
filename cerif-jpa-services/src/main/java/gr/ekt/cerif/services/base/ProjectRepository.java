/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;

import java.util.List;

/**
 * A repository for projects.
 * 
 */
public interface ProjectRepository {

	
	public Project findByAcronym(String acronym);
	
	public Project findById(Long id);
	
	Iterable<Project> findAll(List<Long> ids);

	public List<Project> findByUri(String uri);
		
	void delete(Project entity);
	
	void delete(Iterable<Project> entities);
	
	Iterable<Project> save(Iterable<Project> entityList);
	
	Project save(Project entity);
	
	Iterable<Project> findAll();
		
}

	
