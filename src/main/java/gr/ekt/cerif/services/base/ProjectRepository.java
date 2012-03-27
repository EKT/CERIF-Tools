/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for projects.
 * 
 */
public interface ProjectRepository extends CrudRepository<Project, String> {

}
