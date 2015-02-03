/**
 * 
 */
package gr.ekt.cerif.services.multilingual.project;

import java.util.List;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.features.multilingual.ProjectTitle;

import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface ProjectTitleCrudRepository extends CrudRepository<ProjectTitle, Long>  {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ProjectTitle findByTitle(String title);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ProjectTitle> findByProject(Project project);
	
}

