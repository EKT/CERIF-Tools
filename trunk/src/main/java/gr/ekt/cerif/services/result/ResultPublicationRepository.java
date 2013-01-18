/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.base.ProjectView;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnitResultPublicationView;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.PersonResultPublicationView;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.ProjectResultPublicationView;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublicationMediumView;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.result.ResultPublicationView;
import gr.ekt.cerif.entities.second.EventView;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.Date;
import java.util.List;

/**
 * A repository for publications.
 * 
 */
public interface ResultPublicationRepository {

	ResultPublication findByUri(String uri);

	ResultPublicationView findViewById(Long Id);
	
	Medium findCoverById(Long Id);
	
	List<ProjectView> findProjectsById(Long Id);
		
	OrganisationUnitResultPublicationView findDocumentSourceById(Long Id);

	List<OrganisationUnitResultPublicationView> findAllDocumentSourcesForResultPubl();
	
	List<OrganisationUnitResultPublicationView> findOrganisationsById(Long Id);
	
	List<OrganisationUnitResultPublicationView> findAllOrganisationsById(Long Id);
	
	List<OrganisationUnitResultPublicationView> findAllOrganisationsForResultPubl();
	
	List<OrganisationUnitResultPublicationView> findOrganisationsForResultPubl();
	
	List<PersonResultPublicationView> findPersonsById(Long Id);
	
	List<ResultPublicationView> findAllViews();
	
	List<ResultPublicationView> findFavouriteResPubl(Long Id);
	
	List<ResultPublicationView> findMyUploads(Long Id);
	   
	ResultPublication findById(Long Id);

	Person findPersonById(Long Id);
	
	Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId);
	
	OrganisationUnit findOrganisationUnitById(Long Id);
	
	OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId);
	
	Project findProjectById(Long Id);
	
	Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId);
	
	List<ResultPublicationView> findResPublByPersonId(Long Id);	
	
	List<ResultPublicationMediumView> findResPublMediumByResPubId(Long Id);	
	
	List<ResultPublicationView> findByProjectId(Long Id);
	
	List<ResultPublicationView> findAllViewsByProjectId(Long Id);
	
	List<ResultPublicationView> findAllViewsByEventId(Long Id);
	
	List<Object[]> countByProjectId();
	
	List<ResultPublicationView> findByOrganisationUnitId(Long Id);
	
	List<ResultPublicationView> findByEventId(Long Id);
	
	List<ResultPublicationView> findByResultPublicationId(Long Id);
	
	List<ResultPublicationMediumView> findAllFiles();
	
	List<ProjectResultPublicationView> findAllProjects();
	
	List<PersonResultPublicationView> findAllPersons();
	
	List<ClassView> findClassByResPublIdAndScheme(Long id, String classSchemeUri);
	
	ClassView findVisibilityByResPublId(Long id);
	
	List<EventView> findEventByResPubId(Long id);
		
	ResultPublication_Event findResPublEventByResPublId(Long Id);
	
	List<Object[]> countByProject();
	
	List<Object[]> countByProjectPublished();
	
	List<Object[]> countByEvent();
	
	List<Object[]> countByEventPublished();
	
	List<Object[]> countByYear();
	
	List<Object[]> countByYearPublished();
	
	List<ResultPublicationView> findAllViewsByYear(Date date);
	
	List<Object[]> countByType();
	
	List<Object[]> countByTypePublished();
	
	List<ResultPublicationView> findAllViewsByType(Long typeId);

	List<Object[]> countBySource();
	
	List<Object[]> countBySourcePublished();
	
	List<ResultPublicationView> findAllViewsBySource(Long sourceId);		
	
	ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId);
	
	Person findCreatorByResPubId(Long respubId);
	
	List<ResultPublicationView> findAllCreatorResPub();
	
	public List<ResultPublicationView> queryResPubView(List<String> parameters, String queryAdd);
	
	void delete(ResultPublication entity);
	
	Iterable<ResultPublication> save(Iterable<ResultPublication> entities);
	
	ResultPublication save(ResultPublication entity);
	
}
