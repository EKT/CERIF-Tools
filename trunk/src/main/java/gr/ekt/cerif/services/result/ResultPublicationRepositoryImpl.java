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

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ResultPublicationRepositoryImpl implements ResultPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationCrudRepository resultPublicationCrudRepository;
	
	public ResultPublication findByUri(String uri) {
		return resultPublicationCrudRepository.findByUri(uri);
	}
	
	public ResultPublicationView findViewById(Long id) {
		return resultPublicationCrudRepository.findViewById(id);
	}
	
	public Medium findCoverById(Long id) {
		return resultPublicationCrudRepository.findCoverById(id);
	}
	
	public List<ProjectView> findProjectsById(Long id) {
		return resultPublicationCrudRepository.findProjectsById(id);
	}
	
	public OrganisationUnitResultPublicationView findDocumentSourceById(Long id) {
		return resultPublicationCrudRepository.findDocumentSourceById(id);
	}
	
	public List<OrganisationUnitResultPublicationView> findAllDocumentSourcesForResultPubl() {
		return resultPublicationCrudRepository.findAllDocumentSourcesForResultPubl();
	}
	
	public List<OrganisationUnitResultPublicationView> findOrganisationsById(Long id) {
		return resultPublicationCrudRepository.findOrganisationsById(id);
	}
	
	public List<OrganisationUnitResultPublicationView> findAllOrganisationsById(Long id) {
		return resultPublicationCrudRepository.findAllOrganisationsById(id);
	}
	
	public List<OrganisationUnitResultPublicationView> findAllOrganisationsForResultPubl() {
		return resultPublicationCrudRepository.findAllOrganisationsForResultPubl();
	}
	
	public List<OrganisationUnitResultPublicationView> findOrganisationsForResultPubl() {
		return resultPublicationCrudRepository.findOrganisationsForResultPubl();
	}
	
	public List<PersonResultPublicationView> findPersonsById(Long id) {
		return resultPublicationCrudRepository.findPersonsById(id);
	}
	
	public List<ResultPublicationView> findAllViews() {
		return resultPublicationCrudRepository.findAllViews();
	}
	
	public List<ResultPublicationView> findFavouriteResPubl(Long id) {
		return resultPublicationCrudRepository.findFavouriteResPubl(id);
	}
	
	public List<ResultPublicationView> findMyUploads(Long id) {
		return resultPublicationCrudRepository.findMyUploads(id);
	}
	
	public ResultPublication findById(Long id) {
		return resultPublicationCrudRepository.findById(id);
	}
	
	public Person findPersonById(Long id) {
		return resultPublicationCrudRepository.findPersonById(id);
	}
	
	public Person_ResultPublication findByPersonIdAndResultPublicationId(Long PerId, Long ResId) {
		return resultPublicationCrudRepository.findByPersonIdAndResultPublicationId(PerId, ResId);
	}

	public OrganisationUnit findOrganisationUnitById(Long id) {
		return resultPublicationCrudRepository.findOrganisationUnitById(id);
	}
	
	public OrganisationUnit_ResultPublication findByOrganisationUnitIdAndResultPublicationId(Long ouId, Long resId) {
		return resultPublicationCrudRepository.findByOrganisationUnitIdAndResultPublicationId(ouId, resId);
	}
	
	public Project findProjectById(Long id) {
		return resultPublicationCrudRepository.findProjectById(id);
	}
	
	public Project_ResultPublication findByProjectIdAndResultPublicationId(Long prId, Long resId) {
		return resultPublicationCrudRepository.findByProjectIdAndResultPublicationId(prId, resId);
	}
	
	public List<ResultPublicationView> findResPublByPersonId(Long id) {
		return resultPublicationCrudRepository.findResPublByPersonId(id);
	}
	
	public List<ResultPublicationMediumView> findResPublMediumByResPubId(Long id) {
		return resultPublicationCrudRepository.findResPublMediumByResPubId(id);
	}
	
	public List<ResultPublicationView> findByProjectId(Long id) {
		return resultPublicationCrudRepository.findByProjectId(id);
	}
	
	public List<ResultPublicationView> findAllViewsByProjectId(Long id) {
		return resultPublicationCrudRepository.findAllViewsByProjectId(id);
	}
	
	public List<Object[]> countByProjectId() {
		return resultPublicationCrudRepository.countByProjectId();
	}
	
	public List<ResultPublicationView> findByOrganisationUnitId(Long id) {
		return resultPublicationCrudRepository.findByOrganisationUnitId(id);
	}
	
	public List<ResultPublicationView> findByEventId(Long id) {
		return resultPublicationCrudRepository.findByEventId(id);
	}
	
	public List<ResultPublicationView> findByResultPublicationId(Long id) {
		return resultPublicationCrudRepository.findByResultPublicationId(id);
	}
	
	public List<ResultPublicationMediumView> findAllFiles() {
		return resultPublicationCrudRepository.findAllFiles();
	}
	
	public List<ProjectResultPublicationView> findAllProjects() {
		return resultPublicationCrudRepository.findAllProjects();
	}
	
	public List<PersonResultPublicationView> findAllPersons() {
		return resultPublicationCrudRepository.findAllPersons();
	}
	
	public List<ClassView> findClassByResPublIdAndScheme(Long id, String classSchemeUri) {
		return resultPublicationCrudRepository.findClassByResPublIdAndScheme(id, classSchemeUri);
	}
	
	public ClassView findVisibilityByResPublId(Long id) {
		return resultPublicationCrudRepository.findVisibilityByResPublId(id);
	}

	public List<EventView> findEventByResPubId(Long id) {
		return resultPublicationCrudRepository.findEventByResPubId(id);
	}

	public ResultPublication_Event findResPublEventByResPublId(Long id) {
		return resultPublicationCrudRepository.findResPublEventByResPublId(id);
	}
	
	public List<Object[]> countByYear() {
		return resultPublicationCrudRepository.countByYear();
	}
	
	public List<Object[]> countByYearPublished() {
		
		return resultPublicationCrudRepository.countByYearPublished();
	}

	public List<ResultPublicationView> findAllViewsByYear(Date date) {
		return resultPublicationCrudRepository.findAllViewsByYear(date);
	}
	
	public List<Object[]> countByType() {
		return resultPublicationCrudRepository.countByType();
	}

	public List<Object[]> countByTypePublished() {
		return resultPublicationCrudRepository.countByTypePublished();
	}
	
	public List<ResultPublicationView> findAllViewsByType(Long typeId) {
		return resultPublicationCrudRepository.findAllViewsByType(typeId);
	}
	
	public List<Object[]> countBySource() {
		return resultPublicationCrudRepository.countBySource();
	}
	
	public List<Object[]> countBySourcePublished() {
		return resultPublicationCrudRepository.countBySourcePublished();
	}
	
	public List<ResultPublicationView> findAllViewsBySource(Long sourceId) {
		return resultPublicationCrudRepository.findAllViewsBySource(sourceId);
	}
	
	public ResultPublication_Class findResPubClassBySchemeUriAndResPubId(String schemeUri, Long respubId) {
		return resultPublicationCrudRepository.findResPubClassBySchemeUriAndResPubId(schemeUri, respubId);
	}
	
	public Person findCreatorByResPubId(Long respubId) {
		return resultPublicationCrudRepository.findCreatorByResPubId(respubId);
	}
	
	public List<ResultPublicationView> findAllCreatorResPub() {
		return resultPublicationCrudRepository.findAllCreatorResPub();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResultPublicationView> queryResPubView(List<String> parameters, String queryAdd) {
		Query namedQuery;
		List<ResultPublicationView> resResultPublView =null;
		
		String query = "select	new gr.ekt.cerif.entities.result.ResultPublicationView(	" +
				   "       respub.id,			" +
				   "       respubt.title,		" +
				   "       respubk.keyword,		" +
				   "       respub.date) 	" +
				   "  from ResultPublication respub 									" +
				   "  left join respub.resultPublicationTitles respubt					" +
				   "  left join respub.resultPublicationKeywords respubk				";
				
		query += queryAdd;
		
		if(!parameters.isEmpty()){
			query += " WHERE ";
			
			for (String param:parameters) {
				query += param + " ";
			}
			
			query += " group by respub.id";
			
			if(query.contains(" WHERE AND "))
				query = query.replace(" WHERE AND ", " WHERE ");
			if(query.contains(" WHERE OR "))
				query = query.replace(" WHERE OR ", " WHERE ");
			
			namedQuery=entityManager.createQuery(query);
			
			try {
				resResultPublView=namedQuery.getResultList();
			} catch (NoResultException nre) {
				resResultPublView=null;
			} 
						
			//System.out.println("query: " + query);
		}
		
		return resResultPublView;
	}

	@Transactional
	public void delete(ResultPublication entity) {
		resultPublicationCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<ResultPublication> save(Iterable<ResultPublication> entities) {
		return resultPublicationCrudRepository.save(entities);
	}

	@Transactional
	public ResultPublication save(ResultPublication entity) {
		return resultPublicationCrudRepository.save(entity);
	}

	public List<ResultPublicationView> findAllViewsByEventId(Long Id) {
		return resultPublicationCrudRepository.findAllViewsByEventId(Id);
	}

	public List<Object[]> countByProject() {
		return resultPublicationCrudRepository.countByProject();
	}
	
	public List<Object[]> countByProjectPublished() {
		return resultPublicationCrudRepository.countByProjectPublished();
	}

	public List<Object[]> countByEvent() {
		return resultPublicationCrudRepository.countByEvent();
	}

	public List<Object[]> countByEventPublished() {
		return resultPublicationCrudRepository.countByEventPublished();
	}
	
}
