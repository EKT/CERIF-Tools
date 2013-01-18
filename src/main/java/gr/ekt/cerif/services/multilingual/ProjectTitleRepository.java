/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ProjectTitle;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface ProjectTitleRepository extends CrudRepository<ProjectTitle, Long>  {

	ProjectTitle findByTitle(String title);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select pt from gr.ekt.cerif.features.multilingual.ProjectTitle pt join pt.project p where p.id=?1")
	ProjectTitle findProjectTitleById(Long id);
}

