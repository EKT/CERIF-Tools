package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.services.link.project.LinkProjectClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFundingRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
import gr.ekt.cerif.services.link.project.LinkProjectProjectRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectAbstractRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectTitleRepository;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;
import gr.ekt.cerif.transferobjects.ProjectView;

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
	
	
	
	public Project findByAcronym(String acronym) {
		return projectCrudRepository.findByAcronym(acronym);
	}

	public Project findById(Long id) {
		return projectCrudRepository.findById(id);
	}

	public List<Project> findByUri(String uri) {
		return projectCrudRepository.findByUri(uri);
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

	public Iterable<Project> findAll(List<Long> ids) {
		return projectCrudRepository.findAll(ids);
	}

	@Override
	public void delete(Iterable<Project> entities) {
		projectCrudRepository.delete(entities);		
	}

	@Override
	public List<ProjectView> findAllProjects() {
		return projectCrudRepository.findAllProjects();
	}

	@Override
	public ProjectView findProjectById(Long id) {
		return projectCrudRepository.findProjectById(id);
	}

	@Override
	public List<ProjectView> findProjectByOrganisationIdAndClassScheme(Long id,
			String classSchemeUri) {
		return projectCrudRepository.findProjectByOrganisationIdAndClassScheme(id, classSchemeUri);
	}

}
