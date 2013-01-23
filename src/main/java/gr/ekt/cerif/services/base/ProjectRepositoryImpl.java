package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.base.ProjectList;
import gr.ekt.cerif.entities.base.ProjectView;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.link.project.LinkProjectClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFundingRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
import gr.ekt.cerif.services.link.project.LinkProjectProjectRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.multilingual.ProjectAbstractRepository;
import gr.ekt.cerif.services.multilingual.ProjectTitleRepository;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectRepositoryImpl implements ProjectRepository {

	private static final Logger log = LoggerFactory.getLogger(ProjectRepositoryImpl.class);
	
	@Autowired
	private ProjectCrudRepository projectCrudRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private LinkProjectClassRepository linkProjectClassRepository;
	
	@Autowired
	private LinkProjectFundingRepository linkProjectFundingRepository;

	@Autowired
	private ProjectAbstractRepository projectAbstractRepository;
	
	@Autowired
	private OrganisationUnitRepository organisationUnitRepository;
	
	@Autowired
	private LinkProjectOrganisationUnitRepository linkProjectOrganisationUnitRepository;
	
	@Autowired
	private ProjectTitleRepository projectTitleRepository;
	
	@Autowired
	private LinkProjectPersonRepository linkProjectPersonRepository;
	
	@Autowired
	private LinkProjectResultPublicationRepository linkProjectResultPublicationRepository;
	
	@Autowired
	private LinkProjectProjectRepository linkProjectProjectRepository;
	
	@Transactional
	public Project updatePartners(Long projectId, List<Long> newPartnerIds) {
		Project project = projectCrudRepository.findById(projectId);
		Class theClass = classRepository.findByUri("Partner");
		
		List<Project_OrganisationUnit> existingPartnerList = linkProjectOrganisationUnitRepository.findByProjectAndTheClass(project, theClass);
		ArrayList<Long> existingPartnerIdList = new ArrayList<Long>();
		for (Project_OrganisationUnit po : existingPartnerList) {
			existingPartnerIdList.add(po.getOrganisationUnit().getId());
		}
		
		//save the new ones
		if (newPartnerIds != null) {
			for (Long newPartnerId  : newPartnerIds) {
				if (!existingPartnerIdList.contains(newPartnerId)) {
					OrganisationUnit organisationUnit = organisationUnitRepository.findById(newPartnerId);
					Project_OrganisationUnit po = new Project_OrganisationUnit(project, organisationUnit, theClass, new Date(), new Date(), (double) 0);
					linkProjectOrganisationUnitRepository.save(po);
				}
			}
		}
		
		//remove the old ones
		if (existingPartnerIdList != null) {
			for (Long existingPartnerId : existingPartnerIdList) {
				if (newPartnerIds == null || !newPartnerIds.contains(existingPartnerId)) {
					OrganisationUnit organisationUnit = organisationUnitRepository.findById(existingPartnerId);
					Project_OrganisationUnit po = linkProjectOrganisationUnitRepository.findByProjectAndOrganisationUnit(project, organisationUnit);
					linkProjectOrganisationUnitRepository.delete(po);
				}
			}
		}
		return project;
	}
	
	@Transactional
	public Project updateCoordinator(Long projectId, Long orgUnitId) {
		Project project = projectCrudRepository.findById(projectId);
		OrganisationUnit newCoordinator = organisationUnitRepository.findById(orgUnitId);
		Class theClass = classRepository.findByUri("Coordinator");
		List<Project_OrganisationUnit> pos = linkProjectOrganisationUnitRepository.findByProjectAndTheClass(project, theClass);
		
		if (pos == null || pos.size() == 0) {
			Project_OrganisationUnit po = new Project_OrganisationUnit(project, newCoordinator, theClass, new Date(), new Date(), (double) 0);
			linkProjectOrganisationUnitRepository.save(po);
			return po.getProject();
		} else {
			Project_OrganisationUnit po = pos.get(0);
			po.setOrganisationUnit(newCoordinator);
			linkProjectOrganisationUnitRepository.save(po);
			return po.getProject();
		}
	}
	
	@Transactional
	public Project updateAbstract(Long projectId, String abstractText) {
		Project project = projectCrudRepository.findById(projectId);
		List<ProjectAbstract> abstracts = projectAbstractRepository.findByProject(project);

		if (abstracts == null || abstracts.size() == 0) {
			log.info("Did not find abstracts");
			ProjectAbstract pa = new ProjectAbstract(project, Language.ENGLISH, Translation.HUMAN, abstractText);
			pa = projectAbstractRepository.save(pa);
			log.info("Created one with id " + pa.getId());
			return pa.getProject();
		} else {
			ProjectAbstract pa = abstracts.get(0);

			if (!pa.getAbstractText().equals(abstractText)) {
				pa.setAbstractText(abstractText);
				pa = projectAbstractRepository.save(pa);
				return pa.getProject();
			} else {
				return pa.getProject();
			}
		}
	}
	
	@Transactional
	public Project updateClassTerms(Long projectId, String classSchemeUri, List<String> newTerms) {
		
		List<String> existingTerms = classRepository.findTermsByProjectIdAndClassScheme(projectId, classSchemeUri);
		Project project = projectCrudRepository.findById(projectId);
		
		//save the new ones
		if (newTerms != null) {
			for (String newTerm : newTerms) {
				if (!existingTerms.contains(newTerm)) {
					Class theClass = classRepository.findByUri(newTerm);
					if (theClass != null) {
						Project_Class pc = new Project_Class(project, theClass, new Date(), new Date(), (double) 0);
						linkProjectClassRepository.save(pc);
					} else {
						log.info("Could not find class term " + newTerm);
					}
				}
			}
		}
		
		//remove the old ones
		if (existingTerms != null) {
			for (String existingTerm : existingTerms) {
				if (newTerms == null || !newTerms.contains(existingTerm)) {
					Class theClass = classRepository.findByUri(existingTerm);
					Project_Class pc = linkProjectClassRepository.findByProjectAndTheClass(project, theClass);
					linkProjectClassRepository.delete(pc);
				}
			}
		}

		return projectCrudRepository.save(project);
	}
	
	@Transactional
	public Project updateFunding(Long projectId, String fundingAcronym) {
		Project project = projectCrudRepository.findById(projectId);
		if (project == null) {
			log.info("Could not find project with id " + projectId);
			return null;
		}
		Funding funding = fundingRepository.findByAcronym(fundingAcronym);

		if (funding == null) {
			funding = new Funding();
			funding.setAcronym(fundingAcronym);
			funding = fundingRepository.save(funding);
			log.info("Could not find funding with acronym " + fundingAcronym + ", inserted a new one with id " + funding.getId());
		}
		
		List<Project_Funding> pfs = linkProjectFundingRepository.findByProject(project);
		Project_Funding pf = new Project_Funding();
		if (pfs != null && pfs.size() > 0) {
			pf = pfs.get(0);
		}
		
		if (pf != null && pf.getFunding() != null && pf.getFunding().getAcronym().equalsIgnoreCase(funding.getAcronym())) {
			return project;
		} else {
			if (pf != null && pf.getId() != null) {
				linkProjectFundingRepository.delete(pf);
			}
			Project_Funding newPf = new Project_Funding(project, funding, classRepository.findById(new Long(3)), new Date(), new Date());
			linkProjectFundingRepository.save(newPf);
		}
		log.info("Saved new Project_Funding relation with id " + pf.getId());
		return project;
	}
	
	public Project findByAcronym(String acronym) {
		return projectCrudRepository.findByAcronym(acronym);
	}

	public Project findById(Long id) {
		return projectCrudRepository.findById(id);
	}

	public List<ProjectList> findAllProjects() {
		return projectCrudRepository.findAllProjects();
	}

	public List<ProjectList> findAllProjectsWithNoDomainClass() {
		return projectCrudRepository.findAllProjectsWithDomainClass();
	}

	public List<ProjectList> findAllProjectsWithNoDomainClassFavourite(Long personId) {
		return projectCrudRepository.findAllProjectsWithNoDomainClassFavourite(personId);
	}

	public List<ProjectList> findAllProjectsWithDomainClass() {
		return projectCrudRepository.findAllProjectsWithDomainClass();
	}

	public List<ProjectList> findAllProjectsWithDomainClassFavourite(Long personId) {
		return projectCrudRepository.findAllProjectsWithDomainClassFavourite(personId);
	}

	public ProjectView findProjectById(Long id) {
		return projectCrudRepository.findProjectById(id);
	}

	public List<ProjectView> findByOrgUnitId(Long id) {
		return projectCrudRepository.findByOrgUnitId(id);
	}

	public List<ProjectView> findByOrgUnitId(Long id, String organisationStatus) {
		return projectCrudRepository.findByOrgUnitId(id, organisationStatus);
	}

	public List<ProjectList> findByPersonId(Long id) {
		return projectCrudRepository.findByPersonId(id);
	}

	public List<Project> findByUri(String uri) {
		return projectCrudRepository.findByUri(uri);
	}

	public List<Object[]> findByStartingAcronym(String term) {
		return projectCrudRepository.findByStartingAcronym(term);
	}

	public Object[] findProjByIdForAjax(Long id) {
		return projectCrudRepository.findProjByIdForAjax(id);
	}

	public Project_Person isProjectFavourite(Long id, String username) {
		return projectCrudRepository.isProjectFavourite(id, username);
	}

	public List<Object[]> countByScientificDomain() {
		return projectCrudRepository.countByScientificDomain();
	}

	public List<ProjectList> findProjectsWithDomainClass(String domainClass) {
		return projectCrudRepository.findProjectsWithDomainClass(domainClass);
	}

	public List<Object[]> countByActivity() {
		return projectCrudRepository.countByActivity();
	}

	public List<ProjectList> findProjectsWithActivity(String activity) {
		return projectCrudRepository.findProjectsWithActivity(activity);
	}

	public List<Object[]> countByMainCategory() {
		return projectCrudRepository.countByMainCategory();
	}

	public List<ProjectList> findProjectsWithMainCategory(String mainCategory) {
		return projectCrudRepository.findProjectsWithMainCategory(mainCategory);
	}

	public List<Object[]> countByActionLine() {
		return projectCrudRepository.countByActionLine();
	}

	public List<ProjectList> findProjectsWithActionLine(String actionLine) {
		return projectCrudRepository.findProjectsWithActionLine(actionLine);
	}

	public List<Object[]> countByCoordinatorCountry() {
		return projectCrudRepository.countByCoordinatorCountry();
	}

	public List<Object[]> countAnalyticProjectsByCountryVisualisation() {
		return projectCrudRepository.countAnalyticProjectsByCountryVisualisation();
	}

	public List<Object[]> countProjectsByCountryVisualisation(String classUri) {
		return projectCrudRepository.countProjectsByCountryVisualisation(classUri);
	}

	public List<Object[]> countProjectsByScientificDomainVisualisation() {
		return projectCrudRepository.countProjectsByScientificDomainVisualisation();
	}

	public List<ProjectList> findProjectsWithCoordinatorCountry(String countryCode) {
		return projectCrudRepository.findProjectsWithCoordinatorCountry(countryCode);
	}

	@Transactional
	public void delete(Project entity) {
		
		List<ProjectAbstract> pa = projectAbstractRepository.findByProject(entity);
		if (pa != null) projectAbstractRepository.delete(pa);
		entity.setProjectAbstracts(null);
		
		ProjectTitle pt = projectTitleRepository.findByProject(entity);
		if (pt != null) projectTitleRepository.delete(pt);
		entity.setProjectTitles(null);
		
		List<Project_OrganisationUnit> po = linkProjectOrganisationUnitRepository.findByProject(entity);
		if (po != null) linkProjectOrganisationUnitRepository.delete(po);
		entity.setOrganisationUnits(null);
		
		List<Project_Class> pc = linkProjectClassRepository.findByProject(entity);
		if (pc != null) linkProjectClassRepository.delete(pc);
		entity.setProjects_classes(null);
		
		List<Project_Funding> pf = linkProjectFundingRepository.findByProject(entity);
		if (pf != null) linkProjectFundingRepository.delete(pf);
		entity.setProjects_fundings(null);

		List<Project_Person> pp = linkProjectPersonRepository.findByProject(entity);
		if (pp != null) linkProjectPersonRepository.delete(pp);
		entity.setPersons(null);
		
		List<Project_ResultPublication> pr = linkProjectResultPublicationRepository.findByProject(entity);
		if (pr != null) linkProjectResultPublicationRepository.delete(pr);
		entity.setProjects_resultPublications(null);
		
		List<Project_Project> pp1 = linkProjectProjectRepository.findByProject1(entity);
		if (pp1 != null) linkProjectProjectRepository.delete(pp1);
		entity.setProjects1(null);
		
		List<Project_Project> pp2 = linkProjectProjectRepository.findByProject2(entity);
		if (pp2 != null) linkProjectProjectRepository.delete(pp2);
		entity.setProjects2(null);
		
		entity = projectCrudRepository.save(entity);
		projectCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<Project> save(Iterable<Project> entities) {
		return projectCrudRepository.save(entities);
	}

	@Transactional
	public Project save(Project entity) {
		return projectCrudRepository.save(entity);
	}

	public Iterable<Project> findAll() {
		return projectCrudRepository.findAll();
	}

}
