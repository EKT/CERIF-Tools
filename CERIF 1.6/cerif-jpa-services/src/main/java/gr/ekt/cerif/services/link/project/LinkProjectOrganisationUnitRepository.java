/**
 * 
 */
package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for organisations.
 * 
 */
public interface LinkProjectOrganisationUnitRepository {

	public Project_OrganisationUnit findByProjectAndOrganisationUnit(Project project, OrganisationUnit organisationUnit);

	List<Project_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	List<Project_OrganisationUnit> findByProjectAndTheClass(Project project, Class theClass);
	
	List <Project_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass);
	
	List <Project_OrganisationUnit> findByProject(Project project);
	
	public Project_OrganisationUnit save(Project_OrganisationUnit entity);
	
	public Iterable<Project_OrganisationUnit> save(Iterable<Project_OrganisationUnit> entities);
	
	public void delete(Project_OrganisationUnit entity);
	
	public void delete(Iterable<Project_OrganisationUnit> entities);
	
}
