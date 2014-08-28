package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Equipment;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_Measurement;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_Measurement;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Measurement;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Measurement;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingKeyword;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;
import gr.ekt.cerif.features.multilingual.MeasurementName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
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
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;
import gr.ekt.cerif.services.second.FederatedIdentifierRepository;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;
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
		Iterator<Service> iterService = null;
		Iterator<Equipment> iterEquipment = null;
		Iterator<FederatedIdentifier> iterFederatedIdentifier = null;	
		Iterator<Measurement> iterMeasurement = null;
		
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
				List<Project_ResultPublication> projRespubls = new ArrayList<Project_ResultPublication>();
				List<Project_Service> serviceProj = new ArrayList<Project_Service>();
				List<Project_Measurement> projMeass = new ArrayList<Project_Measurement>();
				List<Project_Class> projclas = new ArrayList<Project_Class>();
				List<Project_Equipment> projEquipments = new ArrayList<Project_Equipment>();
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
				}
				//facilities
				Set<Project_Facility> facils = new HashSet<Project_Facility>(projFacilities);
				project.setProjects_facilities(facils);
				
				//fundings
				Set<Project_Funding> funds = new HashSet<Project_Funding>(projFunds);
				project.setProjects_fundings(funds);
				
				//organisations
				Set<Project_OrganisationUnit> orgs = new HashSet<Project_OrganisationUnit>(projorgs);
				project.setOrganisationUnits(orgs);
				
				//persons
				Set<Project_Person> pers = new HashSet<Project_Person>(projpers);
				project.setPersons(pers);
				
				//projects 1
				Set<Project_Project> projs1 = new HashSet<Project_Project>(projProj1);
				project.setProjects_projects1(projs1);
				
				//projects 2
				Set<Project_Project> projs2 = new HashSet<Project_Project>(projProj2);
				project.setProjects_projects2(projs2);
				
				//result products
				Set<Project_ResultProduct> resultProds = new HashSet<Project_ResultProduct>(projResultProd);
				project.setProjects_resultProducts(resultProds);
				
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
				}
				//classes
				Set<OrganisationUnit_Class> classes = new HashSet<OrganisationUnit_Class>(orgclass);
				organisation.setClasses(classes);
				
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
				organisation.setProjects(projs);
				
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
				
				//names
				List<PersonName> persNames = service.getAdditionalService().getPersonNameRepository().findByPerson(person);
				Set<PersonName> names = new HashSet<PersonName>(persNames);
				person.setPersonNames(names);
				
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
				List<Project_Person> persProj = new ArrayList<Project_Person>();
				List<Person_PostalAddress> persPaddrs = new ArrayList<Person_PostalAddress>();
				List<Person_Measurement> persMeass = new ArrayList<Person_Measurement>();
				List<Person_ResultPublication> persRespubls = new ArrayList<Person_ResultPublication>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
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
					
					//organisations
					persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByPerson(person);
					
					//Result products
					persResprod = service.getLinkService().getPersonResultProductRepository().findByPerson(person);
					
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
				person.setClasses(classes);
				
				//equipments
				Set<Person_Equipment> equipments = new HashSet<Person_Equipment>(persEquipment);
				person.setPersons_equipments(equipments);
				
				//facilities
				Set<Person_Facility> facils = new HashSet<Person_Facility>(persFacilities);
				person.setPersons_facilities(facils);
				
				//funding
				Set<Person_Funding> funds = new HashSet<Person_Funding>(persFunds);
				person.setPersons_fundings(funds);
				
				//organisations
				Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
				person.setPersons_organisationUnits(pers);
				
				//Result products
				Set<Person_ResultProduct> resultProds = new HashSet<Person_ResultProduct>(persResprod);
				person.setPersons_resultProducts(resultProds);
				
				//projects
				Set<Project_Person> projs = new HashSet<Project_Person>(persProj);
				person.setProjects(projs);
				
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
				classScheme.setDescriptions(descriptions);
				
				//Name
				List<ClassSchemeName> classSchemeNames = service.getTranslationService().getClassSchemeNameRepository().findByScheme(classScheme);
				Set<ClassSchemeName> names = new HashSet<ClassSchemeName>(classSchemeNames);
				classScheme.setNames(names);
				
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
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultProduct.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PRODUCT.getUuid(), resultProduct.getId()));
				}
				
				result.add(resultProduct);
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
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
				List<Facility_Measurement> facilityMeass = new ArrayList<Facility_Measurement>();
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
				List<Service_Measurement> serviceMeass = new ArrayList<Service_Measurement>();	
				List<Service_Class> serviceClass = new ArrayList<Service_Class>();
				List<Project_Service> serviceProj = new ArrayList<Project_Service>();
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
					
					//services
					serviceMeass = service.getLinkService().getServiceMeasurementRepository().findByService(serviceInst);
					
					//classes
					serviceClass = service.getLinkService().getServiceClassRepository().findByService(serviceInst);
					
					//projects
					serviceProj = service.getLinkService().getProjectServiceRepository().findByService(serviceInst);
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
				serviceInst.setServices_postalAdresses(paddrs);
				
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
					
					//measurements
					equipmentMeass = service.getLinkService().getEquipmentMeasurementRepository().findByEquipment(equipment);
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
				
			
				//FederatedIdentifiers
				if (showFedIds) {
					measurement.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.MEASUREMENT.getUuid(), measurement.getId()));
				}
							
				result.add(measurement);	

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
		classification.setDescriptions(descriptions);
		
		//terms
		List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(classification);
		Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
		classification.setTerms(terms);
		
		//definitions
		List<ClassDefinition> classDefinitions = service.getTranslationService().getClassDefinitionRepository().findByTheClass(classification);
		Set<ClassDefinition> definitions = new HashSet<ClassDefinition>(classDefinitions);
		classification.setDefinitions(definitions);
		
		//ex
		List<ClassEx> classExs = service.getTranslationService().getClassExRepository().findByTheClass(classification);
		Set<ClassEx> examples = new HashSet<ClassEx>(classExs);
		classification.setExs(examples);
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
