package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.entities.link.Equipment_Event;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_Indicator;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Equipment_Medium;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Event_Class;
import gr.ekt.cerif.entities.link.Event_Event;
import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.entities.link.Event_Indicator;
import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.link.Event_Medium;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Indicator;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Medium;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPatent;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
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
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultPatent;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;
import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;
import gr.ekt.cerif.features.multilingual.IndicatorName;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;
import gr.ekt.cerif.features.multilingual.MediumDescription;
import gr.ekt.cerif.features.multilingual.MediumKeyword;
import gr.ekt.cerif.features.multilingual.MediumTitle;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;
import gr.ekt.cerif.features.multilingual.ServiceDescription;
import gr.ekt.cerif.features.multilingual.ServiceKeyword;
import gr.ekt.cerif.features.multilingual.ServiceName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.CitationRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.FederatedIdentifierRepository;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Implementation of the selection service.
 */
@Component
public class SelectionServiceImpl implements SelectionService {
	
	/**
	 * Logging facility.
	 */
	private static final Logger logger = Logger.getLogger(SelectionServiceImpl.class);

	/**
	 * Persistence service.
	 */
	@Autowired
	private PersistenceService service;
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.SelectionService#select(gr.ekt.cerif.services.SelectionOptions)
	 */
	public List<CerifEntity> select(SelectionOptions options) throws SelectionException {
		List<CerifEntity> result = new ArrayList<CerifEntity>();

		Iterator<Project> iterProject = null;
		Iterator<OrganisationUnit> iterOrganisationUnit = null;
		Iterator<Person> iterPerson = null;
		Iterator<ElectronicAddress> iterElectronicAddress = null;
		Iterator<PostalAddress> iterPostalAddress = null;
		Iterator<Funding> iterFunding = null;
		Iterator<Class> iterClass = null;
		Iterator<ClassScheme> iterClassSchemes = null;
		Iterator<ResultPublication> iterResultPublication = null;
		Iterator<Facility> iterFacility = null;
		Iterator<ResultProduct> iterResultProduct = null;
		Iterator<ResultPatent> iterResultPatent = null;
		Iterator<Service> iterService = null;
		Iterator<Equipment> iterEquipment = null;
		Iterator<FederatedIdentifier> iterFederatedIdentifier = null;	
		Iterator<Measurement> iterMeasurement = null;
		Iterator<Indicator> iterIndicator = null;
		Iterator<Medium> iterMedium = null;
		Iterator<Event> iterEvent = null;
		Iterator<Citation> iterCitation = null;
		
		boolean links = options.isLinks();
		boolean showFedIds = options.isShowFedIds();
		
		long start = System.currentTimeMillis();	
			
		/*
		 * Entities
		 */
		if (hasEntities(ClassEnum.PROJECT, options)) {
			ProjectRepository repository = service.getBaseService().getProjectRepository();
			iterProject = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.ORGANISATION, options)) {
			OrganisationUnitRepository repository = service.getBaseService().getOrganisationUnitRepository();
			iterOrganisationUnit = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.PERSON, options)) {
			PersonRepository repository = service.getBaseService().getPersonRepository();
			iterPerson = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.ELECTRONIC_ADDRESS, options)) {
			ElectronicAddressRepository repository = service.getSecondService().getElectronicAddressRepository();
			iterElectronicAddress = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.POSTAL_ADDRESS, options)) {
			PostalAddressRepository repository = service.getSecondService().getPostalAddressRepository();
			iterPostalAddress = retrieveEntities(repository, options);
		}
				
		if (hasEntities(ClassEnum.FUNDING, options)) {
			FundingRepository repository = service.getSecondService().getFundingRepository();
			iterFunding = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.CLASSIFICATION, options)) {
			ClassRepository repository = service.getSemanticService().getClassRepository();
			iterClass = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.CLASSIFICATION_SCHEME, options)) {
			ClassSchemeRepository repository = service.getSemanticService().getClassSchemeRepository();
			iterClassSchemes = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.PUBLICATION, options)) {
			ResultPublicationRepository repository = service.getResultService().getResultPublicationRepository();
			iterResultPublication = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.FACILITY, options)) {
			FacilityRepository repository = service.getInfrastructureService().getFacilityRepository();
			iterFacility = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.PRODUCT, options)) {
			ResultProductRepository repository = service.getResultService().getResultProductRepository();
			iterResultProduct = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.PATENT, options)) {
			ResultPatentRepository repository = service.getResultService().getResultPatentRepository();
			iterResultPatent = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.SERVICE, options)) {
			ServiceRepository repository = service.getInfrastructureService().getServiceRepository();
			iterService = retrieveEntities(repository, options);
		}
				
		if (hasEntities(ClassEnum.EQUIPMENT, options)) {
			EquipmentRepository repository = service.getInfrastructureService().getEquipmentRepository();
			iterEquipment = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.FEDERATED_IDENTIFIER, options)) {
			FederatedIdentifierRepository repository = service.getSecondService().getFederatedIdentifierRepository();
			iterFederatedIdentifier = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.MEASUREMENT, options)) {
			MeasurementRepository repository = service.getSecondService().getMeasurementRepository();
			iterMeasurement = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.INDICATOR, options)) {
			IndicatorRepository repository = service.getSecondService().getIndicatorRepository();
			iterIndicator = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.MEDIUM, options)) {
			MediumRepository repository = service.getSecondService().getMediumRepository();
			iterMedium = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.EVENT, options)) {
			EventRepository repository = service.getSecondService().getEventRepository();
			iterEvent = retrieveEntities(repository, options);
		}
		
		if (hasEntities(ClassEnum.CITATION, options)) {
			CitationRepository repository = service.getSecondService().getCitationRepository();
			iterCitation = retrieveEntities(repository, options);
		}
		

		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info(duration);

		/*
		 * Project 
		 */
		if (iterProject != null) {
			while (iterProject.hasNext()) {
				Project project = iterProject.next(); 
				
				//titles
				List<ProjectTitle> projTitles = service.getTranslationService().getProjectTitleRepository().findByProject(project);
				Set<ProjectTitle> titles = new HashSet<ProjectTitle>(projTitles);
				project.setProjectTitles(titles);
				
				//abstract
				List<ProjectAbstract> projAbs = service.getTranslationService().getProjectAbstractRepository().findByProject(project);
				Set<ProjectAbstract> abs = new HashSet<ProjectAbstract>(projAbs);
				project.setProjectAbstracts(abs);
				
				//keywords
				List<ProjectKeyword> projKeys = service.getTranslationService().getProjectKeywordRepository().findByProject(project);
				Set<ProjectKeyword> keys = new HashSet<ProjectKeyword>(projKeys);
				project.setProjectKeywords(keys);
				
				List<Project_OrganisationUnit> projorgs = new ArrayList<Project_OrganisationUnit>();
				List<Project_Facility> projFacilities = new ArrayList<Project_Facility>();
				List<Project_Funding> projFunds = new ArrayList<Project_Funding>();
				List<Project_Person> projpers = new ArrayList<Project_Person>();
				List<Project_Project> projProj1 = new ArrayList<Project_Project>();
				List<Project_Project> projProj2 = new ArrayList<Project_Project>();
				List<Project_ResultProduct> projResultProd = new ArrayList<Project_ResultProduct>();
				List<Project_ResultPatent> projResultPat = new ArrayList<Project_ResultPatent>();
				List<Project_ResultPublication> projRespubls = new ArrayList<Project_ResultPublication>();
				List<Project_Service> serviceProj = new ArrayList<Project_Service>();
				List<Project_Measurement> projMeass = new ArrayList<Project_Measurement>();
				List<Project_Class> projclas = new ArrayList<Project_Class>();
				List<Project_Equipment> projEquipments = new ArrayList<Project_Equipment>();
				List<Project_Indicator> projsIndic = new ArrayList<Project_Indicator>();
				List<Project_Medium> projMed = new ArrayList<Project_Medium>();
				List<Project_Event> projEvents = new ArrayList<Project_Event>();
				if (links) {
					//facilities
					projFacilities = service.getLinkService().getProjectFacilityRepository().findByProject(project);
					
					//fundings
					projFunds = service.getLinkService().getProjectFundingRepository().findByProject(project);
					
					//organisations
					projorgs = service.getLinkService().getProjectOrganisationUnitRepository().findByProject(project);
					
					//persons
					projpers = service.getLinkService().getProjectPersonRepository().findByProject(project);
					
					//projects 1
					projProj1 = service.getLinkService().getProjectProjectRepository().findByProject2(project);
					
					//projects 2
					projProj2 = service.getLinkService().getProjectProjectRepository().findByProject1(project);
					
					//result patents
					projResultPat = service.getLinkService().getProjectResultPatentRepository().findByProject(project);
					
					//result products
					projResultProd = service.getLinkService().getProjectResultProductRepository().findByProject(project);
					
					//Result Publications
					projRespubls = service.getLinkService().getProjectResultPublicationRepository().findByProject(project);
					
					//services
					serviceProj = service.getLinkService().getProjectServiceRepository().findByProject(project);
					
					//measurements
					projMeass = service.getLinkService().getProjectMeasurementRepository().findByProject(project);
					
					//classes
					projclas = service.getLinkService().getProjectClassRepository().findByProject(project);
					
					//Equipments
					projEquipments = service.getLinkService().getProjectEquipmentRepository().findByProject(project);
					
					//indicators
					projsIndic = service.getLinkService().getProjectIndicatorRepository().findByProject(project);
					
					//mediums
					projMed = service.getLinkService().getProjectMediumRepository().findByProject(project);
					
					//events
					projEvents = service.getLinkService().getProjectEventRepository().findByProject(project);
				}
				//facilities
				Set<Project_Facility> facils = new HashSet<Project_Facility>(projFacilities);
				project.setProjects_facilities(facils);
				
				//fundings
				Set<Project_Funding> funds = new HashSet<Project_Funding>(projFunds);
				project.setProjects_fundings(funds);
				
				//organisations
				Set<Project_OrganisationUnit> orgs = new HashSet<Project_OrganisationUnit>(projorgs);
				project.setProjects_organisationUnits(orgs);
				
				//persons
				Set<Project_Person> pers = new HashSet<Project_Person>(projpers);
				project.setProjects_persons(pers);
				
				//projects 1
				Set<Project_Project> projs1 = new HashSet<Project_Project>(projProj1);
				project.setProjects_projects1(projs1);
				
				//projects 2
				Set<Project_Project> projs2 = new HashSet<Project_Project>(projProj2);
				project.setProjects_projects2(projs2);
				
				//result products
				Set<Project_ResultProduct> resultProds = new HashSet<Project_ResultProduct>(projResultProd);
				project.setProjects_resultProducts(resultProds);
				
				//result patents
				Set<Project_ResultPatent> resultPats = new HashSet<Project_ResultPatent>(projResultPat);
				project.setProjects_resultPatents(resultPats);
				
				//Result Publications
				Set<Project_ResultPublication> resultPubls = new HashSet<Project_ResultPublication>(projRespubls);
				project.setProjects_resultPublications(resultPubls);
				
				//services
				Set<Project_Service> srvs = new HashSet<Project_Service>(serviceProj);
				project.setProjects_services(srvs);
				
				//measurements
				Set<Project_Measurement> meass = new HashSet<Project_Measurement>(projMeass);
				project.setProjects_measurements(meass);
				
				//classes
				Set<Project_Class> classes = new HashSet<Project_Class>(projclas);
				project.setProjects_classes(classes);
				
				//Equipments
				Set<Project_Equipment> equipments = new HashSet<Project_Equipment>(projEquipments);
				project.setProjects_equipments(equipments);
				
				//indicators
				Set<Project_Indicator> indics = new HashSet<Project_Indicator>(projsIndic);
				project.setProjects_indicators(indics);
				
				//mediums
				Set<Project_Medium> mediums = new HashSet<Project_Medium>(projMed);
				project.setProjects_mediums(mediums);
				
				//events
				Set<Project_Event> events = new HashSet<Project_Event>(projEvents);
				project.setProjects_events(events);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					project.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PROJECT.getUuid(), project.getId()));
				}
				
				result.add(project);
			}
		}
		
		/*
		 * OrganisationUnits
		 */
		if (iterOrganisationUnit != null) {
			while (iterOrganisationUnit.hasNext()) {
				OrganisationUnit organisation = iterOrganisationUnit.next(); 
				
				//names
				List<OrganisationUnitName> orgNames = service.getTranslationService().getOrganisationUnitNameRepository().findByOrganisationUnit(organisation);
				Set<OrganisationUnitName> names = new HashSet<OrganisationUnitName>(orgNames);
				organisation.setOrganisationUnitNames(names);
				
				//Research Activities
				List<OrganisationUnitResearchActivity> orgResearchActivities = service.getTranslationService().getOrganisationUnitResearchActivityRepository().findByOrganisationUnit(organisation);
				Set<OrganisationUnitResearchActivity> researchActivities = new HashSet<OrganisationUnitResearchActivity>(orgResearchActivities);
				organisation.setOrganisationUnitResearchActivities(researchActivities);
				
				//Keywords
				List<OrganisationUnitKeyword> orgKeywords = service.getTranslationService().getOrganisationUnitKeywordRepository().findByOrganisationUnit(organisation);
				Set<OrganisationUnitKeyword> keywords = new HashSet<OrganisationUnitKeyword>(orgKeywords);
				organisation.setOrganisationUnitKeywords(keywords);
				
				List<OrganisationUnit_Class> orgclass = new ArrayList<OrganisationUnit_Class>();
				List<OrganisationUnit_Equipment> equipmentOrgs = new ArrayList<OrganisationUnit_Equipment>();
				List<OrganisationUnit_ElectronicAddress> orgEaddrs = new ArrayList<OrganisationUnit_ElectronicAddress>();
				List<OrganisationUnit_Facility> orgFacilities = new ArrayList<OrganisationUnit_Facility>();
				List<OrganisationUnit_Funding> orgFunds = new ArrayList<OrganisationUnit_Funding>();
				List<OrganisationUnit_OrganisationUnit> orgOrgs1 = new ArrayList<OrganisationUnit_OrganisationUnit>();
				List<OrganisationUnit_OrganisationUnit> orgOrgs2 = new ArrayList<OrganisationUnit_OrganisationUnit>();
				List<OrganisationUnit_ResultProduct> orgResprod = new ArrayList<OrganisationUnit_ResultProduct>();
				List<Person_OrganisationUnit> persOrg = new ArrayList<Person_OrganisationUnit>();
				List<Project_OrganisationUnit> projorgs = new ArrayList<Project_OrganisationUnit>();
				List<OrganisationUnit_PostalAddress> orgPaddrs = new ArrayList<OrganisationUnit_PostalAddress>();
				List<OrganisationUnit_Measurement> orgMeass = new ArrayList<OrganisationUnit_Measurement>();
				List<OrganisationUnit_ResultPublication> orgRespubls = new ArrayList<OrganisationUnit_ResultPublication>();
				List<OrganisationUnit_Service> serviceOrgs = new ArrayList<OrganisationUnit_Service>();
				List<OrganisationUnit_Indicator> orgsIndic = new ArrayList<OrganisationUnit_Indicator>();
				List<OrganisationUnit_ResultPatent> orgResPat = new ArrayList<OrganisationUnit_ResultPatent>();
				List<OrganisationUnit_Event> orgEvents = new ArrayList<OrganisationUnit_Event>();
				if (links) {
					//classes
					orgclass = service.getLinkService().getOrganisationUnitClassRepository().findByOrganisationUnit(organisation);
					
					//OrganisationUnits
					equipmentOrgs = service.getLinkService().getOrganisationUnitEquipmentRepository().findByOrganisationUnit(organisation);
					
					//electronic addresses
					orgEaddrs = service.getLinkService().getOrganisationUnitElectronicAddressRepository().findByOrganisationUnit(organisation);
					
					//facilities
					orgFacilities = service.getLinkService().getOrganisationUnitFacilityRepository().findByOrganisationUnit(organisation);
					
					//funding
					orgFunds = service.getLinkService().getOrganisationUnitFundingRepository().findByOrganisationUnit(organisation);
					
					//Organisations 1
					orgOrgs1 = service.getLinkService().getOrganisationUnitOrganisationUnitRepository().findByOrganisationUnit2(organisation);
					
					//Organisations 2
					orgOrgs2 = service.getLinkService().getOrganisationUnitOrganisationUnitRepository().findByOrganisationUnit1(organisation);
					
					//result products
					orgResprod = service.getLinkService().getOrganisationUnitResultProductRepository().findByOrganisationUnit(organisation);
					
					//persons
					persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByOrganisationUnit(organisation);
					
					//projects
					projorgs = service.getLinkService().getProjectOrganisationUnitRepository().findByOrganisationUnit(organisation);
					
					//addresses
					orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByOrganisationUnit(organisation);
					
					//measurements
					orgMeass = service.getLinkService().getOrganisationUnitMeasurementRepository().findByOrganisationUnit(organisation);
					
					//Result Publications
					orgRespubls = service.getLinkService().getOrganisationUnitResultPublicationRepository().findByOrganisationUnit(organisation);
					
					//services
					serviceOrgs = service.getLinkService().getOrganisationUnitServiceRepository().findByOrganisationUnit(organisation);
					
					//Indicators
					orgsIndic = service.getLinkService().getOrganisationUnitIndicatorRepository().findByOrganisationUnit(organisation);
					
					//Result Patents
					orgResPat = service.getLinkService().getOrganisationUnitResultPatentRepository().findByOrganisationUnit(organisation);
					
					//events
					orgEvents = service.getLinkService().getOrganisationUnitEventRepository().findByOrganisationUnit(organisation);
				}
				//classes
				Set<OrganisationUnit_Class> classes = new HashSet<OrganisationUnit_Class>(orgclass);
				organisation.setOrganisationUnits_classes(classes);
				
				//Equipments
				Set<OrganisationUnit_Equipment> equipments = new HashSet<OrganisationUnit_Equipment>(equipmentOrgs);
				organisation.setOrganisationUnits_equipments(equipments);
				
				//electronic addresses
				Set<OrganisationUnit_ElectronicAddress> eaddrs = new HashSet<OrganisationUnit_ElectronicAddress>(orgEaddrs);
				organisation.setOrganisationUnits_electronicAddresses(eaddrs);
				
				//facilities
				Set<OrganisationUnit_Facility> facils = new HashSet<OrganisationUnit_Facility>(orgFacilities);
				organisation.setOrganisationUnits_facilities(facils);
				
				//funding
				Set<OrganisationUnit_Funding> funds = new HashSet<OrganisationUnit_Funding>(orgFunds);
				organisation.setOrganisationUnits_fundings(funds);
				
				//Organisations 1
				Set<OrganisationUnit_OrganisationUnit> orgs1 = new HashSet<OrganisationUnit_OrganisationUnit>(orgOrgs1);
				organisation.setOrganisationUnits_organisationUnits1(orgs1);
				
				//Organisations 2
				Set<OrganisationUnit_OrganisationUnit> orgs2 = new HashSet<OrganisationUnit_OrganisationUnit>(orgOrgs2);
				organisation.setOrganisationUnits_organisationUnits2(orgs2);
				
				//result products
				Set<OrganisationUnit_ResultProduct> resultProds = new HashSet<OrganisationUnit_ResultProduct>(orgResprod);
				organisation.setOrganisationUnits_resultProducts(resultProds);
				
				//persons
				Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
				organisation.setPersons_organisationUnits(pers);
				
				//projects
				Set<Project_OrganisationUnit> projs = new HashSet<Project_OrganisationUnit>(projorgs);
				organisation.setProjects_organisationUnits(projs);
				
				//addresses
				Set<OrganisationUnit_PostalAddress> paddrs = new HashSet<OrganisationUnit_PostalAddress>(orgPaddrs);
				organisation.setOrganisationUnits_postalAddresses(paddrs);
				
				//measurements
				Set<OrganisationUnit_Measurement> meass = new HashSet<OrganisationUnit_Measurement>(orgMeass);
				organisation.setOrganisationUnits_measurements(meass);
				
				//Result Publications
				Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
				organisation.setOrganisationUnits_resultPublications(resultPublications2);
				
				//services
				Set<OrganisationUnit_Service> srvs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
				organisation.setOrganisationUnits_services(srvs);
				
				//Indicators
				Set<OrganisationUnit_Indicator> indics = new HashSet<OrganisationUnit_Indicator>(orgsIndic);
				organisation.setOrganisationUnits_indicators(indics);
				
				//Result Patent
				Set<OrganisationUnit_ResultPatent> resPats = new HashSet<OrganisationUnit_ResultPatent>(orgResPat);
				organisation.setOrganisationUnits_resultPatents(resPats);
				
				//events
				Set<OrganisationUnit_Event> events = new HashSet<OrganisationUnit_Event>(orgEvents);
				organisation.setOrganisationUnits_events(events);
						
				
				//FederatedIdentifiers
				if (showFedIds) {
					organisation.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.ORGANISATION.getUuid(), organisation.getId()));
				}
				
				result.add(organisation);
			}
		}
		
		
		/*
		 * Person 
		 */
		if (iterPerson != null) {
			while (iterPerson.hasNext()) {
				Person person = iterPerson.next(); 
				
				//Research Interests
				List<PersonResearchInterest> persResearchActivities = service.getTranslationService().getPersonResearchInterestRepository().findByPerson(person);
				Set<PersonResearchInterest> researchInterests = new HashSet<PersonResearchInterest>(persResearchActivities);
				person.setPersonResearchInterests(researchInterests);
				
				//Keywords
				List<PersonKeyword> persKeywords = service.getTranslationService().getPersonKeywordRepository().findByPerson(person);
				Set<PersonKeyword> keywords = new HashSet<PersonKeyword>(persKeywords);
				person.setPersonKeywords(keywords);
				
				List<Person_Person> persPers1 = new ArrayList<Person_Person>();
				List<Person_Person> persPers2 = new ArrayList<Person_Person>();
				List<Person_ElectronicAddress> persEaddrs = new ArrayList<Person_ElectronicAddress>();
				List<Person_Class> persClas = new ArrayList<Person_Class>();
				List<Person_Equipment> persEquipment = new ArrayList<Person_Equipment>();
				List<Person_Facility> persFacilities = new ArrayList<Person_Facility>();
				List<Person_Funding> persFunds = new ArrayList<Person_Funding>();
				List<Person_OrganisationUnit> persOrg = new ArrayList<Person_OrganisationUnit>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Person_ResultPatent> persResPat = new ArrayList<Person_ResultPatent>();
				List<Project_Person> persProj = new ArrayList<Project_Person>();
				List<Person_PostalAddress> persPaddrs = new ArrayList<Person_PostalAddress>();
				List<Person_Measurement> persMeass = new ArrayList<Person_Measurement>();
				List<Person_ResultPublication> persRespubls = new ArrayList<Person_ResultPublication>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				List<Person_Country> persCountries = new ArrayList<Person_Country>();
				List<Person_Indicator> persIndic = new ArrayList<Person_Indicator>();
				List<Person_Medium> personMediums = new ArrayList<Person_Medium>();
				List<Person_Event> persEvents = new ArrayList<Person_Event>();
				List<PersonName_Person> persNamePers = new ArrayList<PersonName_Person>();
				if (links) {
					//Person 1
					persPers1 = service.getLinkService().getPersonPersonRepository().findByPerson2(person);
					
					//Person 2
					persPers2 = service.getLinkService().getPersonPersonRepository().findByPerson1(person);
					
					//electronic addresses
					persEaddrs = service.getLinkService().getPersonElectronicAddressRepository().findByPerson(person);
					
					//classes
					persClas = service.getLinkService().getPersonClassRepository().findByPerson(person);
					
					//equipments
					persEquipment = service.getLinkService().getPersonEquipmentRepository().findByPerson(person);
					
					//facilities
					persFacilities = service.getLinkService().getPersonFacilityRepository().findByPerson(person);
					
					//funding
					persFunds = service.getLinkService().getPersonFundingRepository().findByPerson(person);
					
					//Countries
					persCountries = service.getLinkService().getPersonCountryRepository().findByPerson(person);
					
					//organisations
					persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByPerson(person);
					
					//Result products
					persResprod = service.getLinkService().getPersonResultProductRepository().findByPerson(person);
					
					//Result patents
					persResPat = service.getLinkService().getPersonResultPatentRepository().findByPerson(person);
					
					//projects
					persProj = service.getLinkService().getProjectPersonRepository().findByPerson(person);
					
					//addresses
					persPaddrs = service.getLinkService().getPersonPostalAddressRepository().findByPerson(person);
					
					//measurements
					persMeass = service.getLinkService().getPersonMeasurementRepository().findByPerson(person);
					
					//Result Publications
					persRespubls = service.getLinkService().getPersonResultPublicationRepository().findByPerson(person);
					
					//services
					servicePers = service.getLinkService().getPersonServiceRepository().findByPerson(person);
					
					//indicators
					persIndic = service.getLinkService().getPersonIndicatorRepository().findByPerson(person);
					
					//mediums
					personMediums = service.getLinkService().getPersonMediumRepository().findByPerson(person);
					
					//events
					persEvents = service.getLinkService().getPersonEventRepository().findByPerson(person);
					
					//person names
					persNamePers = service.getLinkService().getPersonNamePersonRepository().findByPerson(person);
				}
				//Person 1
				Set<Person_Person> pers1 = new HashSet<Person_Person>(persPers1);
				person.setPersons_persons1(pers1);
				
				//Person 2
				Set<Person_Person> pers2 = new HashSet<Person_Person>(persPers2);
				person.setPersons_persons2(pers2);
				
				//electronic addresses
				Set<Person_ElectronicAddress> eaddrs = new HashSet<Person_ElectronicAddress>(persEaddrs);
				person.setPersons_electronicAddresses(eaddrs);
				
				//classes
				Set<Person_Class> classes = new HashSet<Person_Class>(persClas);
				person.setPersons_classes(classes);
				
				//equipments
				Set<Person_Equipment> equipments = new HashSet<Person_Equipment>(persEquipment);
				person.setPersons_equipments(equipments);
				
				//facilities
				Set<Person_Facility> facils = new HashSet<Person_Facility>(persFacilities);
				person.setPersons_facilities(facils);
				
				//funding
				Set<Person_Funding> funds = new HashSet<Person_Funding>(persFunds);
				person.setPersons_fundings(funds);
				
				//Countries
				Set<Person_Country> couns = new HashSet<Person_Country>(persCountries);
				person.setPersons_countries(couns);
				
				//organisations
				Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
				person.setPersons_organisationUnits(pers);
				
				//Result products
				Set<Person_ResultProduct> resultProds = new HashSet<Person_ResultProduct>(persResprod);
				person.setPersons_resultProducts(resultProds);
				
				//Result patents
				Set<Person_ResultPatent> resultPats = new HashSet<Person_ResultPatent>(persResPat);
				person.setPersons_resultPatents(resultPats);
				
				//projects
				Set<Project_Person> projs = new HashSet<Project_Person>(persProj);
				person.setProjects_persons(projs);
				
				//addresses
				Set<Person_PostalAddress> paddrs = new HashSet<Person_PostalAddress>(persPaddrs);
				person.setPersons_postalAddresses(paddrs);
				
				//measurements
				Set<Person_Measurement> meass = new HashSet<Person_Measurement>(persMeass);
				person.setPersons_measurements(meass);
				
				//Result Publications
				Set<Person_ResultPublication> resultPublications2 = new HashSet<Person_ResultPublication>(persRespubls);
				person.setPersons_resultPublications(resultPublications2);
				
				//services
				Set<Person_Service> srvs = new HashSet<Person_Service>(servicePers);
				person.setPersons_services(srvs);
				
				//indicators
				Set<Person_Indicator> indics = new HashSet<Person_Indicator>(persIndic);
				person.setPersons_indicators(indics);
				
				//mediums
				Set<Person_Medium> meds = new HashSet<Person_Medium>(personMediums);
				person.setPersons_mediums(meds);
				
				//events
				Set<Person_Event> events = new HashSet<Person_Event>(persEvents);
				person.setPersons_events(events);
				
				//person names
				Set<PersonName_Person> persnames = new HashSet<PersonName_Person>(persNamePers);
				person.setPersonNames_persons(persnames);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					person.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PERSON.getUuid(), person.getId()));
				}
				
				result.add(person);
			}
		}
		
		
		/*
		 * ElectronicAddress 
		 */
		if (iterElectronicAddress != null) {
			while (iterElectronicAddress.hasNext()) {
				ElectronicAddress electronicAddress = iterElectronicAddress.next(); 
				
				List<OrganisationUnit_ElectronicAddress> orgEaddrs = new ArrayList<OrganisationUnit_ElectronicAddress>();
				List<Person_ElectronicAddress> persEaddrs = new ArrayList<Person_ElectronicAddress>();
				List<ElectronicAddress_Class> eaddrClass = new ArrayList<ElectronicAddress_Class>();
				if (links) {
					//organisations
					orgEaddrs = service.getLinkService().getOrganisationUnitElectronicAddressRepository().findByElectronicAddress(electronicAddress);
					
					//persons
					persEaddrs = service.getLinkService().getPersonElectronicAddressRepository().findByElectronicAddress(electronicAddress);
					
					//classes
					eaddrClass = service.getLinkService().getElectronicAddressClassRepository().findByElectronicAddress(electronicAddress);
				}
				//organisations
				Set<OrganisationUnit_ElectronicAddress> orgs = new HashSet<OrganisationUnit_ElectronicAddress>(orgEaddrs);
				electronicAddress.setOrganisationUnits_electronicAddresses(orgs);
				
				//persons
				Set<Person_ElectronicAddress> pers = new HashSet<Person_ElectronicAddress>(persEaddrs);
				electronicAddress.setPersons_electronicAddresses(pers);
				
				//classes
				Set<ElectronicAddress_Class> classes = new HashSet<ElectronicAddress_Class>(eaddrClass);
				electronicAddress.setElectronicAddresses_classes(classes);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					electronicAddress.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.ELECTRONIC_ADDRESS.getUuid(), electronicAddress.getId()));
				}
				
								
				result.add(electronicAddress);
			}
		}
		
		
		/*
		 * PostalAddress 
		 */
		if (iterPostalAddress != null) {
			while (iterPostalAddress.hasNext()) {
				PostalAddress postalAddress = iterPostalAddress.next(); 
				
				List<OrganisationUnit_PostalAddress> orgPaddrs = new ArrayList<OrganisationUnit_PostalAddress>();
				List<Person_PostalAddress> persPaddrs = new ArrayList<Person_PostalAddress>();
				List<PostalAddress_Class> paddrClass = new ArrayList<PostalAddress_Class>();
				List<Equipment_PostalAddress> equipmentPaddrs = new ArrayList<Equipment_PostalAddress>();
				List<Facility_PostalAddress> facilityPaddrs = new ArrayList<Facility_PostalAddress>();
				List<Service_PostalAddress> servicePaddrs = new ArrayList<Service_PostalAddress>();
				if (links) {
					//organisations
					orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//persons
					persPaddrs = service.getLinkService().getPersonPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//classes
					paddrClass = service.getLinkService().getPostalAddressClassRepository().findByPostalAddress(postalAddress);
					
					//equipments
					equipmentPaddrs = service.getLinkService().getEquipmentPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//facilities
					facilityPaddrs = service.getLinkService().getFacilityPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//services
					servicePaddrs = service.getLinkService().getServicePostalAddressRepository().findByPostalAddress(postalAddress);
				}
				//organisations
				Set<OrganisationUnit_PostalAddress> orgs = new HashSet<OrganisationUnit_PostalAddress>(orgPaddrs);
				postalAddress.setOrganisationUnits_postalAddresses(orgs);
				
				//persons
				Set<Person_PostalAddress> pers = new HashSet<Person_PostalAddress>(persPaddrs);
				postalAddress.setPersons_postalAddresses(pers);
				
				//classes
				Set<PostalAddress_Class> classes = new HashSet<PostalAddress_Class>(paddrClass);
				postalAddress.setPostalAddresses_classes(classes);
				
				//equipments
				Set<Equipment_PostalAddress> equipments = new HashSet<Equipment_PostalAddress>(equipmentPaddrs);
				postalAddress.setEquipments_postalAddresses(equipments);
				
				//facilities
				Set<Facility_PostalAddress> facils = new HashSet<Facility_PostalAddress>(facilityPaddrs);
				postalAddress.setFacilities_postalAddresses(facils);
				
				//services
				Set<Service_PostalAddress> srvs = new HashSet<Service_PostalAddress>(servicePaddrs);
				postalAddress.setServices_postalAddresses(srvs);
				
				//FederatedIdentifiers
				if (showFedIds) {
					postalAddress.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.POSTAL_ADDRESS.getUuid(), postalAddress.getId()));
				}
							
				result.add(postalAddress);
			}
		}
		
		
		/*
		 * Funding 
		 */
		if (iterFunding != null) {
			while (iterFunding.hasNext()) {
				Funding funding = iterFunding.next(); 
				
				//names
				List<FundingName> fundNames = service.getTranslationService().getFundingNameRepository().findByFunding(funding);
				Set<FundingName> names = new HashSet<FundingName>(fundNames);
				funding.setFundingNames(names);
				
				//Keywords
				List<FundingKeyword> fundKeywords = service.getTranslationService().getFundingKeywordRepository().findByFunding(funding);
				Set<FundingKeyword> keywords = new HashSet<FundingKeyword>(fundKeywords);
				funding.setFundingKeywords(keywords);
		
				//descriptions
				List<FundingDescription> fundDescr = service.getTranslationService().getFundingDescriptionRepository().findByFunding(funding);
				Set<FundingDescription> descrs = new HashSet<FundingDescription>(fundDescr);
				funding.setFundingDescriptions(descrs);
				
				List<Equipment_Funding> equipmentFunds = new ArrayList<Equipment_Funding>();
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Funding_Class> fundingClas = new ArrayList<Funding_Class>();
				List<Funding_Funding> fundingFund1 = new ArrayList<Funding_Funding>();
				List<Funding_Funding> fundingFund2 = new ArrayList<Funding_Funding>();
				List<OrganisationUnit_Funding> orgFunds = new ArrayList<OrganisationUnit_Funding>();
				List<Person_Funding> persFunds = new ArrayList<Person_Funding>();
				List<Project_Funding> projFunds = new ArrayList<Project_Funding>();
				List<ResultProduct_Funding> resprodFunds = new ArrayList<ResultProduct_Funding>();
				List<ResultPublication_Funding> respublFunds = new ArrayList<ResultPublication_Funding>();
				List<Service_Funding> serviceFunds = new ArrayList<Service_Funding>();
				List<Funding_Indicator> fundIndic = new ArrayList<Funding_Indicator>();
				List<Medium_Funding> medFund = new ArrayList<Medium_Funding>();
				List<Event_Funding> eventFunds = new ArrayList<Event_Funding>();
				if (links) {
					//equipments
					equipmentFunds = service.getLinkService().getEquipmentFundingRepository().findByFunding(funding);
					
					//facilities
					facilityFunds = service.getLinkService().getFacilityFundingRepository().findByFunding(funding);
					
					//classes
					fundingClas = service.getLinkService().getFundingClassRepository().findByFunding(funding);
					
					//Fundings 1
					fundingFund1 = service.getLinkService().getFundingFundingRepository().findByFunding2(funding);
					
					//Fundings 2
					fundingFund2 = service.getLinkService().getFundingFundingRepository().findByFunding1(funding);
					
					//organistaions
					orgFunds = service.getLinkService().getOrganisationUnitFundingRepository().findByFunding(funding);
					
					//persons
					persFunds = service.getLinkService().getPersonFundingRepository().findByFunding(funding);
					
					//projects
					projFunds = service.getLinkService().getProjectFundingRepository().findByFunding(funding);
					
					//Result Products
					resprodFunds = service.getLinkService().getResultProductFundingRepository().findByFunding(funding);
					
					//Result Publications
					respublFunds = service.getLinkService().getResultPublicationFundingRepository().findByFunding(funding);
					
					//services
					serviceFunds = service.getLinkService().getServiceFundingRepository().findByFunding(funding);
					
					//indicators
					fundIndic = service.getLinkService().getFundingIndicatorRepository().findByFunding(funding);
					
					//mediums
					medFund = service.getLinkService().getMediumFundingRepository().findByFunding(funding);
					
					//events
					eventFunds = service.getLinkService().getEventFundingRepository().findByFunding(funding);
				}
				//equipments
				Set<Equipment_Funding> equipments = new HashSet<Equipment_Funding>(equipmentFunds);
				funding.setEquipments_fundings(equipments);
				
				//facilities
				Set<Facility_Funding> facils = new HashSet<Facility_Funding>(facilityFunds);
				funding.setFacilities_fundings(facils);
				
				//classes
				Set<Funding_Class> classes = new HashSet<Funding_Class>(fundingClas);
				funding.setFundings_classes(classes);
				
				//Fundings 1
				Set<Funding_Funding> funds1 = new HashSet<Funding_Funding>(fundingFund1);
				funding.setFundings_fundings1(funds1);
				
				//Fundings 2
				Set<Funding_Funding> funds2 = new HashSet<Funding_Funding>(fundingFund2);
				funding.setFundings_fundings2(funds2);
				
				//organisations
				Set<OrganisationUnit_Funding> orgs = new HashSet<OrganisationUnit_Funding>(orgFunds);
				funding.setOrganisationUnits_fundings(orgs);
				
				//persons
				Set<Person_Funding> pers = new HashSet<Person_Funding>(persFunds);
				funding.setPersons_fundings(pers);
				
				//projects
				Set<Project_Funding> projs = new HashSet<Project_Funding>(projFunds);
				funding.setProjects_fundings(projs);
				
				//Result Products
				Set<ResultProduct_Funding> resprods = new HashSet<ResultProduct_Funding>(resprodFunds);
				funding.setResultProducts_fundings(resprods);
				
				//Result Publications
				Set<ResultPublication_Funding> respubls = new HashSet<ResultPublication_Funding>(respublFunds);
				funding.setResultPublications_fundings(respubls);
				
				//services
				Set<Service_Funding> srvs = new HashSet<Service_Funding>(serviceFunds);
				funding.setServices_fundings(srvs);
				
				//indicators
				Set<Funding_Indicator> indics = new HashSet<Funding_Indicator>(fundIndic);
				funding.setFundings_indicators(indics);
				
				//mediums
				Set<Medium_Funding> meds = new HashSet<Medium_Funding>(medFund);
				funding.setMediums_fundings(meds);
				
				//events
				Set<Event_Funding> events = new HashSet<Event_Funding>(eventFunds);
				funding.setEvents_fundings(events);
				

				//FederatedIdentifiers
				if (showFedIds) {
					funding.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.FUNDING.getUuid(), funding.getId()));
				}
				
				result.add(funding);
			}
		}
		
		
		/*
		 * Class 
		 */
		if (iterClass != null) {
			while (iterClass.hasNext()) {
				Class theClass = iterClass.next(); 
				
				setClassInformation(theClass);
				
				List<Class_Class> classClass1 = new ArrayList<Class_Class>();
				List<Class_Class> classClass2 = new ArrayList<Class_Class>();
				if (links) {
					//classes 1
					classClass1 = service.getLinkService().getClassClassRepository().findByTheClass2(theClass);
					
					//classes 2
					classClass2 = service.getLinkService().getClassClassRepository().findByTheClass1(theClass);
				}
				//classes 1
				Set<Class_Class> classes1 = new HashSet<Class_Class>(classClass1);
				theClass.setClass_class1(classes1);
				
				//classes 2
				Set<Class_Class> classes2 = new HashSet<Class_Class>(classClass2);
				theClass.setClass_class2(classes2);
				
								
				//FederatedIdentifiers
				if (showFedIds) {
					theClass.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.CLASSIFICATION.getUuid(), theClass.getId()));
				}
								
				result.add(theClass);
			}
		}
		
		/*
		 * Class Scheme
		 */
		if (iterClassSchemes != null) {
			boolean embedClasses = hasEmbeddedEntities(ClassEnum.CLASSIFICATION, options);
			while (iterClassSchemes.hasNext()) {
				ClassScheme classScheme = iterClassSchemes.next(); 
				
				//Description
				List<ClassSchemeDescription> classSchemeDescriptions = service.getTranslationService().getClassSchemeDescriptionRepository().findByScheme(classScheme);
				Set<ClassSchemeDescription> descriptions = new HashSet<ClassSchemeDescription>(classSchemeDescriptions);
				classScheme.setClassSchemeDescriptions(descriptions);
				
				//Name
				List<ClassSchemeName> classSchemeNames = service.getTranslationService().getClassSchemeNameRepository().findByScheme(classScheme);
				Set<ClassSchemeName> names = new HashSet<ClassSchemeName>(classSchemeNames);
				classScheme.setClassSchemeNames(names);
				
				//FederatedIdentifiers
				if (showFedIds) {
					classScheme.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.CLASSIFICATION_SCHEME.getUuid(), classScheme.getId()));
				}	
				
				if (embedClasses) {
					Set<Class> classes = new HashSet<Class>(service.getSemanticService().getClassRepository().findByScheme(classScheme));
					if (classes != null && !classes.isEmpty()) {
						for (Class theClass : classes) {
							setClassInformation(theClass);
						}
						classScheme.setClasses(classes);
					}
				} else {
					classScheme.setClasses(new HashSet<Class>());
				}
				
				result.add(classScheme);
			}
		}
		
		
		/*
		 * ResultPublication 
		 */
		if (iterResultPublication != null) {
			while (iterResultPublication.hasNext()) {
				ResultPublication resultPublication = iterResultPublication.next(); 
				
				//titles
				List<ResultPublicationTitle> respublTitles = service.getTranslationService().getResultPublicationTitleRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationTitle> titles = new HashSet<ResultPublicationTitle>(respublTitles);
				resultPublication.setResultPublicationTitles(titles);
				
				//subtitles
				List<ResultPublicationSubtitle> respublSubtitles = service.getTranslationService().getResultPublicationSubtitleRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationSubtitle> subtitles = new HashSet<ResultPublicationSubtitle>(respublSubtitles);
				resultPublication.setResultPublicationSubtitles(subtitles);
				
				//keywords
				List<ResultPublicationKeyword> respublKeywords = service.getTranslationService().getResultPublicationKeywordRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationKeyword> keywords = new HashSet<ResultPublicationKeyword>(respublKeywords);
				resultPublication.setResultPublicationKeywords(keywords);
				
				//Bibliographic Notes
				List<ResultPublicationBibliographicNote> respublBibliographicNotes = service.getTranslationService().getResultPublicationBibliographicNoteRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationBibliographicNote> bibliographicNotes = new HashSet<ResultPublicationBibliographicNote>(respublBibliographicNotes);
				resultPublication.setResultPublicationBibliographicNotes(bibliographicNotes);
				
				//Name Abbreviations
				List<ResultPublicationNameAbbreviation> respublNameAbbreviations = service.getTranslationService().getResultPublicationNameAbbreviationRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationNameAbbreviation> nameAbbreviations = new HashSet<ResultPublicationNameAbbreviation>(respublNameAbbreviations);
				resultPublication.setResultPublicationNameAbbreviations(nameAbbreviations);
				
				//abstracts
				List<ResultPublicationAbstract> respublAbstracts = service.getTranslationService().getResultPublicationAbstractRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationAbstract> abstracts = new HashSet<ResultPublicationAbstract>(respublAbstracts);
				resultPublication.setResultPublicationAbstracts(abstracts);
				
				//version Infos
				List<ResultPublicationVersionInfo> respublVersionInfos = service.getTranslationService().getResultPublicationVersionInfoRepository().findByResultPublication(resultPublication);
				Set<ResultPublicationVersionInfo> versionInfos = new HashSet<ResultPublicationVersionInfo>(respublVersionInfos);
				resultPublication.setResultPublicationVersionInfos(versionInfos);
				
				List<ResultPublication_Class> respublClas = new ArrayList<ResultPublication_Class>();
				List<Person_ResultPublication> persRespubl = new ArrayList<Person_ResultPublication>();
				List<OrganisationUnit_ResultPublication> orgRespubls = new ArrayList<OrganisationUnit_ResultPublication>();
				List<Project_ResultPublication> resPublProj = new ArrayList<Project_ResultPublication>();
				List<ResultPublication_Funding> respublFunds = new ArrayList<ResultPublication_Funding>();
				List<ResultPublication_Facility> respublFacils = new ArrayList<ResultPublication_Facility>();
				List<ResultPublication_Equipment> respublEquipments = new ArrayList<ResultPublication_Equipment>();
				List<ResultPublication_ResultProduct> respublResultProd = new ArrayList<ResultPublication_ResultProduct>();
				List<ResultPublication_Service> serviceRespubls = new ArrayList<ResultPublication_Service>();
				List<ResultPublication_Measurement> respublMeass = new ArrayList<ResultPublication_Measurement>();
				List<ResultPublication_ResultPublication> respublRespubl1 = new ArrayList<ResultPublication_ResultPublication>();
				List<ResultPublication_ResultPublication> respublRespubl2 = new ArrayList<ResultPublication_ResultPublication>();
				List<ResultPublication_Indicator> resPublInd = new ArrayList<ResultPublication_Indicator>();
				List<ResultPublication_ResultPatent> resPublResPat = new ArrayList<ResultPublication_ResultPatent>();
				List<ResultPublication_Medium> resPublMediums = new ArrayList<ResultPublication_Medium>();
				List<ResultPublication_Event> resPublEvents = new ArrayList<ResultPublication_Event>();
				List<ResultPublication_Citation> resPublCite = new ArrayList<ResultPublication_Citation>();
				if (links) {
					//classes
					respublClas = service.getLinkService().getResultPublicationClassRepository().findByResultPublication(resultPublication);
					
					//persons
					persRespubl = service.getLinkService().getPersonResultPublicationRepository().findByResultPublication(resultPublication);
					
					//organisations
					orgRespubls = service.getLinkService().getOrganisationUnitResultPublicationRepository().findByResultPublication(resultPublication);
					
					//projects
					resPublProj = service.getLinkService().getProjectResultPublicationRepository().findByResultPublication(resultPublication);
					
					//result publications 1
					respublRespubl1 = service.getLinkService().getResultPublicationResultPublicationRepository().findByResultPublication2(resultPublication);
					
					//result publications 2
					respublRespubl2 = service.getLinkService().getResultPublicationResultPublicationRepository().findByResultPublication1(resultPublication);
					
					//funding
					respublFunds = service.getLinkService().getResultPublicationFundingRepository().findByResultPublication(resultPublication);
					
					//facilities
					respublFacils = service.getLinkService().getResultPublicationFacilityRepository().findByResultPublication(resultPublication);
					
					//Equipments
					respublEquipments = service.getLinkService().getResultPublicationEquipmentRepository().findByResultPublication(resultPublication);
					
					//result products
					respublResultProd = service.getLinkService().getResultPublicationResultProductRepository().findByResultPublication(resultPublication);
					
					//Services
					serviceRespubls = service.getLinkService().getResultPublicationServiceRepository().findByResultPublication(resultPublication);
					
					//measurements
					respublMeass = service.getLinkService().getResultPublicationMeasurementRepository().findByResultPublication(resultPublication);
					
					//indicators
					resPublInd = service.getLinkService().getResultPublicationIndicatorRepository().findByResultPublication(resultPublication);
					
					//result patents
					resPublResPat = service.getLinkService().getResultPublicationResultPatentRepository().findByResultPublication(resultPublication);
					
					//mediums
					resPublMediums = service.getLinkService().getResultPublicationMediumRepository().findByResultPublication(resultPublication);
					
					//events
					resPublEvents = service.getLinkService().getResultPublicationEventRepository().findByResultPublication(resultPublication);
					
					//citations
					resPublCite = service.getLinkService().getResultPublicationCitationRepository().findByResultPublication(resultPublication);
				}

				//classes
				Set<ResultPublication_Class> classes = new HashSet<ResultPublication_Class>(respublClas);
				resultPublication.setResultPublications_classes(classes);
				
				//persons
				Set<Person_ResultPublication> pers = new HashSet<Person_ResultPublication>(persRespubl);
				resultPublication.setPersons_resultPublications(pers);
				
				//organisations
				Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
				resultPublication.setOrganisationUnits_resultPublications(resultPublications2);
				
				//projects
				Set<Project_ResultPublication> projs = new HashSet<Project_ResultPublication>(resPublProj);
				resultPublication.setProjects_resultPublications(projs);
				
				//result publications 1
				Set<ResultPublication_ResultPublication> respubls1 = new HashSet<ResultPublication_ResultPublication>(respublRespubl1);
				resultPublication.setResultPublications_resultPublications1(respubls1);
				
				//result publications 2
				Set<ResultPublication_ResultPublication> respubls2 = new HashSet<ResultPublication_ResultPublication>(respublRespubl2);
				resultPublication.setResultPublications_resultPublications2(respubls2);
				
				//funding
				Set<ResultPublication_Funding> funds = new HashSet<ResultPublication_Funding>(respublFunds);
				resultPublication.setResultPublications_fundings(funds);
				
				//facilities
				Set<ResultPublication_Facility> facils = new HashSet<ResultPublication_Facility>(respublFacils);
				resultPublication.setResultPublications_facilities(facils);
				
				//Equipments
				Set<ResultPublication_Equipment> equipments = new HashSet<ResultPublication_Equipment>(respublEquipments);
				resultPublication.setResultPublications_equipments(equipments);
				
				//result products
				Set<ResultPublication_ResultProduct> resultProds = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
				resultPublication.setResultPublications_resultProducts(resultProds);
				
				//Services
				Set<ResultPublication_Service> srvs = new HashSet<ResultPublication_Service>(serviceRespubls);
				resultPublication.setResultPublications_services(srvs);
				
				//measurements
				Set<ResultPublication_Measurement> meass = new HashSet<ResultPublication_Measurement>(respublMeass);
				resultPublication.setResultPublications_measurements(meass);
				
				//indicators
				Set<ResultPublication_Indicator> indics = new HashSet<ResultPublication_Indicator>(resPublInd);
				resultPublication.setResultPublications_indicators(indics);
				
				//result patents
				Set<ResultPublication_ResultPatent> resPats = new HashSet<ResultPublication_ResultPatent>(resPublResPat);
				resultPublication.setResultPublications_resultPatents(resPats);

				//Mediums
				Set<ResultPublication_Medium> mediums = new HashSet<ResultPublication_Medium>(resPublMediums);
				resultPublication.setResultPublications_mediums(mediums);
				
				//events
				Set<ResultPublication_Event> events = new HashSet<ResultPublication_Event>(resPublEvents);
				resultPublication.setResultPublications_events(events);
				
				//citations
				Set<ResultPublication_Citation> citations = new HashSet<ResultPublication_Citation>(resPublCite);
				resultPublication.setResultPublications_citations(citations);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultPublication.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PUBLICATION.getUuid(), resultPublication.getId()));
				}

				result.add(resultPublication);
			}
		}
		
		
		/*
		 * ResultProduct 
		 */
		if (iterResultProduct != null) {
			while (iterResultProduct.hasNext()) {
				ResultProduct resultProduct = iterResultProduct.next(); 
				
				//names
				List<ResultProductName> resprodNames = service.getTranslationService().getResultProductNameRepository().findByResultProduct(resultProduct);
				Set<ResultProductName> names = new HashSet<ResultProductName>(resprodNames);
				resultProduct.setResultProductNames(names);
				
				//descriptions
				List<ResultProductDescription> resprodDescr = service.getTranslationService().getResultProductDescriptionRepository().findByResultProduct(resultProduct);
				Set<ResultProductDescription> descrs = new HashSet<ResultProductDescription>(resprodDescr);
				resultProduct.setResultProductDescriptions(descrs);
				
				//keywords
				List<ResultProductKeyword> resprodKeywords = service.getTranslationService().getResultProductKeywordRepository().findByResultProduct(resultProduct);
				Set<ResultProductKeyword> keywords = new HashSet<ResultProductKeyword>(resprodKeywords);
				resultProduct.setResultProductKeywords(keywords);
				
				//Version Info
				List<ResultProductVersionInfo> resprodVersionInfo = service.getTranslationService().getResultProductVersionInfoRepository().findByResultProduct(resultProduct);
				Set<ResultProductVersionInfo> versionInfos = new HashSet<ResultProductVersionInfo>(resprodVersionInfo);
				resultProduct.setResultProductVersionInfos(versionInfos);
				
				List<OrganisationUnit_ResultProduct> orgResprod = new ArrayList<OrganisationUnit_ResultProduct>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Project_ResultProduct> projResultProd = new ArrayList<Project_ResultProduct>();
				List<ResultProduct_Class> resprodClas = new ArrayList<ResultProduct_Class>();
				List<ResultProduct_Funding> resprodFunds = new ArrayList<ResultProduct_Funding>();
				List<ResultPublication_ResultProduct> respublResultProd = new ArrayList<ResultPublication_ResultProduct>();
				List<ResultProduct_ResultProduct> resprodResprod1 = new ArrayList<ResultProduct_ResultProduct>();
				List<ResultProduct_ResultProduct> resprodResprod2 = new ArrayList<ResultProduct_ResultProduct>();
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
				List<ResultProduct_Service> serviceResultProd = new ArrayList<ResultProduct_Service>();
				List<ResultProduct_Equipment> equipmentResultProd = new ArrayList<ResultProduct_Equipment>();
				List<ResultProduct_Measurement> resProdMeass = new ArrayList<ResultProduct_Measurement>();
				List<ResultProduct_Indicator> resProdInd = new ArrayList<ResultProduct_Indicator>();
				List<ResultProduct_Medium> resProdMed = new ArrayList<ResultProduct_Medium>();
				if (links) {
					//OrganisationUnits
					orgResprod = service.getLinkService().getOrganisationUnitResultProductRepository().findByResultProduct(resultProduct);
					
					//persons
					persResprod = service.getLinkService().getPersonResultProductRepository().findByResultProduct(resultProduct);
					
					//projects
					projResultProd = service.getLinkService().getProjectResultProductRepository().findByResultProduct(resultProduct);
					
					//classes
					resprodClas = service.getLinkService().getResultProductClassRepository().findByResultProduct(resultProduct);
					
					//funding
					resprodFunds = service.getLinkService().getResultProductFundingRepository().findByResultProduct(resultProduct);
					
					//result publications
					respublResultProd = service.getLinkService().getResultPublicationResultProductRepository().findByResultProduct(resultProduct);
					
					//result products 1
					resprodResprod1 = service.getLinkService().getResultProductResultProductRepository().findByResultProduct2(resultProduct);
					
					//result products 2
					resprodResprod2 = service.getLinkService().getResultProductResultProductRepository().findByResultProduct1(resultProduct);
					
					//facilities
					resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByResultProduct(resultProduct);
					
					//services
					serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByResultProduct(resultProduct);
					
					//equipments
					equipmentResultProd = service.getLinkService().getResultProductEquipmentRepository().findByResultProduct(resultProduct);
					
					//measurements
					resProdMeass = service.getLinkService().getResultProductMeasurementRepository().findByResultProduct(resultProduct);
					
					//indicators
					resProdInd = service.getLinkService().getResultProductIndicatorRepository().findByResultProduct(resultProduct);
					
					//mediums
					resProdMed = service.getLinkService().getResultProductMediumRepository().findByResultProduct(resultProduct);
				}
				//OrganisationUnits
				Set<OrganisationUnit_ResultProduct> resultProds = new HashSet<OrganisationUnit_ResultProduct>(orgResprod);
				resultProduct.setOrganisationUnits_resultProducts(resultProds);
				
				//persons
				Set<Person_ResultProduct> pers = new HashSet<Person_ResultProduct>(persResprod);
				resultProduct.setPersons_resultProducts(pers);
				
				//projects
				Set<Project_ResultProduct> projs = new HashSet<Project_ResultProduct>(projResultProd);
				resultProduct.setProjects_resultProducts(projs);
				
				//classes
				Set<ResultProduct_Class> classes = new HashSet<ResultProduct_Class>(resprodClas);
				resultProduct.setResultProducts_classes(classes);
				
				//funding
				Set<ResultProduct_Funding> funds = new HashSet<ResultProduct_Funding>(resprodFunds);
				resultProduct.setResultProducts_fundings(funds);
				
				//result publications
				Set<ResultPublication_ResultProduct> resultPubls = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
				resultProduct.setResultPublications_resultProducts(resultPubls);
				
				//result products 1
				Set<ResultProduct_ResultProduct> resultProds1 = new HashSet<ResultProduct_ResultProduct>(resprodResprod1);
				resultProduct.setResultProducts_resultProducts1(resultProds1);
				
				//result products 2
				Set<ResultProduct_ResultProduct> resultProds2 = new HashSet<ResultProduct_ResultProduct>(resprodResprod2);
				resultProduct.setResultProducts_resultProducts2(resultProds2);
				
				//facilities
				Set<ResultProduct_Facility> facils = new HashSet<ResultProduct_Facility>(resprodFacilities);
				resultProduct.setResultProducts_facilities(facils);
				
				//services
				Set<ResultProduct_Service> srvs = new HashSet<ResultProduct_Service>(serviceResultProd);
				resultProduct.setResultProducts_services(srvs);
				
				//equipments
				Set<ResultProduct_Equipment> equipments = new HashSet<ResultProduct_Equipment>(equipmentResultProd);
				resultProduct.setResultProducts_equipments(equipments);
				
				//measurements
				Set<ResultProduct_Measurement> meass = new HashSet<ResultProduct_Measurement>(resProdMeass);
				resultProduct.setResultProducts_measurements(meass);
				
				//indicators
				Set<ResultProduct_Indicator> indics = new HashSet<ResultProduct_Indicator>(resProdInd);
				resultProduct.setResultProducts_indicators(indics);
				
				//mediums
				Set<ResultProduct_Medium> mediums = new HashSet<ResultProduct_Medium>(resProdMed);
				resultProduct.setResultProducts_mediums(mediums);
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultProduct.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PRODUCT.getUuid(), resultProduct.getId()));
				}
				
				result.add(resultProduct);
			}
		}
		
		
		/*
		 * ResultPatent
		 */
		if (iterResultPatent != null) {
			while (iterResultPatent.hasNext()) {
				ResultPatent resultPatent = iterResultPatent.next(); 
				
				//titles
				List<ResultPatentTitle> respatTitles = service.getTranslationService().getResultPatentTitleRepository().findByResultPatent(resultPatent);
				Set<ResultPatentTitle> titles = new HashSet<ResultPatentTitle>(respatTitles);
				resultPatent.setResultPatentTitles(titles);
				
				//descriptions
				List<ResultPatentAbstract> respatAbstr = service.getTranslationService().getResultPatentAbstractRepository().findByResultPatent(resultPatent);
				Set<ResultPatentAbstract> abstrs = new HashSet<ResultPatentAbstract>(respatAbstr);
				resultPatent.setResultPatentAbstracts(abstrs);
				
				//keywords
				List<ResultPatentKeyword> respatKeywords = service.getTranslationService().getResultPatentKeywordRepository().findByResultPatent(resultPatent);
				Set<ResultPatentKeyword> keywords = new HashSet<ResultPatentKeyword>(respatKeywords);
				resultPatent.setResultPatentKeywords(keywords);
				
				//Version Info
				List<ResultPatentVersionInfo> respatVersionInfo = service.getTranslationService().getResultPatentVersionInfoRepository().findByResultPatent(resultPatent);
				Set<ResultPatentVersionInfo> versionInfos = new HashSet<ResultPatentVersionInfo>(respatVersionInfo);
				resultPatent.setResultPatentVersionInfos(versionInfos);
				
				List<Project_ResultPatent> projResultPat = new ArrayList<Project_ResultPatent>();
				List<Person_ResultPatent> persResPat = new ArrayList<Person_ResultPatent>();
				List<ResultPatent_Funding> resPatFund = new ArrayList<ResultPatent_Funding>();
				List<ResultPatent_Indicator> resPatInd = new ArrayList<ResultPatent_Indicator>();
				List<ResultPatent_Measurement> resPatMeas = new ArrayList<ResultPatent_Measurement>();
				List<ResultPatent_ResultPatent> resPatResPat1 = new ArrayList<ResultPatent_ResultPatent>();
				List<ResultPatent_ResultPatent> resPatResPat2 = new ArrayList<ResultPatent_ResultPatent>();
				List<ResultPublication_ResultPatent> resPublResPat = new ArrayList<ResultPublication_ResultPatent>();
				List<ResultPatent_Service> resPatSrv = new ArrayList<ResultPatent_Service>();
				List<ResultPatent_Equipment> resPatEquip = new ArrayList<ResultPatent_Equipment>();
				List<ResultPatent_Facility> resPatFac = new ArrayList<ResultPatent_Facility>();
				List<OrganisationUnit_ResultPatent> orgResPat = new ArrayList<OrganisationUnit_ResultPatent>();
				List<ResultPatent_Medium> resPatMed = new ArrayList<ResultPatent_Medium>();
				if (links) {
					//projects
					projResultPat = service.getLinkService().getProjectResultPatentRepository().findByResultPatent(resultPatent);
					
					//persons
					persResPat = service.getLinkService().getPersonResultPatentRepository().findByResultPatent(resultPatent);
					
					//fundings
					resPatFund = service.getLinkService().getResultPatentFundingRepository().findByResultPatent(resultPatent);
					
					//indicators
					resPatInd = service.getLinkService().getResultPatentIndicatorRepository().findByResultPatent(resultPatent);
					
					//measurements
					resPatMeas = service.getLinkService().getResultPatentMeasurementRepository().findByResultPatent(resultPatent);
					
					//result patent1
					resPatResPat1 = service.getLinkService().getResultPatentResultPatentRepository().findByResultPatent2(resultPatent);
					
					//result patent2
					resPatResPat2 = service.getLinkService().getResultPatentResultPatentRepository().findByResultPatent1(resultPatent);
					
					//result publications
					resPublResPat = service.getLinkService().getResultPublicationResultPatentRepository().findByResultPatent(resultPatent);
					
					//services
					resPatSrv = service.getLinkService().getResultPatentServiceRepository().findByResultPatent(resultPatent);
					
					//equipments
					resPatEquip = service.getLinkService().getResultPatentEquipmentRepository().findByResultPatent(resultPatent);
					
					//facilities
					resPatFac = service.getLinkService().getResultPatentFacilityRepository().findByResultPatent(resultPatent);
					
					//organisations
					orgResPat = service.getLinkService().getOrganisationUnitResultPatentRepository().findByResultPatent(resultPatent);
					
					//mediums
					resPatMed = service.getLinkService().getResultPatentMediumRepository().findByResultPatent(resultPatent);
					
				}
				//projects
				Set<Project_ResultPatent> projs = new HashSet<Project_ResultPatent>(projResultPat);
				resultPatent.setProjects_resultPatents(projs);
				
				//persons
				Set<Person_ResultPatent> pers = new HashSet<Person_ResultPatent>(persResPat);
				resultPatent.setPersons_resultPatents(pers);
				
				//fundings
				Set<ResultPatent_Funding> funds = new HashSet<ResultPatent_Funding>(resPatFund);
				resultPatent.setResultPatents_fundings(funds);
				
				//indicators
				Set<ResultPatent_Indicator> indics = new HashSet<ResultPatent_Indicator>(resPatInd);
				resultPatent.setResultPatents_indicators(indics);
				
				//measurements
				Set<ResultPatent_Measurement> meas = new HashSet<ResultPatent_Measurement>(resPatMeas);
				resultPatent.setResultPatents_measurements(meas);
				
				//result patent1
				Set<ResultPatent_ResultPatent> patents1 = new HashSet<ResultPatent_ResultPatent>(resPatResPat1);
				resultPatent.setResultPatents_resultPatents1(patents1);
				
				//result patent2
				Set<ResultPatent_ResultPatent> patents2 = new HashSet<ResultPatent_ResultPatent>(resPatResPat2);
				resultPatent.setResultPatents_resultPatents2(patents2);
				
				//result publications
				Set<ResultPublication_ResultPatent> resPubls = new HashSet<ResultPublication_ResultPatent>(resPublResPat);
				resultPatent.setResultPublications_resultPatents(resPubls);
				
				//services
				Set<ResultPatent_Service> srvs = new HashSet<ResultPatent_Service>(resPatSrv);
				resultPatent.setResultPatents_services(srvs);
				
				//equipments
				Set<ResultPatent_Equipment> equips = new HashSet<ResultPatent_Equipment>(resPatEquip);
				resultPatent.setResultPatents_equipments(equips);
				
				//facilities
				Set<ResultPatent_Facility> facs = new HashSet<ResultPatent_Facility>(resPatFac);
				resultPatent.setResultPatents_facilities(facs);
				
				//organisations
				Set<OrganisationUnit_ResultPatent> orgs = new HashSet<OrganisationUnit_ResultPatent>(orgResPat);
				resultPatent.setOrganisationUnits_resultPatents(orgs);
				
				//result patents
				Set<ResultPatent_Medium> meds = new HashSet<ResultPatent_Medium>(resPatMed);
				resultPatent.setResultPatents_mediums(meds);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultPatent.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PATENT.getUuid(), resultPatent.getId()));
				}
				
				result.add(resultPatent);
			}
		}
		
		
		/*
		 * Facility 
		 */
		if (iterFacility != null) {
			while (iterFacility.hasNext()) {
				Facility facility = iterFacility.next(); 
				
				//names
				List<FacilityName> facilityNames = service.getTranslationService().getFacilityNameRepository().findByFacility(facility);
				Set<FacilityName> names = new HashSet<FacilityName>(facilityNames);
				facility.setFacilityNames(names);
				
				//descriptions
				List<FacilityDescription> facilityDescr = service.getTranslationService().getFacilityDescriptionRepository().findByFacility(facility);
				Set<FacilityDescription> descriptions = new HashSet<FacilityDescription>(facilityDescr);
				facility.setFacilityDescriptions(descriptions);
				
				//keywords
				List<FacilityKeyword> facilityKeywords = service.getTranslationService().getFacilityKeywordRepository().findByFacility(facility);
				Set<FacilityKeyword> keywords = new HashSet<FacilityKeyword>(facilityKeywords);
				facility.setFacilityKeywords(keywords);
				
				List<Facility_Class> facilityClass = new ArrayList<Facility_Class>();
				List<OrganisationUnit_Facility> orgFacilities = new ArrayList<OrganisationUnit_Facility>();
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Person_Facility> facilityPers = new ArrayList<Person_Facility>();
				List<Project_Facility> projFacilities = new ArrayList<Project_Facility>();
				List<ResultPublication_Facility> respublFacilities = new ArrayList<ResultPublication_Facility>();
				List<Facility_PostalAddress> facilityPaddrs = new ArrayList<Facility_PostalAddress>();
				List<Facility_Facility> facilityFacility1 = new ArrayList<Facility_Facility>();
				List<Facility_Facility> facilityFacility2 = new ArrayList<Facility_Facility>();
				List<Facility_Equipment> equipmentFacilities = new ArrayList<Facility_Equipment>();
				List<Facility_Service> serviceFacilities = new ArrayList<Facility_Service>();
				List<ResultPatent_Facility> resPatFac = new ArrayList<ResultPatent_Facility>();
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
				List<Facility_Measurement> facilityMeass = new ArrayList<Facility_Measurement>();
				List<Facility_Indicator> facilIndic = new ArrayList<Facility_Indicator>();
				List<Facility_Event> facEvent = new ArrayList<Facility_Event>();
				if (links) {
					//classes
					facilityClass = service.getLinkService().getFacilityClassRepository().findByFacility(facility);
					
					//organisations
					orgFacilities = service.getLinkService().getOrganisationUnitFacilityRepository().findByFacility(facility);
					
					//fundings
					facilityFunds = service.getLinkService().getFacilityFundingRepository().findByFacility(facility);
					
					//persons
					facilityPers = service.getLinkService().getPersonFacilityRepository().findByFacility(facility);
					
					//projects
					projFacilities = service.getLinkService().getProjectFacilityRepository().findByFacility(facility);
					
					//Result Publications
					respublFacilities = service.getLinkService().getResultPublicationFacilityRepository().findByFacility(facility);
					
					//addresses
					facilityPaddrs = service.getLinkService().getFacilityPostalAddressRepository().findByFacility(facility);
					
					//facilities 1
					facilityFacility1 = service.getLinkService().getFacilityFacilityRepository().findByFacility2(facility);
					
					//facilities 2
					facilityFacility2 = service.getLinkService().getFacilityFacilityRepository().findByFacility1(facility);
					
					//equipments
					equipmentFacilities = service.getLinkService().getFacilityEquipmentRepository().findByFacility(facility);
					
					//services
					serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByFacility(facility);
					
					//measurements
					facilityMeass = service.getLinkService().getFacilityMeasurementRepository().findByFacility(facility);
					
					//Result products
					resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByFacility(facility);
					
					//Result patents
					resPatFac = service.getLinkService().getResultPatentFacilityRepository().findByFacility(facility);
					
					//Indicators
					facilIndic = service.getLinkService().getFacilityIndicatorRepository().findByFacility(facility);
					
					//events
					facEvent = service.getLinkService().getFacilityEventRepository().findByFacility(facility);
				}
				//classes
				Set<Facility_Class> classes = new HashSet<Facility_Class>(facilityClass);
				facility.setFacilities_classes(classes);
				
				//organisations
				Set<OrganisationUnit_Facility> orgs = new HashSet<OrganisationUnit_Facility>(orgFacilities);
				facility.setOrganisationUnits_facilities(orgs);
				
				//fundings
				Set<Facility_Funding> funds = new HashSet<Facility_Funding>(facilityFunds);
				facility.setFacilities_fundings(funds);
				
				//persons
				Set<Person_Facility> pers = new HashSet<Person_Facility>(facilityPers);
				facility.setPersons_facilities(pers);
				
				//projects
				Set<Project_Facility> projs = new HashSet<Project_Facility>(projFacilities);
				facility.setProjects_facilities(projs);
				
				//Result Publications
				Set<ResultPublication_Facility> respubls = new HashSet<ResultPublication_Facility>(respublFacilities);
				facility.setResultPublications_facilities(respubls);
				
				//addresses
				Set<Facility_PostalAddress> paddrs = new HashSet<Facility_PostalAddress>(facilityPaddrs);
				facility.setFacilities_postalAddresses(paddrs);
				
				//facilities 1
				Set<Facility_Facility> facilities1 = new HashSet<Facility_Facility>(facilityFacility1);
				facility.setFacilities_facilities1(facilities1);
				
				//facilities 2
				Set<Facility_Facility> facilities2 = new HashSet<Facility_Facility>(facilityFacility2);
				facility.setFacilities_facilities2(facilities2);
				
				//equipments
				Set<Facility_Equipment> equipments = new HashSet<Facility_Equipment>(equipmentFacilities);
				facility.setFacilities_equipments(equipments);
				
				//services
				Set<Facility_Service> srvs = new HashSet<Facility_Service>(serviceFacilities);
				facility.setFacilities_services(srvs);
				
				//measurements
				Set<Facility_Measurement> meass = new HashSet<Facility_Measurement>(facilityMeass);
				facility.setFacilities_measurements(meass);
				
				//Result products
				Set<ResultProduct_Facility> resultProds = new HashSet<ResultProduct_Facility>(resprodFacilities);
				facility.setResultProducts_facilities(resultProds);
				
				//Result patents
				Set<ResultPatent_Facility> resultPats = new HashSet<ResultPatent_Facility>(resPatFac);
				facility.setResultPatents_facilities(resultPats);
				
				//indicators
				Set<Facility_Indicator> indics = new HashSet<Facility_Indicator>(facilIndic);
				facility.setFacilities_indicators(indics);
				
				//events
				Set<Facility_Event> events = new HashSet<Facility_Event>(facEvent);
				facility.setFacilities_events(events);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					facility.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.FACILITY.getUuid(), facility.getId()));
				}
				
				result.add(facility);
			}
		}
		
		
		/*
		 * Service 
		 */
		if (iterService != null) {
			while (iterService.hasNext()) {
				Service serviceInst = iterService.next(); 
				
				//names
				List<ServiceName> serviceNames = service.getTranslationService().getServiceNameRepository().findByService(serviceInst);
				Set<ServiceName> names = new HashSet<ServiceName>(serviceNames);
				serviceInst.setServiceNames(names);
				
				//descriptions
				List<ServiceDescription> serviceDescr = service.getTranslationService().getServiceDescriptionRepository().findByService(serviceInst);
				Set<ServiceDescription> descriptions = new HashSet<ServiceDescription>(serviceDescr);
				serviceInst.setServiceDescriptions(descriptions);
				
				//keywords
				List<ServiceKeyword> serviceKeywords = service.getTranslationService().getServiceKeywordRepository().findByService(serviceInst);
				Set<ServiceKeyword> keywords = new HashSet<ServiceKeyword>(serviceKeywords);
				serviceInst.setServiceKeywords(keywords);
				
				List<OrganisationUnit_Service> serviceOrgs = new ArrayList<OrganisationUnit_Service>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				List<Service_Funding> serviceFunds = new ArrayList<Service_Funding>();
				List<Service_PostalAddress> servicePaddrs = new ArrayList<Service_PostalAddress>();
				List<Service_Service> serviceService1 = new ArrayList<Service_Service>();
				List<Service_Service> serviceService2 = new ArrayList<Service_Service>();
				List<Facility_Service> serviceFacilities = new ArrayList<Facility_Service>();
				List<Equipment_Service> equipmentServices = new ArrayList<Equipment_Service>();
				List<ResultPublication_Service> serviceRespubls = new ArrayList<ResultPublication_Service>();
				List<ResultProduct_Service> serviceResultProd = new ArrayList<ResultProduct_Service>();
				List<ResultPatent_Service> resPatSrv = new ArrayList<ResultPatent_Service>();
				List<Service_Measurement> serviceMeass = new ArrayList<Service_Measurement>();	
				List<Service_Class> serviceClass = new ArrayList<Service_Class>();
				List<Project_Service> serviceProj = new ArrayList<Project_Service>();
				List<Service_Indicator> servIndic = new ArrayList<Service_Indicator>();
				List<Service_Medium> srvMediums = new ArrayList<Service_Medium>();
				List<Service_Event> srvEvents = new ArrayList<Service_Event>();
				if (links) {
					//OrganisationUnits
					serviceOrgs = service.getLinkService().getOrganisationUnitServiceRepository().findByService(serviceInst);
					
					//persons
					servicePers = service.getLinkService().getPersonServiceRepository().findByService(serviceInst);
					
					//fundings
					serviceFunds = service.getLinkService().getServiceFundingRepository().findByService(serviceInst);
					
					//addresses
					servicePaddrs = service.getLinkService().getServicePostalAddressRepository().findByService(serviceInst);
					
					//Services 1
					serviceService1 = service.getLinkService().getServiceServiceRepository().findByService2(serviceInst);
					
					//Services 2
					serviceService2 = service.getLinkService().getServiceServiceRepository().findByService1(serviceInst);
					
					//facilities
					serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByService(serviceInst);
					
					//equipments
					equipmentServices = service.getLinkService().getEquipmentServiceRepository().findByService(serviceInst);
					
					//Result Publications
					serviceRespubls = service.getLinkService().getResultPublicationServiceRepository().findByService(serviceInst);
					
					//result products
					serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByService(serviceInst);
					
					//result patents
					resPatSrv = service.getLinkService().getResultPatentServiceRepository().findByService(serviceInst);
					
					//services
					serviceMeass = service.getLinkService().getServiceMeasurementRepository().findByService(serviceInst);
					
					//classes
					serviceClass = service.getLinkService().getServiceClassRepository().findByService(serviceInst);
					
					//projects
					serviceProj = service.getLinkService().getProjectServiceRepository().findByService(serviceInst);
					
					//indicators
					servIndic = service.getLinkService().getServiceIndicatorRepository().findByService(serviceInst);
					
					//mediums
					srvMediums = service.getLinkService().getServiceMediumRepository().findByService(serviceInst);
					
					//events
					srvEvents = service.getLinkService().getServiceEventRepository().findByService(serviceInst);
				}
				//OrganisationUnits
				Set<OrganisationUnit_Service> orgs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
				serviceInst.setOrganisationUnits_services(orgs);
				
				//persons
				Set<Person_Service> pers = new HashSet<Person_Service>(servicePers);
				serviceInst.setPersons_services(pers);
				
				//fundings
				Set<Service_Funding> funds = new HashSet<Service_Funding>(serviceFunds);
				serviceInst.setServices_fundings(funds);
				
				//addresses
				Set<Service_PostalAddress> paddrs = new HashSet<Service_PostalAddress>(servicePaddrs);
				serviceInst.setServices_postalAddresses(paddrs);
				
				//Services 1
				Set<Service_Service> services1 = new HashSet<Service_Service>(serviceService1);
				serviceInst.setServices_services1(services1);
				
				//Services 2
				Set<Service_Service> services2 = new HashSet<Service_Service>(serviceService2);
				serviceInst.setServices_services2(services2);
				
				//facilities
				Set<Facility_Service> facils = new HashSet<Facility_Service>(serviceFacilities);
				serviceInst.setFacilities_services(facils);
				
				//equipments
				Set<Equipment_Service> equipments = new HashSet<Equipment_Service>(equipmentServices);
				serviceInst.setEquipments_services(equipments);
				
				//Result Publications
				Set<ResultPublication_Service> resultPubls = new HashSet<ResultPublication_Service>(serviceRespubls);
				serviceInst.setResultPublications_services(resultPubls);
				
				//result products
				Set<ResultProduct_Service> resultProds = new HashSet<ResultProduct_Service>(serviceResultProd);
				serviceInst.setResultProducts_services(resultProds);
				
				//services
				Set<Service_Measurement> meass = new HashSet<Service_Measurement>(serviceMeass);
				serviceInst.setServices_measurements(meass);
				
				//classes
				Set<Service_Class> classes = new HashSet<Service_Class>(serviceClass);
				serviceInst.setServices_classes(classes);
				
				//projects
				Set<Project_Service> projs = new HashSet<Project_Service>(serviceProj);
				serviceInst.setProjects_services(projs);
				
				//indicators
				Set<Service_Indicator> indics = new HashSet<Service_Indicator>(servIndic);
				serviceInst.setServices_indicators(indics);
				
				//result patents
				Set<ResultPatent_Service> resPats = new HashSet<ResultPatent_Service>(resPatSrv);
				serviceInst.setResultPatents_services(resPats);
				
				//mediums
				Set<Service_Medium> mediums = new HashSet<Service_Medium>(srvMediums);
				serviceInst.setServices_mediums(mediums);
				
				//events
				Set<Service_Event> events = new HashSet<Service_Event>(srvEvents);
				serviceInst.setServices_events(events);
				
				//FederatedIdentifiers
				if (showFedIds) {
					serviceInst.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.SERVICE.getUuid(), serviceInst.getId()));
				}
				
				result.add(serviceInst);
			}
		}
		
		
		/*
		 * Equipment 
		 */
		if (iterEquipment != null) {
			while (iterEquipment.hasNext()) {
				Equipment equipment = iterEquipment.next(); 
				
				//names
				List<EquipmentName> equipmentNames = service.getTranslationService().getEquipmentNameRepository().findByEquipment(equipment);
				Set<EquipmentName> names = new HashSet<EquipmentName>(equipmentNames);
				equipment.setEquipmentNames(names);
				
				//descriptions
				List<EquipmentDescription> equipmentDescr = service.getTranslationService().getEquipmentDescriptionRepository().findByEquipment(equipment);
				Set<EquipmentDescription> descriptions = new HashSet<EquipmentDescription>(equipmentDescr);
				equipment.setEquipmentDescriptions(descriptions);
				
				//keywords
				List<EquipmentKeyword> equipmentKeywords = service.getTranslationService().getEquipmentKeywordRepository().findByEquipment(equipment);
				Set<EquipmentKeyword> keywords = new HashSet<EquipmentKeyword>(equipmentKeywords);
				equipment.setEquipmentKeywords(keywords);
				
				List<Equipment_Funding> equipmentFunds = new ArrayList<Equipment_Funding>();
				List<Equipment_Class> equipmentClass = new ArrayList<Equipment_Class>();
				List<OrganisationUnit_Equipment> equipmentOrgs = new ArrayList<OrganisationUnit_Equipment>();
				List<Person_Equipment> equipmentPers = new ArrayList<Person_Equipment>();
				List<Project_Equipment> equipmentProj = new ArrayList<Project_Equipment>();
				List<ResultPublication_Equipment> equipmentRespubls = new ArrayList<ResultPublication_Equipment>();
				List<Equipment_PostalAddress> equipmentPaddrs = new ArrayList<Equipment_PostalAddress>();
				List<Equipment_Equipment> equipmentEquipment1 = new ArrayList<Equipment_Equipment>();
				List<Equipment_Equipment> equipmentEquipment2 = new ArrayList<Equipment_Equipment>();
				List<Facility_Equipment> equipmentFacilities = new ArrayList<Facility_Equipment>();
				List<Equipment_Service> equipmentServices = new ArrayList<Equipment_Service>();
				List<ResultProduct_Equipment> equipmentResultProd = new ArrayList<ResultProduct_Equipment>();
				List<Equipment_Measurement> equipmentMeass = new ArrayList<Equipment_Measurement>();
				List<Equipment_Indicator> equipIndic = new ArrayList<Equipment_Indicator>();
				List<ResultPatent_Equipment> resPatEquip = new ArrayList<ResultPatent_Equipment>();
				List<Equipment_Medium> equipMediums = new ArrayList<Equipment_Medium>();
				List<Equipment_Event> equipEvents = new ArrayList<Equipment_Event>();
				if (links) {
					//fundings
					equipmentFunds = service.getLinkService().getEquipmentFundingRepository().findByEquipment(equipment);
					
					//classes
					equipmentClass = service.getLinkService().getEquipmentClassRepository().findByEquipment(equipment);
					
					//OrganisationUnits
					equipmentOrgs = service.getLinkService().getOrganisationUnitEquipmentRepository().findByEquipment(equipment);
					
					//persons
					equipmentPers = service.getLinkService().getPersonEquipmentRepository().findByEquipment(equipment);
					
					//projects
					equipmentProj = service.getLinkService().getProjectEquipmentRepository().findByEquipment(equipment);
					
					//Result Publications
					equipmentRespubls = service.getLinkService().getResultPublicationEquipmentRepository().findByEquipment(equipment);
					
					//addresses
					equipmentPaddrs = service.getLinkService().getEquipmentPostalAddressRepository().findByEquipment(equipment);
					
					//Equipments 1
					equipmentEquipment1 = service.getLinkService().getEquipmentEquipmentRepository().findByEquipment2(equipment);
					
					//Equipments 2
					equipmentEquipment2 = service.getLinkService().getEquipmentEquipmentRepository().findByEquipment1(equipment);
					
					//facilities
					equipmentFacilities = service.getLinkService().getFacilityEquipmentRepository().findByEquipment(equipment);
					
					//services
					equipmentServices = service.getLinkService().getEquipmentServiceRepository().findByEquipment(equipment);
					
					//result products
					equipmentResultProd = service.getLinkService().getResultProductEquipmentRepository().findByEquipment(equipment);

					//result patents
					resPatEquip = service.getLinkService().getResultPatentEquipmentRepository().findByEquipment(equipment);
					
					//measurements
					equipmentMeass = service.getLinkService().getEquipmentMeasurementRepository().findByEquipment(equipment);
					
					//indicators
					equipIndic = service.getLinkService().getEquipmentIndicatorRepository().findByEquipment(equipment);
					
					//mediums
					equipMediums = service.getLinkService().getEquipmentMediumRepository().findByEquipment(equipment);
					
					//events
					equipEvents = service.getLinkService().getEquipmentEventRepository().findByEquipment(equipment);
				}
				//fundings
				Set<Equipment_Funding> funds = new HashSet<Equipment_Funding>(equipmentFunds);
				equipment.setEquipments_fundings(funds);
				
				//classes
				Set<Equipment_Class> classes = new HashSet<Equipment_Class>(equipmentClass);
				equipment.setEquipments_classes(classes);
				
				//OrganisationUnits
				Set<OrganisationUnit_Equipment> orgs = new HashSet<OrganisationUnit_Equipment>(equipmentOrgs);
				equipment.setOrganisationUnits_equipments(orgs);
				
				//persons
				Set<Person_Equipment> pers = new HashSet<Person_Equipment>(equipmentPers);
				equipment.setPersons_equipments(pers);
				
				//projects
				Set<Project_Equipment> projs = new HashSet<Project_Equipment>(equipmentProj);
				equipment.setProjects_equipments(projs);
				
				//Result Publications
				Set<ResultPublication_Equipment> resultPubls = new HashSet<ResultPublication_Equipment>(equipmentRespubls);
				equipment.setResultPublications_equipments(resultPubls);
				
				//addresses
				Set<Equipment_PostalAddress> paddrs = new HashSet<Equipment_PostalAddress>(equipmentPaddrs);
				equipment.setEquipments_postalAddresses(paddrs);
				
				//Equipments 1
				Set<Equipment_Equipment> equipments1 = new HashSet<Equipment_Equipment>(equipmentEquipment1);
				equipment.setEquipments_equipments1(equipments1);
				
				//Equipments 2
				Set<Equipment_Equipment> equipments2 = new HashSet<Equipment_Equipment>(equipmentEquipment2);
				equipment.setEquipments_equipments2(equipments2);
				
				//facilities
				Set<Facility_Equipment> facils = new HashSet<Facility_Equipment>(equipmentFacilities);
				equipment.setFacilities_equipments(facils);
				
				//services
				Set<Equipment_Service> srvs = new HashSet<Equipment_Service>(equipmentServices);
				equipment.setEquipments_services(srvs);
				
				//result products
				Set<ResultProduct_Equipment> resultProds = new HashSet<ResultProduct_Equipment>(equipmentResultProd);
				equipment.setResultProducts_equipments(resultProds);
				
				//measurements
				Set<Equipment_Measurement> meass = new HashSet<Equipment_Measurement>(equipmentMeass);
				equipment.setEquipments_measurements(meass);
				
				//indicators
				Set<Equipment_Indicator> indics = new HashSet<Equipment_Indicator>(equipIndic);
				equipment.setEquipments_indicators(indics);
				
				//result patents
				Set<ResultPatent_Equipment> resPats = new HashSet<ResultPatent_Equipment>(resPatEquip);
				equipment.setResultPatents_equipments(resPats);
				
				//mediums
				Set<Equipment_Medium> mediums = new HashSet<Equipment_Medium>(equipMediums);
				equipment.setEquipments_mediums(mediums);
				
				//events
				Set<Equipment_Event> events = new HashSet<Equipment_Event>(equipEvents);
				equipment.setEquipments_events(events);

				
				//FederatedIdentifiers
				if (showFedIds) {
					equipment.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.EQUIPMENT.getUuid(), equipment.getId()));
				}
				
				result.add(equipment);
			}
		}
		
		
		/*
		 * FederatedIdentifier 
		 */
		if (iterFederatedIdentifier != null) {
			while (iterFederatedIdentifier.hasNext()) {
				FederatedIdentifier federatedIdentifier = iterFederatedIdentifier.next(); 
				
				List<FederatedIdentifier_Class> federatedIdentifierClasses = new ArrayList<FederatedIdentifier_Class>();
				List<Service_FederatedIdentifier> federatedIdentifierServices = new ArrayList<Service_FederatedIdentifier>();
				if (links) {
					//classes
					federatedIdentifierClasses = service.getLinkService().getFederatedIdentifierClassRepository().findByFedId(federatedIdentifier);
					
					//services
					federatedIdentifierServices = service.getLinkService().getServiceFederatedIdentifierRepository().findByFedId(federatedIdentifier);
				}
				//classes
				Set<FederatedIdentifier_Class> classes = new HashSet<FederatedIdentifier_Class>(federatedIdentifierClasses);
				federatedIdentifier.setFedIds_classes(classes);
				
				//services
				Set<Service_FederatedIdentifier> services = new HashSet<Service_FederatedIdentifier>(federatedIdentifierServices);
				federatedIdentifier.setServices_fedIds(services);
				
				result.add(federatedIdentifier);
			}
		}
		
		
		/*
		 * Measurements 
		 */
		if (iterMeasurement != null) {
			while (iterMeasurement.hasNext()) {
				Measurement measurement = iterMeasurement.next(); 
				
				//names
				List<MeasurementName> measurementNames = service.getTranslationService().getMeasurementNameRepository().findByMeasurement(measurement);
				Set<MeasurementName> names = new HashSet<MeasurementName>(measurementNames);
				measurement.setMeasurementNames(names);
				
				//keywords
				List<MeasurementKeyword> measKeys = service.getTranslationService().getMeasurementKeywordRepository().findByMeasurement(measurement);
				Set<MeasurementKeyword> keys = new HashSet<MeasurementKeyword>(measKeys);
				measurement.setMeasurementKeywords(keys);
				
				//descriptions
				List<MeasurementDescription> measDescr = service.getTranslationService().getMeasurementDescriptionRepository().findByMeasurement(measurement);
				Set<MeasurementDescription> descrs = new HashSet<MeasurementDescription>(measDescr);
				measurement.setMeasurementDescriptions(descrs);
				
				List<ResultProduct_Measurement> resProdMeass = new ArrayList<ResultProduct_Measurement>();
				List<Measurement_Class> measClass = new ArrayList<Measurement_Class>();
				List<Person_Measurement> persMeass = new ArrayList<Person_Measurement>();
				List<OrganisationUnit_Measurement> orgMeass = new ArrayList<OrganisationUnit_Measurement>();
				List<Project_Measurement> projMeass = new ArrayList<Project_Measurement>();
				List<Facility_Measurement> facilityMeass = new ArrayList<Facility_Measurement>();
				List<Service_Measurement> serviceMeass = new ArrayList<Service_Measurement>();
				List<Equipment_Measurement> equipmentMeass = new ArrayList<Equipment_Measurement>();
				List<ResultPublication_Measurement> respublMeass = new ArrayList<ResultPublication_Measurement>();
				List<Indicator_Measurement> indicMeas = new ArrayList<Indicator_Measurement>();
				List<ResultPatent_Measurement> resPatMeas = new ArrayList<ResultPatent_Measurement>();
				List<Medium_Measurement> medMeas = new ArrayList<Medium_Measurement>();
				List<Event_Measurement> eventMeas = new ArrayList<Event_Measurement>();
				if (links) {
					//products
					resProdMeass = service.getLinkService().getResultProductMeasurementRepository().findByMeasurement(measurement);
					
					//classes
					measClass = service.getLinkService().getMeasurementClassRepository().findByMeasurement(measurement);
					
					//persons
					persMeass = service.getLinkService().getPersonMeasurementRepository().findByMeasurement(measurement);
					
					//organisations
					orgMeass = service.getLinkService().getOrganisationUnitMeasurementRepository().findByMeasurement(measurement);
					
					//projects
					projMeass = service.getLinkService().getProjectMeasurementRepository().findByMeasurement(measurement);
					
					//Result Publications
					respublMeass = service.getLinkService().getResultPublicationMeasurementRepository().findByMeasurement(measurement);
					
					//facilities
					facilityMeass = service.getLinkService().getFacilityMeasurementRepository().findByMeasurement(measurement);
					
					//services
					serviceMeass = service.getLinkService().getServiceMeasurementRepository().findByMeasurement(measurement);
					
					//equipments
					equipmentMeass = service.getLinkService().getEquipmentMeasurementRepository().findByMeasurement(measurement);
					
					//indicators
					indicMeas = service.getLinkService().getIndicatorMeasurementRepository().findByMeasurement(measurement);
					
					//result patents
					resPatMeas = service.getLinkService().getResultPatentMeasurementRepository().findByMeasurement(measurement);
					
					//mediums
					medMeas = service.getLinkService().getMediumMeasurementRepository().findByMeasurement(measurement);
					
					//events
					eventMeas = service.getLinkService().getEventMeasurementRepository().findByMeasurement(measurement);
				}
				//products
				Set<ResultProduct_Measurement> resProds = new HashSet<ResultProduct_Measurement>(resProdMeass);
				measurement.setResultProducts_measurements(resProds);
				
				//classes
				Set<Measurement_Class> classes = new HashSet<Measurement_Class>(measClass);
				measurement.setMeasurements_classes(classes);
				
				//persons
				Set<Person_Measurement> pers = new HashSet<Person_Measurement>(persMeass);
				measurement.setPersons_measurements(pers);
				
				//organisations
				Set<OrganisationUnit_Measurement> orgs = new HashSet<OrganisationUnit_Measurement>(orgMeass);
				measurement.setOrganisationUnits_measurements(orgs);
				
				//projects
				Set<Project_Measurement> projs = new HashSet<Project_Measurement>(projMeass);
				measurement.setProjects_measurements(projs);
				
				//Result Publications
				Set<ResultPublication_Measurement> resultPubls = new HashSet<ResultPublication_Measurement>(respublMeass);
				measurement.setResultPublications_measurements(resultPubls);
				
				//facilities
				Set<Facility_Measurement> facils = new HashSet<Facility_Measurement>(facilityMeass);
				measurement.setFacilities_measurements(facils);
				
				//services
				Set<Service_Measurement> srvs = new HashSet<Service_Measurement>(serviceMeass);
				measurement.setServices_measurements(srvs);
				
				//equipments
				Set<Equipment_Measurement> equipments = new HashSet<Equipment_Measurement>(equipmentMeass);
				measurement.setEquipments_measurements(equipments);
				
				//indicators
				Set<Indicator_Measurement> indics = new HashSet<Indicator_Measurement>(indicMeas);
				measurement.setIndicators_measurements(indics);
				
				//result patents
				Set<ResultPatent_Measurement> resPats = new HashSet<ResultPatent_Measurement>(resPatMeas);
				measurement.setResultPatents_measurements(resPats);
				
				//mediums
				Set<Medium_Measurement> mediums = new HashSet<Medium_Measurement>(medMeas);
				measurement.setMediums_measurements(mediums);
				
				//events
				Set<Event_Measurement> events = new HashSet<Event_Measurement>(eventMeas);
				measurement.setEvents_measurements(events);
				
			
				//FederatedIdentifiers
				if (showFedIds) {
					measurement.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.MEASUREMENT.getUuid(), measurement.getId()));
				}
							
				result.add(measurement);	

			}
		}
		
		/*
		 * Indicator 
		 */
		if (iterIndicator != null) {
			while (iterIndicator.hasNext()) {
				Indicator indicator = iterIndicator.next(); 
				
				//names
				List<IndicatorName> indicatorNames = service.getTranslationService().getIndicatorNameRepository().findByIndicator(indicator);
				Set<IndicatorName> names = new HashSet<IndicatorName>(indicatorNames);
				indicator.setIndicatorNames(names);
				
				//keywords
				List<IndicatorKeyword> indicatorKeywords = service.getTranslationService().getIndicatorKeywordRepository().findByIndicator(indicator);
				Set<IndicatorKeyword> keys = new HashSet<IndicatorKeyword>(indicatorKeywords);
				indicator.setIndicatorKeywords(keys);
				
				//descriptions
				List<IndicatorDescription> indicatorDescriptions = service.getTranslationService().getIndicatorDescriptionRepository().findByIndicator(indicator);
				Set<IndicatorDescription> descrs = new HashSet<IndicatorDescription>(indicatorDescriptions);
				indicator.setIndicatorDescriptions(descrs);
				
				List<ResultPatent_Indicator> resPatInd = new ArrayList<ResultPatent_Indicator>();
				List<ResultProduct_Indicator> resProdInd = new ArrayList<ResultProduct_Indicator>();
				List<ResultPublication_Indicator> resPublInd = new ArrayList<ResultPublication_Indicator>();
				List<Service_Indicator> servIndic = new ArrayList<Service_Indicator>();
				List<Equipment_Indicator> equipIndic = new ArrayList<Equipment_Indicator>();
				List<Medium_Indicator> medIndic = new ArrayList<Medium_Indicator>();
				List<Indicator_Measurement> indicMeas = new ArrayList<Indicator_Measurement>();
				List<Indicator_Class> indicCl = new ArrayList<Indicator_Class>();
				List<Person_Indicator> persIndic = new ArrayList<Person_Indicator>();
				List<OrganisationUnit_Indicator> orgsIndic = new ArrayList<OrganisationUnit_Indicator>();
				List<Project_Indicator> projsIndic = new ArrayList<Project_Indicator>();
				List<Facility_Indicator> facilIndic = new ArrayList<Facility_Indicator>();
				List<Event_Indicator> eventIndic = new ArrayList<Event_Indicator>();
				List<Indicator_Indicator> indicIndic1 = new ArrayList<Indicator_Indicator>();
				List<Indicator_Indicator> indicIndic2 = new ArrayList<Indicator_Indicator>();
				List<Funding_Indicator> fundIndic = new ArrayList<Funding_Indicator>();
				if (links) {
					//patents
					resPatInd = service.getLinkService().getResultPatentIndicatorRepository().findByIndicator(indicator);
					
					//products
					resProdInd = service.getLinkService().getResultProductIndicatorRepository().findByIndicator(indicator);
					
					//publications
					resPublInd = service.getLinkService().getResultPublicationIndicatorRepository().findByIndicator(indicator);
					
					//services
					servIndic = service.getLinkService().getServiceIndicatorRepository().findByIndicator(indicator);
					
					//Equipments
					equipIndic = service.getLinkService().getEquipmentIndicatorRepository().findByIndicator(indicator);
					
					//mediums
					medIndic = service.getLinkService().getMediumIndicatorRepository().findByIndicator(indicator);		
					
					//measurements
					indicMeas = service.getLinkService().getIndicatorMeasurementRepository().findByIndicator(indicator);
					
					//classes
					indicCl = service.getLinkService().getIndicatorClassRepository().findByIndicator(indicator);
					
					//persons
					persIndic = service.getLinkService().getPersonIndicatorRepository().findByIndicator(indicator);
					
					//organisations
					orgsIndic = service.getLinkService().getOrganisationUnitIndicatorRepository().findByIndicator(indicator);
					
					//projects
					projsIndic = service.getLinkService().getProjectIndicatorRepository().findByIndicator(indicator);
					
					//facilities
					facilIndic = service.getLinkService().getFacilityIndicatorRepository().findByIndicator(indicator);
					
					//events
					eventIndic = service.getLinkService().getEventIndicatorRepository().findByIndicator(indicator);
					
					//indicators1
					indicIndic1 = service.getLinkService().getIndicatorIndicatorRepository().findByIndicator2(indicator);
					
					//indicators2
					indicIndic2 = service.getLinkService().getIndicatorIndicatorRepository().findByIndicator1(indicator);
					
					//fundings
					fundIndic = service.getLinkService().getFundingIndicatorRepository().findByIndicator(indicator);
				}
				//patents
				Set<ResultPatent_Indicator> resPats = new HashSet<ResultPatent_Indicator>(resPatInd);
				indicator.setResultPatents_indicators(resPats);
				
				//products
				Set<ResultProduct_Indicator> resProds = new HashSet<ResultProduct_Indicator>(resProdInd);
				indicator.setResultProducts_indicators(resProds);
				
				//publications
				Set<ResultPublication_Indicator> resPubls = new HashSet<ResultPublication_Indicator>(resPublInd);
				indicator.setResultPublications_indicators(resPubls);
				
				//services
				Set<Service_Indicator> servs = new HashSet<Service_Indicator>(servIndic);
				indicator.setServices_indicators(servs);
				
				//Equipments
				Set<Equipment_Indicator> equips = new HashSet<Equipment_Indicator>(equipIndic);
				indicator.setEquipments_indicators(equips);	
				
				//mediums
				Set<Medium_Indicator> meds = new HashSet<Medium_Indicator>(medIndic);
				indicator.setMediums_indicators(meds);	
				
				//measurements
				Set<Indicator_Measurement> meass = new HashSet<Indicator_Measurement>(indicMeas);
				indicator.setIndicators_measurements(meass);
				
				//classes
				Set<Indicator_Class> cls = new HashSet<Indicator_Class>(indicCl);
				indicator.setIndicators_classes(cls);
				
				//persons
				Set<Person_Indicator> pers = new HashSet<Person_Indicator>(persIndic);
				indicator.setPersons_indicators(pers);
				
				//organisations
				Set<OrganisationUnit_Indicator> orgs = new HashSet<OrganisationUnit_Indicator>(orgsIndic);
				indicator.setOrganisationUnits_indicators(orgs);
				
				//projects
				Set<Project_Indicator> projs = new HashSet<Project_Indicator>(projsIndic);
				indicator.setProjects_indicators(projs);
				
				//facilities
				Set<Facility_Indicator> facils = new HashSet<Facility_Indicator>(facilIndic);
				indicator.setFacilities_indicators(facils);
				
				//events
				Set<Event_Indicator> events = new HashSet<Event_Indicator>(eventIndic);
				indicator.setEvents_indicators(events);

				//indicators1
				Set<Indicator_Indicator> indics1 = new HashSet<Indicator_Indicator>(indicIndic1);
				indicator.setIndicators_indicators1(indics1);
				
				//indicators2
				Set<Indicator_Indicator> indics2 = new HashSet<Indicator_Indicator>(indicIndic2);
				indicator.setIndicators_indicators2(indics2);
				
				//fundings
				Set<Funding_Indicator> funds = new HashSet<Funding_Indicator>(fundIndic);
				indicator.setFundings_indicators(funds);
				
				//FederatedIdentifiers
				if (showFedIds) {
					indicator.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.INDICATOR.getUuid(), indicator.getId()));
				}
							
				result.add(indicator);	

			}
		}
		
		
		/*
		 * Medium 
		 */
		if (iterMedium != null) {
			while (iterMedium.hasNext()) {
				Medium medium = iterMedium.next(); 
				
				//titles
				List<MediumTitle> mediumTitles = service.getTranslationService().getMediumTitleRepository().findByMedium(medium);
				Set<MediumTitle> titles = new HashSet<MediumTitle>(mediumTitles);
				medium.setMediumTitles(titles);
				
				//descriptions
				List<MediumDescription> mediumDescr = service.getTranslationService().getMediumDescriptionRepository().findByMedium(medium);
				Set<MediumDescription> descriptions = new HashSet<MediumDescription>(mediumDescr);
				medium.setMediumDescriptions(descriptions);
				
				//keywords
				List<MediumKeyword> mediumKeywords = service.getTranslationService().getMediumKeywordRepository().findByMedium(medium);
				Set<MediumKeyword> keywords = new HashSet<MediumKeyword>(mediumKeywords);
				medium.setMediumKeywords(keywords);
				
				List<Person_Medium> personMediums = new ArrayList<Person_Medium>();
				List<ResultPublication_Medium> resPublMediums = new ArrayList<ResultPublication_Medium>();
				List<Service_Medium> srvMediums = new ArrayList<Service_Medium>();
				List<Equipment_Medium> equipMediums = new ArrayList<Equipment_Medium>();
				List<Facility_Medium> facilMediums = new ArrayList<Facility_Medium>();
				List<Medium_Funding> medFund = new ArrayList<Medium_Funding>();
				List<Medium_Indicator> medIndic = new ArrayList<Medium_Indicator>();
				List<Medium_Measurement> medMeas = new ArrayList<Medium_Measurement>();
				List<Medium_Medium> medMed1 = new ArrayList<Medium_Medium>();
				List<Medium_Medium> medMed2 = new ArrayList<Medium_Medium>();
				List<Project_Medium> projMed = new ArrayList<Project_Medium>();
				List<OrganisationUnit_Medium> orgMed = new ArrayList<OrganisationUnit_Medium>();
				List<Medium_Class> medClass = new ArrayList<Medium_Class>();
				List<ResultPatent_Medium> resPatMed = new ArrayList<ResultPatent_Medium>();
				List<ResultProduct_Medium> resProdMed = new ArrayList<ResultProduct_Medium>();
				List<Event_Medium> eventMed = new ArrayList<Event_Medium>();
				List<Citation_Medium> citeMedium = new ArrayList<Citation_Medium>();
				if (links) {
					//persons
					personMediums = service.getLinkService().getPersonMediumRepository().findByMedium(medium);
					
					//result publications
					resPublMediums = service.getLinkService().getResultPublicationMediumRepository().findByMedium(medium);
					
					//services
					srvMediums = service.getLinkService().getServiceMediumRepository().findByMedium(medium);
					
					//equipments
					equipMediums = service.getLinkService().getEquipmentMediumRepository().findByMedium(medium);
					
					//facilities
					facilMediums = service.getLinkService().getFacilityMediumRepository().findByMedium(medium);
					
					//fundings
					medFund = service.getLinkService().getMediumFundingRepository().findByMedium(medium);
					
					//indicators
					medIndic = service.getLinkService().getMediumIndicatorRepository().findByMedium(medium);
					
					//measurements
					medMeas = service.getLinkService().getMediumMeasurementRepository().findByMedium(medium);
					
					//mediums1
					medMed1 = service.getLinkService().getMediumMediumRepository().findByMedium2(medium);
					
					//mediums2
					medMed2 = service.getLinkService().getMediumMediumRepository().findByMedium1(medium);
					
					//projects
					projMed = service.getLinkService().getProjectMediumRepository().findByMedium(medium);
					
					//organisations
					orgMed = service.getLinkService().getOrganisationUnitMediumRepository().findByMedium(medium);
					
					//classes
					medClass = service.getLinkService().getMediumClassRepository().findByMedium(medium);
					
					//result patents
					resPatMed = service.getLinkService().getResultPatentMediumRepository().findByMedium(medium);
					
					//result products
					resProdMed = service.getLinkService().getResultProductMediumRepository().findByMedium(medium);
					
					//events
					eventMed = service.getLinkService().getEventMediumRepository().findByMedium(medium);
					
					//citations
					citeMedium = service.getLinkService().getCitationMediumRepository().findByMedium(medium);
					
				}
				//persons
				Set<Person_Medium> pers = new HashSet<Person_Medium>(personMediums);
				medium.setPersons_mediums(pers);	
				
				//result publications
				Set<ResultPublication_Medium> resPubls = new HashSet<ResultPublication_Medium>(resPublMediums);
				medium.setResultPublications_mediums(resPubls);
				
				//services
				Set<Service_Medium> srvs = new HashSet<Service_Medium>(srvMediums);
				medium.setServices_mediums(srvs);
				
				//equipments
				Set<Equipment_Medium> equips = new HashSet<Equipment_Medium>(equipMediums);
				medium.setEquipments_mediums(equips);
				
				//facilities
				Set<Facility_Medium> facils = new HashSet<Facility_Medium>(facilMediums);
				medium.setFacilities_mediums(facils);
				
				//fundings
				Set<Medium_Funding> funds = new HashSet<Medium_Funding>(medFund);
				medium.setMediums_fundings(funds);
				
				//indicators
				Set<Medium_Indicator> indics = new HashSet<Medium_Indicator>(medIndic);
				medium.setMediums_indicators(indics);
				
				//measurements
				Set<Medium_Measurement> measurs = new HashSet<Medium_Measurement>(medMeas);
				medium.setMediums_measurements(measurs);
				
				//mediums1
				Set<Medium_Medium> meds1 = new HashSet<Medium_Medium>(medMed1);
				medium.setMediums_mediums1(meds1);
				
				//mediums2
				Set<Medium_Medium> meds2 = new HashSet<Medium_Medium>(medMed2);
				medium.setMediums_mediums2(meds2);
				
				//projects
				Set<Project_Medium> projs = new HashSet<Project_Medium>(projMed);
				medium.setProjects_mediums(projs);
				
				//organisations
				Set<OrganisationUnit_Medium> orgs = new HashSet<OrganisationUnit_Medium>(orgMed);
				medium.setOrganisationUnits_mediums(orgs);
				
				//classes
				Set<Medium_Class> classes = new HashSet<Medium_Class>(medClass);
				medium.setMediums_classes(classes);
				
				//result patents
				Set<ResultPatent_Medium> resPats = new HashSet<ResultPatent_Medium>(resPatMed);
				medium.setResultPatents_mediums(resPats);
				
				//result products
				Set<ResultProduct_Medium> resProds = new HashSet<ResultProduct_Medium>(resProdMed);
				medium.setResultProducts_mediums(resProds);
				
				//events
				Set<Event_Medium> events = new HashSet<Event_Medium>(eventMed);
				medium.setEvents_mediums(events);
				
				//citations
				Set<Citation_Medium> citations = new HashSet<Citation_Medium>(citeMedium);
				medium.setCitations_mediums(citations);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					medium.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.MEDIUM.getUuid(), medium.getId()));
				}
				
				result.add(medium);
			}
		}
		
		/*
		 * Event
		 */
		if (iterEvent != null) {
			while (iterEvent.hasNext()) {
				Event event = iterEvent.next(); 
				
				//names
				List<EventName> eventNames = service.getTranslationService().getEventNameRepository().findByEvent(event);
				Set<EventName> names = new HashSet<EventName>(eventNames);
				event.setEventNames(names);
				
				//descriptions
				List<EventDescription> eventDescriptions = service.getTranslationService().getEventDescriptionRepository().findByEvent(event);
				Set<EventDescription> descriptions = new HashSet<EventDescription>(eventDescriptions);
				event.setEventDescriptions(descriptions);
				
				//keywords
				List<EventKeyword> eventKeywords = service.getTranslationService().getEventKeywordRepository().findByEvent(event);
				Set<EventKeyword> keywords = new HashSet<EventKeyword>(eventKeywords);
				event.setEventKeywords(keywords);
				
				List<Project_Event> projEvents = new ArrayList<Project_Event>();
				List<Person_Event> persEvents = new ArrayList<Person_Event>();
				List<ResultPublication_Event> resPublEvents = new ArrayList<ResultPublication_Event>();
				List<Event_Class> eventClasses = new ArrayList<Event_Class>();
				List<OrganisationUnit_Event> orgEvents = new ArrayList<OrganisationUnit_Event>();
				List<Service_Event> srvEvents = new ArrayList<Service_Event>();
				List<Equipment_Event> equipEvents = new ArrayList<Equipment_Event>();
				List<Event_Medium> eventMed = new ArrayList<Event_Medium>();
				List<Event_Indicator> eventIndic = new ArrayList<Event_Indicator>();
				List<Event_Measurement> eventMeas = new ArrayList<Event_Measurement>();
				List<Event_Event> eventEvent1 = new ArrayList<Event_Event>();
				List<Event_Event> eventEvent2 = new ArrayList<Event_Event>();
				List<Facility_Event> facEvents = new ArrayList<Facility_Event>();
				List<Event_Funding> eventFunds = new ArrayList<Event_Funding>();
				if (links) {
					//projects
					projEvents = service.getLinkService().getProjectEventRepository().findByEvent(event);	
					
					//persons
					persEvents = service.getLinkService().getPersonEventRepository().findByEvent(event);
					
					//result publications
					resPublEvents = service.getLinkService().getResultPublicationEventRepository().findByEvent(event);
					
					//classes
					eventClasses = service.getLinkService().getEventClassRepository().findByEvent(event);
					
					//organisations
					orgEvents = service.getLinkService().getOrganisationUnitEventRepository().findByEvent(event);
					
					//services
					srvEvents = service.getLinkService().getServiceEventRepository().findByEvent(event);
					
					//equipments
					equipEvents = service.getLinkService().getEquipmentEventRepository().findByEvent(event);
					
					//mediums
					eventMed = service.getLinkService().getEventMediumRepository().findByEvent(event);
					
					//indicators
					eventIndic = service.getLinkService().getEventIndicatorRepository().findByEvent(event);
					
					//measurements
					eventMeas = service.getLinkService().getEventMeasurementRepository().findByEvent(event);
					
					//events1
					eventEvent1 = service.getLinkService().getEventEventRepository().findByEvent2(event);
					
					//events2
					eventEvent2 = service.getLinkService().getEventEventRepository().findByEvent1(event);
					
					//facilities
					facEvents = service.getLinkService().getFacilityEventRepository().findByEvent(event);
					
					//fundings
					eventFunds = service.getLinkService().getEventFundingRepository().findByEvent(event);
				}
				//projects
				Set<Project_Event> projs = new HashSet<Project_Event>(projEvents);
				event.setProjects_events(projs);
				
				//persons
				Set<Person_Event> pers = new HashSet<Person_Event>(persEvents);
				event.setPersons_events(pers);
				
				//result publications
				Set<ResultPublication_Event> resPubls = new HashSet<ResultPublication_Event>(resPublEvents);
				event.setResultPublications_events(resPubls);
				
				//classes
				Set<Event_Class> classes = new HashSet<Event_Class>(eventClasses);
				event.setEvents_classes(classes);
				
				//organisations
				Set<OrganisationUnit_Event> orgs = new HashSet<OrganisationUnit_Event>(orgEvents);
				event.setOrganisationUnits_events(orgs);
				
				//services
				Set<Service_Event> srvs = new HashSet<Service_Event>(srvEvents);
				event.setServices_events(srvs);
				
				//equipments
				Set<Equipment_Event> equips = new HashSet<Equipment_Event>(equipEvents);
				event.setEquipments_events(equips);
				
				//mediums
				Set<Event_Medium> mediums = new HashSet<Event_Medium>(eventMed);
				event.setEvents_mediums(mediums);
				
				//indicators
				Set<Event_Indicator> indics = new HashSet<Event_Indicator>(eventIndic);
				event.setEvents_indicators(indics);
				
				//measurements
				Set<Event_Measurement> meass = new HashSet<Event_Measurement>(eventMeas);
				event.setEvents_measurements(meass);
				
				//events1
				Set<Event_Event> events1 = new HashSet<Event_Event>(eventEvent1);
				event.setEvents_events1(events1);
				
				//events2
				Set<Event_Event> events2 = new HashSet<Event_Event>(eventEvent2);
				event.setEvents_events2(events2);
				
				//facilities
				Set<Facility_Event> facils = new HashSet<Facility_Event>(facEvents);
				event.setFacilities_events(facils);
				
				//fundings
				Set<Event_Funding> funds = new HashSet<Event_Funding>(eventFunds);
				event.setEvents_fundings(funds);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					event.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.EVENT.getUuid(), event.getId()));
				}
				
				result.add(event);
			}
		}
		
		/*
		 * Citation
		 */
		if (iterCitation != null) {
			while (iterCitation.hasNext()) {
				Citation citation = iterCitation.next(); 
				
				//titles
				List<CitationTitle> citationTitles = service.getTranslationService().getCitationTitleRepository().findByCitation(citation);
				Set<CitationTitle> titles = new HashSet<CitationTitle>(citationTitles);
				citation.setCitationTitles(titles);
				
				//descriptions
				List<CitationDescription> citationDescriptions = service.getTranslationService().getCitationDescriptionRepository().findByCitation(citation);
				Set<CitationDescription> descriptions = new HashSet<CitationDescription>(citationDescriptions);
				citation.setCitationDescriptions(descriptions);
				
				List<ResultPublication_Citation> resPublCite = new ArrayList<ResultPublication_Citation>();
				List<Citation_Class> citeClass = new ArrayList<Citation_Class>();
				List<Citation_Medium> citeMedium = new ArrayList<Citation_Medium>();
				if (links) {
					//result publications
					resPublCite = service.getLinkService().getResultPublicationCitationRepository().findByCitation(citation);
					
					//classes
					citeClass = service.getLinkService().getCitationClassRepository().findByCitation(citation);	
					
					//mediums
					citeMedium = service.getLinkService().getCitationMediumRepository().findByCitation(citation);
				}
				//result publications
				Set<ResultPublication_Citation> resPubls = new HashSet<ResultPublication_Citation>(resPublCite);
				citation.setResultPublications_citations(resPubls);
				
				//classes
				Set<Citation_Class> classes = new HashSet<Citation_Class>(citeClass);
				citation.setCitations_classes(classes);
				
				//mediums
				Set<Citation_Medium> mediums = new HashSet<Citation_Medium>(citeMedium);
				citation.setCitations_mediums(mediums);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					citation.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.CITATION.getUuid(), citation.getId()));
				}
				
				result.add(citation);
			}
		}
		
		return result;		
	}
	
	/**
	 * Adds a federated identifier.
	 * @param entityTypeUuid The entity type UUID.
	 * @param entityId The entity id.
	 * @return a list of federated identifiers.
	 */
	private List<FederatedIdentifier> addFederatedIdentifier(String entityTypeUuid, Long entityId) {
		List<FederatedIdentifier> fedIds = service.getSecondService().getFederatedIdentifierRepository().findFedIdByClassUuidAndInstId(entityTypeUuid, entityId);
		for (FederatedIdentifier fedId: fedIds) {
			//classes
			List<FederatedIdentifier_Class> federatedIdentifierClasses = service.getLinkService().getFederatedIdentifierClassRepository().findByFedId(fedId);
			Set<FederatedIdentifier_Class> fedClasses = new HashSet<FederatedIdentifier_Class>(federatedIdentifierClasses);
			fedId.setFedIds_classes(fedClasses);
				
			//services
			List<Service_FederatedIdentifier> federatedIdentifierServices = service.getLinkService().getServiceFederatedIdentifierRepository().findByFedId(fedId);
			Set<Service_FederatedIdentifier> fedServices = new HashSet<Service_FederatedIdentifier>(federatedIdentifierServices);
			fedId.setServices_fedIds(fedServices);
		}

		return fedIds;
	}
	
	/**
	 * Sets the classification information.
	 * @param classification The classification.
	 */
	private void setClassInformation(Class classification) {
		//descriptions
		List<ClassDescription> classDescriptions = service.getTranslationService().getClassDescriptionRepository().findByTheClass(classification);
		Set<ClassDescription> descriptions = new HashSet<ClassDescription>(classDescriptions);
		classification.setClassDescriptions(descriptions);
		
		//terms
		List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(classification);
		Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
		classification.setClassTerms(terms);
		
		//definitions
		List<ClassDefinition> classDefinitions = service.getTranslationService().getClassDefinitionRepository().findByTheClass(classification);
		Set<ClassDefinition> definitions = new HashSet<ClassDefinition>(classDefinitions);
		classification.setClassDefinitions(definitions);
		
		//ex
		List<ClassEx> classExs = service.getTranslationService().getClassExRepository().findByTheClass(classification);
		Set<ClassEx> examples = new HashSet<ClassEx>(classExs);
		classification.setClassExs(examples);
	}
	
	/**
	 * Whether the options contain an entity of the specified type.
	 * @param entity The entity classification type.
	 * @param options
	 * @return
	 */
	private boolean hasEntities(ClassEnum entity, SelectionOptions options) {
		return (options.getListOfEntitiesIncluded().contains(entity.getName()) || 
			   options.getListOfEntitiesIncluded().contains("all") || 
			   options.getListOfEntitiesIncluded().isEmpty() ||  //empty list equals to list with all or full list
			   options.getEntities().contains(entity)) && !options.getListOfEntitiesExcluded().contains(entity.getName());
	}
	
	/**
	 * Whether the options contain an embedded entity of the specified type.
	 * @param entity The entity classification type.
	 * @param options The selection options.
	 * @return false/true.
	 */
	private boolean hasEmbeddedEntities(ClassEnum entity, SelectionOptions options) {
		return options.getEmbeddedEntities().contains(entity);
	}

	/**
	 * Retrieves some entities based on the given options.
	 * @param repository The persistence repositoty.
	 * @param options The selection options.
	 * @return some entities.
	 * @throws SelectionException
	 */
	@SuppressWarnings("unchecked")
	private <T, R> Iterator<T> retrieveEntities(R repository, SelectionOptions options) throws SelectionException {
		Iterator<T> result = null;
		
		try {
			Iterable<T> iterable = null;	
			if (options.isFindById()) {
				List<T> list = new ArrayList<T>();
				T entity;
				entity = (T) repository.getClass().getMethod("findById", Long.class).invoke(repository, Long.valueOf(options.getId().toString()));
				if (entity != null) {
					list.add(entity);
					iterable = list;
				}
			
			} else if (options.isFindByUUID()) {
				List<T> list = new ArrayList<T>();
				T entity = (T) repository.getClass().getMethod("findByUUID", String.class).invoke(repository, (String)options.getId());
				if (entity != null) {
					list.add(entity);
					iterable = list;
				}
				
			} else if (options.getWindowSize() == 0) {
				iterable = (Iterable<T>) repository.getClass().getMethod("findAll").invoke(repository);
				
			} else {
				Page<T> projectsPage = (Page<T>) repository.getClass().getMethod("findAll", Pageable.class).invoke(repository, new PageRequest(options.getWindowOffset() / options.getWindowSize(), options.getWindowSize()));
				iterable = projectsPage.getContent();
			}
			
			if (iterable != null) {
				result = iterable.iterator(); 
			}
		} catch (Exception e) {
			logger.error(String.format("Error during selection. Options = [%s] ", options), e);
			throw new SelectionException(e.getMessage());
		}
		
		return result;
	}

}

