/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface ProjectTitleCrudRepository extends CrudRepository<ProjectTitle, Long>  {

	ProjectTitle findByTitle(String title);
	
	List<ProjectTitle> findByProject(Project project);
	
}

