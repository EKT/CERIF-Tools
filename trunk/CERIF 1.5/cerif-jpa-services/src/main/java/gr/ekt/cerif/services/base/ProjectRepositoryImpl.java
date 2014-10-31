package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Event;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Indicator;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.project.Project_Medium;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.services.link.project.LinkProjectClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEquipmentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectEventRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFacilityRepository;
import gr.ekt.cerif.services.link.project.LinkProjectFundingRepository;
import gr.ekt.cerif.services.link.project.LinkProjectIndicatorRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMeasurementRepository;
import gr.ekt.cerif.services.link.project.LinkProjectMediumRepository;
import gr.ekt.cerif.services.link.project.LinkProjectOrganisationUnitRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPrizeRepository;
import gr.ekt.cerif.services.link.project.LinkProjectProjectRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPatentRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultProductRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectServiceRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectAbstractRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectKeywordRepository;
import gr.ekt.cerif.services.multilingual.project.ProjectTitleRepository;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Autowired
	private ProjectKeywordRepository projectKeywordRepository;
	
	@Autowired
	private LinkProjectEquipmentRepository linkProjectEquipmentRepository;
	
	@Autowired
	private LinkProjectEventRepository linkProjectEventRepository;
	
	@Autowired
	private LinkProjectFacilityRepository linkProjectFacilityRepository;
	
	@Autowired
	private LinkProjectIndicatorRepository linkProjectIndicatorRepository;
	
	@Autowired
	private LinkProjectMeasurementRepository linkProjectMeasurementRepository;
	
	@Autowired
	private LinkProjectMediumRepository linkProjectMediumRepository;
	
	@Autowired
	private LinkProjectPrizeRepository linkProjectPrizeRepository;
	
	@Autowired
	private LinkProjectResultPatentRepository linkProjectResultPatentRepository;
	
	@Autowired
	private LinkProjectServiceRepository linkProjectServiceRepository;
	
	@Autowired
	private LinkProjectResultProductRepository linkProjectResultProductRepository;
	

	@Override
	@Transactional
	public void delete(Project entity) {		
		List<ProjectAbstract> pa = projectAbstractRepository.findByProject(entity);
		if (pa != null) projectAbstractRepository.delete(pa);
		entity.setProjectAbstracts(null);
		
		List<ProjectTitle> pt = projectTitleRepository.findByProject(entity);
		if (pt != null) projectTitleRepository.delete(pt);
		entity.setProjectTitles(null);
		
		List<Project_OrganisationUnit> po = linkProjectOrganisationUnitRepository.findByProject(entity);
		if (po != null) linkProjectOrganisationUnitRepository.delete(po);
		entity.setProjects_organisationUnits(null);
		
		List<Project_Class> pc = linkProjectClassRepository.findByProject(entity);
		if (pc != null) linkProjectClassRepository.delete(pc);
		entity.setProjects_classes(null);
		
		List<Project_Funding> pf = linkProjectFundingRepository.findByProject(entity);
		if (pf != null) linkProjectFundingRepository.delete(pf);
		entity.setProjects_fundings(null);

		List<Project_Person> pp = linkProjectPersonRepository.findByProject(entity);
		if (pp != null) linkProjectPersonRepository.delete(pp);
		entity.setProjects_persons(null);
		
		List<Project_ResultPublication> pr = linkProjectResultPublicationRepository.findByProject(entity);
		if (pr != null) linkProjectResultPublicationRepository.delete(pr);
		entity.setProjects_resultPublications(null);
		
		List<Project_ResultProduct> projresprod = linkProjectResultProductRepository.findByProject(entity);
		if (projresprod != null) linkProjectResultProductRepository.delete(projresprod);
		entity.setProjects_resultProducts(null);
		
		List<Project_Project> pp1 = linkProjectProjectRepository.findByProject1(entity);
		if (pp1 != null) linkProjectProjectRepository.delete(pp1);
		entity.setProjects_projects1(null);
		
		List<Project_Project> pp2 = linkProjectProjectRepository.findByProject2(entity);
		if (pp2 != null) linkProjectProjectRepository.delete(pp2);
		entity.setProjects_projects2(null);
		
		List<ProjectKeyword> pk = projectKeywordRepository.findByProject(entity);
		if (pk != null) projectKeywordRepository.delete(pk);
		entity.setProjectKeywords(null);
		
		List<Project_Equipment> peq = linkProjectEquipmentRepository.findByProject(entity);
		if (peq != null) linkProjectEquipmentRepository.delete(peq);
		entity.setProjects_equipments(null);
		
		List<Project_Event> pev = linkProjectEventRepository.findByProject(entity);
		if (pev != null) linkProjectEventRepository.delete(pev);
		entity.setProjects_events(null);
		
		List<Project_Facility> pfac = linkProjectFacilityRepository.findByProject(entity);
		if (pfac != null) linkProjectFacilityRepository.delete(pfac);
		entity.setProjects_facilities(null);
		
		List<Project_Indicator> pin = linkProjectIndicatorRepository.findByProject(entity);
		if (pin != null) linkProjectIndicatorRepository.delete(pin);
		entity.setProjects_indicators(null);
		
		List<Project_Measurement> pmeas = linkProjectMeasurementRepository.findByProject(entity);
		if (pmeas != null) linkProjectMeasurementRepository.delete(pmeas);
		entity.setProjects_measurements(null);
		
		List<Project_Medium> pmed = linkProjectMediumRepository.findByProject(entity);
		if (pmed != null) linkProjectMediumRepository.delete(pmed);
		entity.setProjects_mediums(null);
		
		List<Project_Prize> ppr = linkProjectPrizeRepository.findByProject(entity);
		if (ppr != null) linkProjectPrizeRepository.delete(ppr);
		entity.setProjects_prizes(null);
		
		List<Project_ResultPatent> prespat = linkProjectResultPatentRepository.findByProject(entity);
		if (prespat != null) linkProjectResultPatentRepository.delete(prespat);
		entity.setProjects_resultPatents(null);
		
		List<Project_Service> pser = linkProjectServiceRepository.findByProject(entity);
		if (pser != null) linkProjectServiceRepository.delete(pser);
		entity.setProjects_services(null);
		
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

	@Transactional
	public void delete(Iterable<Project> entities) {
		projectCrudRepository.delete(entities);		
	}

	@Override
	public Project findById(Long id) {
		return projectCrudRepository.findById(id);
	}

	@Override
	public List<Project> findByUri(String uri) {
		return projectCrudRepository.findByUri(uri);
	}

	@Override
	public Page<Project> findAll(Pageable page) {
		return projectCrudRepository.findAll(page);
	}

	@Override
	public Iterable<Project> findAll() {
		return projectCrudRepository.findAll();
	}

	@Override
	public Project findByUuid(String uuid) {
		return projectCrudRepository.findByUuid(uuid);
	}

	
}
