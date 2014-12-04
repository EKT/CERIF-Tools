/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * A repository for projects.
 * 
 */
public interface ProjectRepository {

	void delete(Project entity);
	
	void delete(Iterable<Project> entities);
	
	Iterable<Project> save(Iterable<Project> entityList);
	
	Project save(Project entity);
	
	Project findById(Long id);

	List<Project> findByUri(String uri);

	Page<Project> findAll(Pageable page);

	Iterable<Project> findAll();

	Project findByUuid(String uuid);	
}

	
