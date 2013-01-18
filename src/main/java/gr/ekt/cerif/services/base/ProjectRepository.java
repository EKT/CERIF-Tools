/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.base.ProjectList;
import gr.ekt.cerif.entities.base.ProjectView;
import gr.ekt.cerif.entities.link.project.Project_Person;

import java.util.List;

/**
 * A repository for projects.
 * 
 */
public interface ProjectRepository {

	Project updatePartners(Long projectId, List<Long> partnerIds);
	
	Project updateCoordinator(Long projectId, Long orgUnitId);
	
	Project updateAbstract(Long projectId, String abstractText);
	
	Project updateFunding(Long projectId, String fundingAcronym);
	
	Project updateClassTerms(Long projectId, String classSchemeUri, List<String> classTerms);
	
	public Project findByAcronym(String acronym);
	
	public Project findById(Long id);
	
	List<ProjectList> findAllProjects();
	
	List<ProjectList> findAllProjectsWithNoDomainClass();
	
	List<ProjectList> findAllProjectsWithNoDomainClassFavourite(Long personId);
	
	List<ProjectList> findAllProjectsWithDomainClass();
	
	List<ProjectList> findAllProjectsWithDomainClassFavourite(Long personId);
	
	ProjectView findProjectById(Long id);
	
	List<ProjectView> findByOrgUnitId(Long id);
	
	List<ProjectView> findByOrgUnitId(Long id, String organisationStatus);
	
	List<ProjectList> findByPersonId(Long id);

	public List<Project> findByUri(String uri);
	
	List<Object[]> findByStartingAcronym(String term);
	
	Object[] findProjByIdForAjax(Long id);
	
	Project_Person isProjectFavourite(Long id, String username);
	
	List<Object[]> countByScientificDomain();
	
	List<ProjectList> findProjectsWithDomainClass(String domainClass);
	
	List<Object[]> countByActivity();
	
	List<ProjectList> findProjectsWithActivity(String activity);
	
	List<Object[]> countByMainCategory();
	
	List<ProjectList> findProjectsWithMainCategory(String mainCategory);
	
	List<Object[]> countByActionLine();
	
	List<ProjectList> findProjectsWithActionLine(String actionLine);
	
	List<Object[]> countByCoordinatorCountry();
	
	List<Object[]> countAnalyticProjectsByCountryVisualisation();
	
	List<Object[]> countProjectsByCountryVisualisation(String classUri);
	
	List<Object[]> countProjectsByScientificDomainVisualisation();
	
	List<ProjectList> findProjectsWithCoordinatorCountry(String countryCode);
	
	void delete(Project entity);
	
	Iterable<Project> save(Iterable<Project> entityList);
	
	Project save(Project entity);
	
	Iterable<Project> findAll();
	
}

	
