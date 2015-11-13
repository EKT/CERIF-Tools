package gr.ekt.cerif.services.link.project;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkProjectOrganisationUnitCrudRepository extends CrudRepository<Project_OrganisationUnit, Long> {

	Project_OrganisationUnit findByProjectAndOrganisationUnit(Project project, OrganisationUnit organisationUnit);
	
	List <Project_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	List <Project_OrganisationUnit> findByProjectAndTheClass(Project project, Class theClass);
	
	List <Project_OrganisationUnit> findByProject(Project project);
	
	List <Project_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass);

}
