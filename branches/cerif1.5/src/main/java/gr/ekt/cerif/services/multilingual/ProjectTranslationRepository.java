/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ProjectTitle;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for project translation entities.
 * 
 */

public interface ProjectTranslationRepository extends CrudRepository<ProjectTitle, Long>  {

	ProjectTitle findByTitle(String title);

}

