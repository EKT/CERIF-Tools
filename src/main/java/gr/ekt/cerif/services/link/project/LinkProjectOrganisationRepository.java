/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**
 * A repository for organisations.
 * 
 */
public interface LinkProjectOrganisationRepository extends CrudRepository<Project_OrganisationUnit, Long> {

		public Project_OrganisationUnit findByProjectAndOrganisationUnit(Project project, OrganisationUnit organisationUnit);
		List <Project_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

		List <Project_OrganisationUnit> findByProjectAndTheClass(Project project, Class theClass);
}
