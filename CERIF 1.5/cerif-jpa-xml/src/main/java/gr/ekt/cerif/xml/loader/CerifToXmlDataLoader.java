/**
 * 
 */
package gr.ekt.cerif.xml.loader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.Equipment_Class;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Equipment_Service;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Equipment;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.FederatedIdentifier_Class;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_FederatedIdentifier;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Equipment;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Equipment;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
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
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.cerif.xml.records.base.CerifOrganisationUnitRecord;
import gr.ekt.cerif.xml.records.base.CerifPersonRecord;
import gr.ekt.cerif.xml.records.base.CerifProjectRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifEquipmentRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifFacilityRecord;
import gr.ekt.cerif.xml.records.infrastructure.CerifServiceRecord;
import gr.ekt.cerif.xml.records.result.CerifResultProductRecord;
import gr.ekt.cerif.xml.records.result.CerifResultPublicationRecord;
import gr.ekt.cerif.xml.records.second.CerifElectronicAddressRecord;
import gr.ekt.cerif.xml.records.second.CerifFederatedIdentifierRecord;
import gr.ekt.cerif.xml.records.second.CerifFundingRecord;
import gr.ekt.cerif.xml.records.second.CerifPostalAddressRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassRecord;
import gr.ekt.cerif.xml.records.semantics.CerifClassSchemeRecord;
import gr.ekt.transformationengine.core.DataLoader;
import gr.ekt.transformationengine.core.RecordSet;
import gr.ekt.cerif.xml.loadingSpecs.LoadingSpecs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * @author bonisv
 *
 */
@Component
public class CerifToXmlDataLoader extends DataLoader {
	
	@Autowired
	private PersistenceService service;
	
	private int size=0,c=0;
	Iterable<Project> projects;
	Iterator<Project> iterProject;
	Iterable<OrganisationUnit> organisations;
	Iterator<OrganisationUnit> iterOrganisationUnit;
	Iterable<Person> persons;
	Iterator<Person> iterPerson;
	Iterable<ElectronicAddress> electronicAddresses;
	Iterator<ElectronicAddress> iterElectronicAddress;
	Iterable<PostalAddress> postalAddresses;
	Iterator<PostalAddress> iterPostalAddress;
	List<Funding> fundings;
	Iterator<Funding> iterFunding;
	List<Class> theClasses;
	Iterator<Class> iterClass;
	List<ClassScheme> classSchemes;
	Iterator<ClassScheme> iterClassSchemes;
	List<ResultPublication> resultPublications;
	Iterator<ResultPublication> iterResultPublication;
	List<Facility> facilities;
	Iterator<Facility> iterFacility;
	List<ResultProduct> resultProducts;
	Iterator<ResultProduct> iterResultProduct;
	List<Service> services;
	Iterator<Service> iterService;
	List<Equipment> equipments;
	Iterator<Equipment> iterEquipment;
	List<FederatedIdentifier> federatedIdentifiers;
	Iterator<FederatedIdentifier> iterFederatedIdentifier;

	public CerifToXmlDataLoader() {
		super();
	}
	
	@Override
	public RecordSet loadData() {
		RecordSet rs = new RecordSet();
		Integer windowSize = ((LoadingSpecs)this.getLoadingSpec()).getWindowSize();
		Integer windowOffset = ((LoadingSpecs)this.getLoadingSpec()).getWindowOffset();
		boolean links = ((LoadingSpecs)this.getLoadingSpec()).isLinks();
		boolean showFedIds = ((LoadingSpecs)this.getLoadingSpec()).isShowFedIds();

		
		/*
		 * Entities
		 */
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.PROJECT.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {

			if (windowSize == 0) {
				projects = service.getBaseService().getProjectRepository().findAll();
			} else {
				Page<Project> projectsPage = service.getBaseService().getProjectRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				projects = projectsPage.getContent();
			}
			iterProject = projects.iterator();
			/*if (projects instanceof Collection)
				size = ((Collection<Project>)projects).size();
			System.out.println("projects: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.ORGANISATION.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				organisations = service.getBaseService().getOrganisationUnitRepository().findAll();
			} else {
				Page<OrganisationUnit> organisationUnitPage =service.getBaseService().getOrganisationUnitRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				organisations = organisationUnitPage.getContent();
			}
			iterOrganisationUnit = organisations.iterator();
			/*if (organisations instanceof Collection)
				size = ((Collection<OrganisationUnit>)organisations).size();
			System.out.println("organisations: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.PERSON.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				persons = service.getBaseService().getPersonRepository().findAll();
			} else {
				Page<Person> personPage =service.getBaseService().getPersonRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				persons = personPage.getContent();
			}
			iterPerson = persons.iterator();
			/*if (persons instanceof Collection)
				size = ((Collection<Person>)persons).size();
			System.out.println("persons: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.ELECTRONIC_ADDRESS.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				electronicAddresses = service.getSecondService().getElectronicAddressRepository().findAll();
			} else {
				Page<ElectronicAddress> electronicAddressPage =service.getSecondService().getElectronicAddressRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				electronicAddresses = electronicAddressPage.getContent();
			}
			iterElectronicAddress = electronicAddresses.iterator();
			/*if (electronicAddresses instanceof Collection)
				size = ((Collection<ElectronicAddress>)electronicAddresses).size();
			System.out.println("electronicAddresses: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.POSTAL_ADDRESS.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				postalAddresses = service.getSecondService().getPostalAddressRepository().findAll();
			} else {
				Page<PostalAddress> postalAddressPage =service.getSecondService().getPostalAddressRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				postalAddresses = postalAddressPage.getContent();
			}
			iterPostalAddress = postalAddresses.iterator();
			/*if (postalAddresses instanceof Collection)
				size = ((Collection<PostalAddress>)postalAddresses).size();
			System.out.println("postalAddresses: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.FUNDING.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				fundings = service.getSecondService().getFundingRepository().findAll();
			} else {
				Page<Funding> fundingPage =service.getSecondService().getFundingRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				fundings = fundingPage.getContent();
			}
			iterFunding = fundings.iterator();
			/*if (fundings instanceof Collection)
				size = ((Collection<Funding>)fundings).size();
			System.out.println("fundings: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.CLASSIFICATION.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				theClasses = service.getSemanticService().getClassRepository().findAll();
			} else {
				Page<Class> classPage =service.getSemanticService().getClassRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				theClasses = classPage.getContent();
			}
			iterClass = theClasses.iterator();
			/*if (theClasses instanceof Collection)
				size = ((Collection<Class>)theClasses).size();
			System.out.println("classes: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.CLASSIFICATION_SCHEME.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				classSchemes = service.getSemanticService().getClassSchemeRepository().findAll();
			} else {
				Page<ClassScheme> classSchemePage =service.getSemanticService().getClassSchemeRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				classSchemes = classSchemePage.getContent();
			}
			iterClassSchemes = classSchemes.iterator();
			/*if (classSchemes instanceof Collection)
				size = ((Collection<ClassScheme>)classSchemes).size();
			System.out.println("classSchemes: "+size);*/
		}

		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.PUBLICATION.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				resultPublications = service.getResultService().getResultPublicationRepository().findAll();
			} else {
				Page<ResultPublication> resultPublicationPage =service.getResultService().getResultPublicationRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				resultPublications = resultPublicationPage.getContent();
			}
			iterResultPublication = resultPublications.iterator();
			/*if (resultPublications instanceof Collection)
				size = ((Collection<ResultPublication>)resultPublications).size();
			System.out.println("resultPublications: "+size);*/
		}

		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.FACILITY.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				facilities = service.getInfrastructureService().getFacilityRepository().findAll();
			} else {
				Page<Facility> facilityPage =service.getInfrastructureService().getFacilityRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				facilities = facilityPage.getContent();
			}
			iterFacility = facilities.iterator();
			/*if (facilities instanceof Collection)
				size = ((Collection<Facility>)facilities).size();
			System.out.println("facilities: "+size);*/
		}

		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.PRODUCT.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				resultProducts = service.getResultService().getResultProductRepository().findAll();
			} else {
				Page<ResultProduct> productPage =service.getResultService().getResultProductRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				resultProducts = productPage.getContent();
			}
			iterResultProduct = resultProducts.iterator();
			/*if (resultProducts instanceof Collection)
				size = ((Collection<ResultProduct>)resultProducts).size();
			System.out.println("resultProducts: "+size);*/
		}

		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.SERVICE.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				services = service.getInfrastructureService().getServiceRepository().findAll();
			} else {
				Page<Service> servicePage =service.getInfrastructureService().getServiceRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				services = servicePage.getContent();
			}
			iterService = services.iterator();
			/*if (services instanceof Collection)
				size = ((Collection<Service>)services).size();
			System.out.println("services: "+size);*/
		}
		
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.EQUIPMENT.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				equipments = service.getInfrastructureService().getEquipmentRepository().findAll();
			} else {
				Page<Equipment> equipmentPage =service.getInfrastructureService().getEquipmentRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				equipments = equipmentPage.getContent();
			}
			iterEquipment = equipments.iterator();
			/*if (equipments instanceof Collection)
				size = ((Collection<Equipment>)equipments).size();
			System.out.println("equipment: "+size);*/
		}
		
		if (((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains(ClassEnum.FEDERATED_IDENTIFIER.getName()) || 
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().contains("all") ||
				((LoadingSpecs)this.getLoadingSpec()).getListOfEntitiesExported().isEmpty()) {
			
			if (windowSize == 0) {
				federatedIdentifiers = service.getSecondService().getFederatedIdentifierRepository().findAll();
			} else {
				Page<FederatedIdentifier> federatedIdentifierPage =service.getSecondService().getFederatedIdentifierRepository().findAll(new PageRequest(windowOffset/windowSize, windowSize));
				federatedIdentifiers = federatedIdentifierPage.getContent();
			}
			iterFederatedIdentifier = federatedIdentifiers.iterator();
			/*if (federatedIdentifiers instanceof Collection)
				size = ((Collection<FederatedIdentifier>)federatedIdentifiers).size();
			System.out.println("federatedIdentifiers: "+size);*/
		}

		
		/*
		 * Project 
		 */
		if (iterProject != null) {
			c=0;
			while (iterProject.hasNext()) {
				Project project = iterProject.next(); 
				
				//titles
				List<ProjectTitle> projTitles = service.getTranslationService().getProjectTitleRepository().findByProject(project);
				for (ProjectTitle t:projTitles) {
					t.setTitle(cleanSpecialCharacters(t.getTitle()));
				}
				Set<ProjectTitle> titles = new HashSet<ProjectTitle>(projTitles);
				project.setProjectTitles(titles);
				
				//abstract
				List<ProjectAbstract> projAbs = service.getTranslationService().getProjectAbstractRepository().findByProject(project);
				for (ProjectAbstract a:projAbs) {
					a.setAbstractText(cleanSpecialCharacters(a.getAbstractText()));
				}
				Set<ProjectAbstract> abs = new HashSet<ProjectAbstract>(projAbs);
				project.setProjectAbstracts(abs);
				
				//keywords
				List<ProjectKeyword> projKeys = service.getTranslationService().getProjectKeywordRepository().findByProject(project);
				for (ProjectKeyword k:projKeys) {
					k.setKeyword(cleanSpecialCharacters(k.getKeyword()));
				}
				Set<ProjectKeyword> keys = new HashSet<ProjectKeyword>(projKeys);
				project.setProjectKeywords(keys);
				
				List<Project_OrganisationUnit> projorgs = new ArrayList<Project_OrganisationUnit>();
				List<Project_Facility> projFacilities = new ArrayList<Project_Facility>();
				List<Project_Funding> projFunds = new ArrayList<Project_Funding>();
				List<Project_Person> projpers = new ArrayList<Project_Person>();
				List<Project_ResultProduct> projResultProd = new ArrayList<Project_ResultProduct>();
				List<Project_ResultPublication> projRespubls = new ArrayList<Project_ResultPublication>();
				List<Project_Service> serviceProj = new ArrayList<Project_Service>();
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
					
					//result products
					projResultProd = service.getLinkService().getProjectResultProductRepository().findByProject(project);
					
					//Result Publications
					projRespubls = service.getLinkService().getProjectResultPublicationRepository().findByProject(project);
					
					//services
					serviceProj = service.getLinkService().getProjectServiceRepository().findByProject(project);
					
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
				
				//result products
				Set<Project_ResultProduct> resultProds = new HashSet<Project_ResultProduct>(projResultProd);
				project.setProjects_resultProducts(resultProds);
				
				//Result Publications
				Set<Project_ResultPublication> resultPubls = new HashSet<Project_ResultPublication>(projRespubls);
				project.setProjects_resultPublications(resultPubls);
				
				//services
				Set<Project_Service> srvs = new HashSet<Project_Service>(serviceProj);
				project.setProjects_services(srvs);
				
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
				
				
				CerifProjectRecord projectRecord = new CerifProjectRecord(project);
				rs.addRecord(projectRecord);
				/*c++;
				System.out.println("project: "+project.getId()+", ("+c+")");*/
			}
		}
		
		/*
		 * OrganisationUnits
		 */
		if (iterOrganisationUnit != null) {
			c=0;
			while (iterOrganisationUnit.hasNext()) {
				OrganisationUnit organisation = iterOrganisationUnit.next(); 
				
				//names
				List<OrganisationUnitName> orgNames = service.getTranslationService().getOrganisationUnitNameRepository().findByOrganisationUnit(organisation);
				for (OrganisationUnitName on:orgNames) {
					on.setName(cleanSpecialCharacters(on.getName()));
				}
				Set<OrganisationUnitName> names = new HashSet<OrganisationUnitName>(orgNames);
				organisation.setOrganisationUnitNames(names);
				
				//Research Activities
				List<OrganisationUnitResearchActivity> orgResearchActivities = service.getTranslationService().getOrganisationUnitResearchActivityRepository().findByOrganisationUnit(organisation);
				for (OrganisationUnitResearchActivity ora: orgResearchActivities) {
					ora.setResearchActivity(cleanSpecialCharacters(ora.getResearchActivity()));
				}
				Set<OrganisationUnitResearchActivity> researchActivities = new HashSet<OrganisationUnitResearchActivity>(orgResearchActivities);
				organisation.setOrganisationUnitResearchActivities(researchActivities);
				
				//Keywords
				List<OrganisationUnitKeyword> orgKeywords = service.getTranslationService().getOrganisationUnitKeywordRepository().findByOrganisationUnit(organisation);
				for (OrganisationUnitKeyword ork: orgKeywords) {
					ork.setKeyword(cleanSpecialCharacters(ork.getKeyword()));
				}
				Set<OrganisationUnitKeyword> keywords = new HashSet<OrganisationUnitKeyword>(orgKeywords);
				organisation.setOrganisationUnitKeywords(keywords);
				
				List<OrganisationUnit_Class> orgclass = new ArrayList<OrganisationUnit_Class>();
				List<OrganisationUnit_Equipment> equipmentOrgs = new ArrayList<OrganisationUnit_Equipment>();
				List<OrganisationUnit_ElectronicAddress> orgEaddrs = new ArrayList<OrganisationUnit_ElectronicAddress>();
				List<OrganisationUnit_Facility> orgFacilities = new ArrayList<OrganisationUnit_Facility>();
				List<OrganisationUnit_Funding> orgFunds = new ArrayList<OrganisationUnit_Funding>();
				List<OrganisationUnit_ResultProduct> orgResprod = new ArrayList<OrganisationUnit_ResultProduct>();
				List<Person_OrganisationUnit> persOrg = new ArrayList<Person_OrganisationUnit>();
				List<Project_OrganisationUnit> projorgs = new ArrayList<Project_OrganisationUnit>();
				List<OrganisationUnit_PostalAddress> orgPaddrs = new ArrayList<OrganisationUnit_PostalAddress>();
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
					
					//result products
					orgResprod = service.getLinkService().getOrganisationUnitResultProductRepository().findByOrganisationUnit(organisation);
					
					//persons
					persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByOrganisationUnit(organisation);
					
					//projects
					projorgs = service.getLinkService().getProjectOrganisationUnitRepository().findByOrganisationUnit(organisation);
					
					//addresses
					orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByOrganisationUnit(organisation);
					
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
				organisation.setElectronicAddresses(eaddrs);
				
				//facilities
				Set<OrganisationUnit_Facility> facils = new HashSet<OrganisationUnit_Facility>(orgFacilities);
				organisation.setOrganisationUnits_facilities(facils);
				
				//funding
				Set<OrganisationUnit_Funding> funds = new HashSet<OrganisationUnit_Funding>(orgFunds);
				organisation.setOrganisationUnits_fundings(funds);
				
				//result products
				Set<OrganisationUnit_ResultProduct> resultProds = new HashSet<OrganisationUnit_ResultProduct>(orgResprod);
				organisation.setResultProducts(resultProds);
				
				//persons
				Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
				organisation.setPersons_organisationUnits(pers);
				
				//projects
				Set<Project_OrganisationUnit> projs = new HashSet<Project_OrganisationUnit>(projorgs);
				organisation.setProjects(projs);
				
				//addresses
				Set<OrganisationUnit_PostalAddress> paddrs = new HashSet<OrganisationUnit_PostalAddress>(orgPaddrs);
				organisation.setPostalAddresses(paddrs);
				
				//Result Publications
				Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
				organisation.setResultPublications(resultPublications2);
				
				//services
				Set<OrganisationUnit_Service> srvs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
				organisation.setOrganisationUnits_services(srvs);
						
				
				//FederatedIdentifiers
				if (showFedIds) {
					organisation.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.ORGANISATION.getUuid(), organisation.getId()));
				}
				
				
				CerifOrganisationUnitRecord organisationUnitRecord = new CerifOrganisationUnitRecord(organisation);
				rs.addRecord(organisationUnitRecord);
				/*c++;
				System.out.println("organisation: "+organisation.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Person 
		 */
		if (iterPerson != null) {
			c=0;
			while (iterPerson.hasNext()) {
				Person person = iterPerson.next(); 
				
				//names
				List<PersonName> persNames = service.getAdditionalService().getPersonNameRepository().findByPerson(person);
				Set<PersonName> names = new HashSet<PersonName>(persNames);
				person.setPersonNames(names);
				
				//Research Interests
				List<PersonResearchInterest> persResearchActivities = service.getTranslationService().getPersonResearchInterestRepository().findByPerson(person);
				for (PersonResearchInterest perri: persResearchActivities) {
					perri.setResearchInterests(cleanSpecialCharacters(perri.getResearchInterests()));
				}
				Set<PersonResearchInterest> researchInterests = new HashSet<PersonResearchInterest>(persResearchActivities);
				person.setPersonResearchInterests(researchInterests);
				
				//Keywords
				List<PersonKeyword> persKeywords = service.getTranslationService().getPersonKeywordRepository().findByPerson(person);
				for (PersonKeyword perk: persKeywords) {
					perk.setKeyword(cleanSpecialCharacters(perk.getKeyword()));
				}
				Set<PersonKeyword> keywords = new HashSet<PersonKeyword>(persKeywords);
				person.setPersonKeywords(keywords);
				
				List<Person_ElectronicAddress> persEaddrs = new ArrayList<Person_ElectronicAddress>();
				List<Person_Class> persClas = new ArrayList<Person_Class>();
				List<Person_Equipment> persEquipment = new ArrayList<Person_Equipment>();
				List<Person_Facility> persFacilities = new ArrayList<Person_Facility>();
				List<Person_Funding> persFunds = new ArrayList<Person_Funding>();
				List<Person_OrganisationUnit> persOrg = new ArrayList<Person_OrganisationUnit>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Project_Person> persProj = new ArrayList<Project_Person>();
				List<Person_PostalAddress> persPaddrs = new ArrayList<Person_PostalAddress>();
				List<Person_ResultPublication> persRespubls = new ArrayList<Person_ResultPublication>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				if (links) {
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
					
					//Result Publications
					persRespubls = service.getLinkService().getPersonResultPublicationRepository().findByPerson(person);
					
					//services
					servicePers = service.getLinkService().getPersonServiceRepository().findByPerson(person);
				}
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
				
				
				CerifPersonRecord personRecord = new CerifPersonRecord(person);
				rs.addRecord(personRecord);		
				/*c++;
				System.out.println("person: "+person.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * ElectronicAddress 
		 */
		if (iterElectronicAddress != null) {
			c=0;
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
				electronicAddress.setOrganisationUnits(orgs);
				
				//persons
				Set<Person_ElectronicAddress> pers = new HashSet<Person_ElectronicAddress>(persEaddrs);
				electronicAddress.setPersons_electronicAddresses(pers);
				
				//classes
				Set<ElectronicAddress_Class> classes = new HashSet<ElectronicAddress_Class>(eaddrClass);
				electronicAddress.setClasses(classes);
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					electronicAddress.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.ELECTRONIC_ADDRESS.getUuid(), electronicAddress.getId()));
				}
				
								
				CerifElectronicAddressRecord electronicAddressRecord = new CerifElectronicAddressRecord(electronicAddress);
				rs.addRecord(electronicAddressRecord);	
				/*c++;
				System.out.println("postalAddress: "+electronicAddress.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * PostalAddress 
		 */
		if (iterPostalAddress != null) {
			c=0;
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
				postalAddress.setOrganisationUnits(orgs);
				
				//persons
				Set<Person_PostalAddress> pers = new HashSet<Person_PostalAddress>(persPaddrs);
				postalAddress.setPersons_postalAddresses(pers);
				
				//classes
				Set<PostalAddress_Class> classes = new HashSet<PostalAddress_Class>(paddrClass);
				postalAddress.setClasses(classes);
				
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
							
				CerifPostalAddressRecord postalAddressRecord = new CerifPostalAddressRecord(postalAddress);
				rs.addRecord(postalAddressRecord);	
				/*c++;
				System.out.println("postalAddress: "+postalAddress.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Funding 
		 */
		if (iterFunding != null) {
			c=0;
			while (iterFunding.hasNext()) {
				Funding funding = iterFunding.next(); 
				
				//names
				List<FundingName> fundNames = service.getTranslationService().getFundingNameRepository().findByFunding(funding);
				for (FundingName name:fundNames) {
					name.setName(cleanSpecialCharacters(name.getName()));
				}
				Set<FundingName> names = new HashSet<FundingName>(fundNames);
				funding.setFundingNames(names);
				
				//Keywords
				List<FundingKeyword> fundKeywords = service.getTranslationService().getFundingKeywordRepository().findByFunding(funding);
				for (FundingKeyword funk:fundKeywords) {
					funk.setKeyword(cleanSpecialCharacters(funk.getKeyword()));
				}
				Set<FundingKeyword> keywords = new HashSet<FundingKeyword>(fundKeywords);
				funding.setFundingKeywords(keywords);
		
				//descriptions
				List<FundingDescription> fundDescr = service.getTranslationService().getFundingDescriptionRepository().findByFunding(funding);
				for (FundingDescription descr:fundDescr) {
					descr.setDescription(cleanSpecialCharacters(descr.getDescription()));
				}
				Set<FundingDescription> descrs = new HashSet<FundingDescription>(fundDescr);
				funding.setFundingDescriptions(descrs);
				
				List<Equipment_Funding> equipmentFunds = new ArrayList<Equipment_Funding>();
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Funding_Class> fundingClas = new ArrayList<Funding_Class>();
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
				funding.setClasses(classes);
				
				//organistaions
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
				
				CerifFundingRecord fundingRecord = new CerifFundingRecord(funding);
				rs.addRecord(fundingRecord);	
				/*c++;
				System.out.println("funding: "+funding.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Class 
		 */
		if (iterClass != null) {
			c=0;
			while (iterClass.hasNext()) {
				Class theClass = iterClass.next(); 
				
				//descriptions
				List<ClassDescription> classDescriptions = service.getTranslationService().getClassDescriptionRepository().findByTheClass(theClass);
				for (ClassDescription descr: classDescriptions) {
					descr.setDescription(cleanSpecialCharacters(descr.getDescription()));
					if (descr.getDescriptionSrc()!=null) {
						descr.setDescriptionSrc(cleanSpecialCharacters(descr.getDescriptionSrc()));
					}
				}
				Set<ClassDescription> descriptions = new HashSet<ClassDescription>(classDescriptions);
				theClass.setDescriptions(descriptions);
				
				//terms
				List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(theClass);
				for (ClassTerm clt: classTerms) {
					clt.setTerm(cleanSpecialCharacters(clt.getTerm()));
					if (clt.getRoleExpr()!=null) {
						clt.setRoleExpr(cleanSpecialCharacters(clt.getRoleExpr()));
					}
					if (clt.getRoleExprOpp()!=null) {
						clt.setRoleExprOpp(cleanSpecialCharacters(clt.getRoleExprOpp()));
					}
					if (clt.getTermSrc()!=null) {
						clt.setTermSrc(cleanSpecialCharacters(clt.getTermSrc()));
					}
				}
				Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
				theClass.setTerms(terms);
				
				//definitions
				List<ClassDefinition> classDefinitions = service.getTranslationService().getClassDefinitionRepository().findByTheClass(theClass);
				for (ClassDefinition cldef: classDefinitions) {
					cldef.setDefinition(cleanSpecialCharacters(cldef.getDefinition()));
					if (cldef.getDefinitionSrc()!=null) {
						cldef.setDefinitionSrc(cleanSpecialCharacters(cldef.getDefinitionSrc()));
					}
				}
				Set<ClassDefinition> definitions = new HashSet<ClassDefinition>(classDefinitions);
				theClass.setDefinitions(definitions);
				
				//ex
				List<ClassEx> classExs = service.getTranslationService().getClassExRepository().findByTheClass(theClass);
				for (ClassEx cle: classExs) {
					cle.setEx(cleanSpecialCharacters(cle.getEx()));
					if (cle.getExSrc()!=null) {
						cle.setExSrc(cleanSpecialCharacters(cle.getExSrc()));
					}
				}
				Set<ClassEx> examples = new HashSet<ClassEx>(classExs);
				theClass.setExs(examples);
								
				//FederatedIdentifiers
				if (showFedIds) {
					theClass.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.CLASSIFICATION.getUuid(), theClass.getId()));
				}
								
				CerifClassRecord classRecord = new CerifClassRecord(theClass);
				rs.addRecord(classRecord);	
				/*c++;
				System.out.println("class: "+theClass.getId()+", ("+c+")");*/
			}
		}
		
		/*
		 * Class Scheme
		 */
		if (iterClassSchemes != null) {
			c=0;
			while (iterClassSchemes.hasNext()) {
				ClassScheme classScheme = iterClassSchemes.next(); 
				
				//Description
				List<ClassSchemeDescription> classSchemeDescriptions = service.getTranslationService().getClassSchemeDescriptionRepository().findByScheme(classScheme);
				for (ClassSchemeDescription clsd: classSchemeDescriptions) {
					clsd.setDescription(cleanSpecialCharacters(clsd.getDescription()));
					if (clsd.getDescriptionSrc()!=null) {
						clsd.setDescriptionSrc(cleanSpecialCharacters(clsd.getDescriptionSrc()));
					}
				}
				Set<ClassSchemeDescription> descriptions = new HashSet<ClassSchemeDescription>(classSchemeDescriptions);
				classScheme.setDescriptions(descriptions);
				
				//Name
				List<ClassSchemeName> classSchemeNames = service.getTranslationService().getClassSchemeNameRepository().findByScheme(classScheme);
				for (ClassSchemeName clsn: classSchemeNames) {
					clsn.setName(cleanSpecialCharacters(clsn.getName()));
					if (clsn.getNameSrc()!=null) {
						clsn.setNameSrc(cleanSpecialCharacters(clsn.getNameSrc()));
					}
				}
				Set<ClassSchemeName> names = new HashSet<ClassSchemeName>(classSchemeNames);
				classScheme.setNames(names);
				
				//FederatedIdentifiers
				if (showFedIds) {
					classScheme.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.CLASSIFICATION_SCHEME.getUuid(), classScheme.getId()));
				}				
				
				CerifClassSchemeRecord classSchemeRecord = new CerifClassSchemeRecord(classScheme);
				rs.addRecord(classSchemeRecord);	
				/*c++;
				System.out.println("classScheme: "+classScheme.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * ResultPublication 
		 */
		if (iterResultPublication != null) {
			c=0;
			while (iterResultPublication.hasNext()) {
				ResultPublication resultPublication = iterResultPublication.next(); 
				
				//titles
				List<ResultPublicationTitle> respublTitles = service.getTranslationService().getResultPublicationTitleRepository().findByResultPublication(resultPublication);
				for (ResultPublicationTitle title:respublTitles) {
					title.setTitle(cleanSpecialCharacters(title.getTitle()));
				}
				Set<ResultPublicationTitle> titles = new HashSet<ResultPublicationTitle>(respublTitles);
				resultPublication.setResultPublicationTitles(titles);
				
				//subtitles
				List<ResultPublicationSubtitle> respublSubtitles = service.getTranslationService().getResultPublicationSubtitleRepository().findByResultPublication(resultPublication);
				for (ResultPublicationSubtitle subtitle:respublSubtitles) {
					subtitle.setSubtitle(cleanSpecialCharacters(subtitle.getSubtitle()));
				}
				Set<ResultPublicationSubtitle> subtitles = new HashSet<ResultPublicationSubtitle>(respublSubtitles);
				resultPublication.setResultPublicationSubtitles(subtitles);
				
				//keywords
				List<ResultPublicationKeyword> respublKeywords = service.getTranslationService().getResultPublicationKeywordRepository().findByResultPublication(resultPublication);
				for (ResultPublicationKeyword keyword:respublKeywords) {
					keyword.setKeyword(cleanSpecialCharacters(keyword.getKeyword()));
				}
				Set<ResultPublicationKeyword> keywords = new HashSet<ResultPublicationKeyword>(respublKeywords);
				resultPublication.setResultPublicationKeywords(keywords);
				
				//Bibliographic Notes
				List<ResultPublicationBibliographicNote> respublBibliographicNotes = service.getTranslationService().getResultPublicationBibliographicNoteRepository().findByResultPublication(resultPublication);
				for (ResultPublicationBibliographicNote rpubbn: respublBibliographicNotes) {
					rpubbn.setBibliographicNote(cleanSpecialCharacters(rpubbn.getBibliographicNote()));
				}
				Set<ResultPublicationBibliographicNote> bibliographicNotes = new HashSet<ResultPublicationBibliographicNote>(respublBibliographicNotes);
				resultPublication.setResultPublicationBibliographicNotes(bibliographicNotes);
				
				//Name Abbreviations
				List<ResultPublicationNameAbbreviation> respublNameAbbreviations = service.getTranslationService().getResultPublicationNameAbbreviationRepository().findByResultPublication(resultPublication);
				for (ResultPublicationNameAbbreviation rpubna: respublNameAbbreviations) {
					rpubna.setNameAbbreviation(cleanSpecialCharacters(rpubna.getNameAbbreviation()));
				}
				Set<ResultPublicationNameAbbreviation> nameAbbreviations = new HashSet<ResultPublicationNameAbbreviation>(respublNameAbbreviations);
				resultPublication.setResultPublicationNameAbbreviations(nameAbbreviations);
				
				//abstracts
				List<ResultPublicationAbstract> respublAbstracts = service.getTranslationService().getResultPublicationAbstractRepository().findByResultPublication(resultPublication);
				for (ResultPublicationAbstract abstractInst:respublAbstracts) {
					abstractInst.setAbstractText(cleanSpecialCharacters(abstractInst.getAbstractText()));
				}
				Set<ResultPublicationAbstract> abstracts = new HashSet<ResultPublicationAbstract>(respublAbstracts);
				resultPublication.setResultPublicationAbstracts(abstracts);
				
				//version Infos
				List<ResultPublicationVersionInfo> respublVersionInfos = service.getTranslationService().getResultPublicationVersionInfoRepository().findByResultPublication(resultPublication);
				for (ResultPublicationVersionInfo respubvi: respublVersionInfos) {
					respubvi.setVersionInfo(cleanSpecialCharacters(respubvi.getVersionInfo()));
				}
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
				if (links) {
					//classes
					respublClas = service.getLinkService().getResultPublicationClassRepository().findByResultPublication(resultPublication);
					
					//persons
					persRespubl = service.getLinkService().getPersonResultPublicationRepository().findByResultPublication(resultPublication);
					
					//organisations
					orgRespubls = service.getLinkService().getOrganisationUnitResultPublicationRepository().findByResultPublication(resultPublication);
					
					//projects
					resPublProj = service.getLinkService().getProjectResultPublicationRepository().findByResultPublication(resultPublication);
					
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
				}
				//classes
				Set<ResultPublication_Class> classes = new HashSet<ResultPublication_Class>(respublClas);
				resultPublication.setResultPublications_classes(classes);
				
				//persons
				Set<Person_ResultPublication> pers = new HashSet<Person_ResultPublication>(persRespubl);
				resultPublication.setPersons_resultPublications(pers);
				
				//organisations
				Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
				resultPublication.setOrganisationUnit_resultPublications(resultPublications2);
				
				//projects
				Set<Project_ResultPublication> projs = new HashSet<Project_ResultPublication>(resPublProj);
				resultPublication.setProjects_resultPublications(projs);
				
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
				
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultPublication.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PUBLICATION.getUuid(), resultPublication.getId()));
				}
				
				CerifResultPublicationRecord resultPublicationRecord = new CerifResultPublicationRecord(resultPublication);
				rs.addRecord(resultPublicationRecord);	
				/*c++;
				System.out.println("resultPublication: "+resultPublication.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * ResultProduct 
		 */
		if (iterResultProduct != null) {
			c=0;
			while (iterResultProduct.hasNext()) {
				ResultProduct resultProduct = iterResultProduct.next(); 
				
				//names
				List<ResultProductName> resprodNames = service.getTranslationService().getResultProductNameRepository().findByResultProduct(resultProduct);
				for (ResultProductName name:resprodNames) {
					name.setName(cleanSpecialCharacters(name.getName()));
				}
				Set<ResultProductName> names = new HashSet<ResultProductName>(resprodNames);
				resultProduct.setResultProductNames(names);
				
				//descriptions
				List<ResultProductDescription> resprodDescr = service.getTranslationService().getResultProductDescriptionRepository().findByResultProduct(resultProduct);
				for (ResultProductDescription descr:resprodDescr) {
					descr.setDescription(cleanSpecialCharacters(descr.getDescription()));
				}
				Set<ResultProductDescription> descrs = new HashSet<ResultProductDescription>(resprodDescr);
				resultProduct.setResultProductDescriptions(descrs);
				
				//keywords
				List<ResultProductKeyword> resprodKeywords = service.getTranslationService().getResultProductKeywordRepository().findByResultProduct(resultProduct);
				for (ResultProductKeyword resprodk: resprodKeywords) {
					resprodk.setKeyword(cleanSpecialCharacters(resprodk.getKeyword()));
				}
				Set<ResultProductKeyword> keywords = new HashSet<ResultProductKeyword>(resprodKeywords);
				resultProduct.setResultProductKeywords(keywords);
				
				//Version Info
				List<ResultProductVersionInfo> resprodVersionInfo = service.getTranslationService().getResultProductVersionInfoRepository().findByResultProduct(resultProduct);
				for (ResultProductVersionInfo resprodvi: resprodVersionInfo) {
					resprodvi.setVersionInfo(cleanSpecialCharacters(resprodvi.getVersionInfo()));
				}
				Set<ResultProductVersionInfo> versionInfos = new HashSet<ResultProductVersionInfo>(resprodVersionInfo);
				resultProduct.setResultProductVersionInfos(versionInfos);
				
				List<OrganisationUnit_ResultProduct> orgResprod = new ArrayList<OrganisationUnit_ResultProduct>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Project_ResultProduct> projResultProd = new ArrayList<Project_ResultProduct>();
				List<ResultProduct_Class> resprodClas = new ArrayList<ResultProduct_Class>();
				List<ResultProduct_Funding> resprodFunds = new ArrayList<ResultProduct_Funding>();
				List<ResultPublication_ResultProduct> respublResultProd = new ArrayList<ResultPublication_ResultProduct>();
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
				List<ResultProduct_Service> serviceResultProd = new ArrayList<ResultProduct_Service>();
				List<ResultProduct_Equipment> equipmentResultProd = new ArrayList<ResultProduct_Equipment>();
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
					
					//facilities
					resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByResultProduct(resultProduct);
					
					//services
					serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByResultProduct(resultProduct);
					
					//equipments
					equipmentResultProd = service.getLinkService().getResultProductEquipmentRepository().findByResultProduct(resultProduct);
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
				resultProduct.setClasses(classes);
				
				//funding
				Set<ResultProduct_Funding> funds = new HashSet<ResultProduct_Funding>(resprodFunds);
				resultProduct.setResultProducts_fundings(funds);
				
				//result publications
				Set<ResultPublication_ResultProduct> resultPubls = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
				resultProduct.setResultPublications(resultPubls);
				
				//facilities
				Set<ResultProduct_Facility> facils = new HashSet<ResultProduct_Facility>(resprodFacilities);
				resultProduct.setResultProducts_facilities(facils);
				
				//services
				Set<ResultProduct_Service> srvs = new HashSet<ResultProduct_Service>(serviceResultProd);
				resultProduct.setResultProducts_services(srvs);
				
				//equipments
				Set<ResultProduct_Equipment> equipments = new HashSet<ResultProduct_Equipment>(equipmentResultProd);
				resultProduct.setResultProducts_equipments(equipments);
				
				//FederatedIdentifiers
				if (showFedIds) {
					resultProduct.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.PRODUCT.getUuid(), resultProduct.getId()));
				}
				
				CerifResultProductRecord resultProductRecord = new CerifResultProductRecord(resultProduct);
				rs.addRecord(resultProductRecord);
				/*c++;
				System.out.println("resultProduct: "+resultProduct.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Facility 
		 */
		if (iterFacility != null) {
			c=0;
			while (iterFacility.hasNext()) {
				Facility facility = iterFacility.next(); 
				
				//names
				List<FacilityName> facilityNames = service.getTranslationService().getFacilityNameRepository().findByFacility(facility);
				for (FacilityName name:facilityNames) {
					name.setName(cleanSpecialCharacters(name.getName()));
				}
				Set<FacilityName> names = new HashSet<FacilityName>(facilityNames);
				facility.setFacilityNames(names);
				
				//descriptions
				List<FacilityDescription> facilityDescr = service.getTranslationService().getFacilityDescriptionRepository().findByFacility(facility);
				for (FacilityDescription fd: facilityDescr) {
					fd.setDescription(cleanSpecialCharacters(fd.getDescription()));
				}
				Set<FacilityDescription> descriptions = new HashSet<FacilityDescription>(facilityDescr);
				facility.setFacilityDescriptions(descriptions);
				
				//keywords
				List<FacilityKeyword> facilityKeywords = service.getTranslationService().getFacilityKeywordRepository().findByFacility(facility);
				for (FacilityKeyword fk: facilityKeywords) {
					fk.setKeyword(cleanSpecialCharacters(fk.getKeyword()));
				}
				Set<FacilityKeyword> keywords = new HashSet<FacilityKeyword>(facilityKeywords);
				facility.setFacilityKeywords(keywords);
				
				List<Facility_Class> facilityClass = new ArrayList<Facility_Class>();
				List<OrganisationUnit_Facility> orgFacilities = new ArrayList<OrganisationUnit_Facility>();
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Person_Facility> facilityPers = new ArrayList<Person_Facility>();
				List<Project_Facility> projFacilities = new ArrayList<Project_Facility>();
				List<ResultPublication_Facility> respublFacilities = new ArrayList<ResultPublication_Facility>();
				List<Facility_PostalAddress> facilityPaddrs = new ArrayList<Facility_PostalAddress>();
				List<Facility_Equipment> equipmentFacilities = new ArrayList<Facility_Equipment>();
				List<Facility_Service> serviceFacilities = new ArrayList<Facility_Service>();
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
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
					
					//equipments
					equipmentFacilities = service.getLinkService().getFacilityEquipmentRepository().findByFacility(facility);
					
					//services
					serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByFacility(facility);
					
					//Result products
					resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByFacility(facility);
				}
				//classes
				Set<Facility_Class> classes = new HashSet<Facility_Class>(facilityClass);
				facility.setClasses(classes);
				
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
				facility.setPostalAddresses(paddrs);
				
				//equipments
				Set<Facility_Equipment> equipments = new HashSet<Facility_Equipment>(equipmentFacilities);
				facility.setFacilities_equipments(equipments);
				
				//services
				Set<Facility_Service> srvs = new HashSet<Facility_Service>(serviceFacilities);
				facility.setFacilities_services(srvs);
				
				//Result products
				Set<ResultProduct_Facility> resultProds = new HashSet<ResultProduct_Facility>(resprodFacilities);
				facility.setResultProducts_facilities(resultProds);
				
				//FederatedIdentifiers
				if (showFedIds) {
					facility.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.FACILITY.getUuid(), facility.getId()));
				}
				
				
				CerifFacilityRecord facilityRecord = new CerifFacilityRecord(facility);
				rs.addRecord(facilityRecord);	
				/*c++;
				System.out.println("facility: "+facility.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Service 
		 */
		if (iterService != null) {
			c=0;
			while (iterService.hasNext()) {
				Service serviceInst = iterService.next(); 
				
				//names
				List<ServiceName> serviceNames = service.getTranslationService().getServiceNameRepository().findByService(serviceInst);
				for (ServiceName name:serviceNames) {
					name.setName(cleanSpecialCharacters(name.getName()));
				}
				Set<ServiceName> names = new HashSet<ServiceName>(serviceNames);
				serviceInst.setServiceNames(names);
				
				//descriptions
				List<ServiceDescription> serviceDescr = service.getTranslationService().getServiceDescriptionRepository().findByService(serviceInst);
				for (ServiceDescription sd: serviceDescr) {
					sd.setDescription(cleanSpecialCharacters(sd.getDescription()));
				}
				Set<ServiceDescription> descriptions = new HashSet<ServiceDescription>(serviceDescr);
				serviceInst.setServiceDescriptions(descriptions);
				
				//keywords
				List<ServiceKeyword> serviceKeywords = service.getTranslationService().getServiceKeywordRepository().findByService(serviceInst);
				for (ServiceKeyword sk: serviceKeywords) {
					sk.setKeyword(cleanSpecialCharacters(sk.getKeyword()));
				}
				Set<ServiceKeyword> keywords = new HashSet<ServiceKeyword>(serviceKeywords);
				serviceInst.setServiceKeywords(keywords);
				
				List<OrganisationUnit_Service> serviceOrgs = new ArrayList<OrganisationUnit_Service>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				List<Service_Funding> serviceFunds = new ArrayList<Service_Funding>();
				List<Service_PostalAddress> servicePaddrs = new ArrayList<Service_PostalAddress>();
				List<Facility_Service> serviceFacilities = new ArrayList<Facility_Service>();
				List<Equipment_Service> equipmentServices = new ArrayList<Equipment_Service>();
				List<ResultPublication_Service> serviceRespubls = new ArrayList<ResultPublication_Service>();
				List<ResultProduct_Service> serviceResultProd = new ArrayList<ResultProduct_Service>();
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
					
					//facilities
					serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByService(serviceInst);
					
					//equipments
					equipmentServices = service.getLinkService().getEquipmentServiceRepository().findByService(serviceInst);
					
					//Result Publications
					serviceRespubls = service.getLinkService().getResultPublicationServiceRepository().findByService(serviceInst);
					
					//result products
					serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByService(serviceInst);
					
					//classes
					serviceClass = service.getLinkService().getServiceClassRepository().findByService(serviceInst);
					
					//projects
					serviceProj = service.getLinkService().getProjectServiceRepository().findByService(serviceInst);
				}
				//OrganisationUnits
				Set<OrganisationUnit_Service> orgs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
				serviceInst.setOrganisationUnit_services(orgs);
				
				//persons
				Set<Person_Service> pers = new HashSet<Person_Service>(servicePers);
				serviceInst.setPersons_services(pers);
				
				//fundings
				Set<Service_Funding> funds = new HashSet<Service_Funding>(serviceFunds);
				serviceInst.setServices_fundings(funds);
				
				//addresses
				Set<Service_PostalAddress> paddrs = new HashSet<Service_PostalAddress>(servicePaddrs);
				serviceInst.setServices_postalAdresses(paddrs);
				
				//facilities
				Set<Facility_Service> facils = new HashSet<Facility_Service>(serviceFacilities);
				serviceInst.setFacilities_services(facils);
				
				//equipments
				Set<Equipment_Service> equipments = new HashSet<Equipment_Service>(equipmentServices);
				serviceInst.setEquipment_services(equipments);
				
				//Result Publications
				Set<ResultPublication_Service> resultPubls = new HashSet<ResultPublication_Service>(serviceRespubls);
				serviceInst.setResultPublications_services(resultPubls);
				
				//result products
				Set<ResultProduct_Service> resultProds = new HashSet<ResultProduct_Service>(serviceResultProd);
				serviceInst.setResultProducts_services(resultProds);
				
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
				
				CerifServiceRecord serviceRecord = new CerifServiceRecord(serviceInst);
				rs.addRecord(serviceRecord);
				/*c++;
				System.out.println("service: "+serviceInst.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * Equipment 
		 */
		if (iterEquipment != null) {
			c=0;
			while (iterEquipment.hasNext()) {
				Equipment equipment = iterEquipment.next(); 
				
				//names
				List<EquipmentName> equipmentNames = service.getTranslationService().getEquipmentNameRepository().findByEquipment(equipment);
				for (EquipmentName name:equipmentNames) {
					name.setName(cleanSpecialCharacters(name.getName()));
				}
				Set<EquipmentName> names = new HashSet<EquipmentName>(equipmentNames);
				equipment.setEquipmentNames(names);
				
				//descriptions
				List<EquipmentDescription> equipmentDescr = service.getTranslationService().getEquipmentDescriptionRepository().findByEquipment(equipment);
				for (EquipmentDescription ed: equipmentDescr) {
					ed.setDescription(cleanSpecialCharacters(ed.getDescription()));
				}
				Set<EquipmentDescription> descriptions = new HashSet<EquipmentDescription>(equipmentDescr);
				equipment.setEquipmentDescriptions(descriptions);
				
				//keywords
				List<EquipmentKeyword> equipmentKeywords = service.getTranslationService().getEquipmentKeywordRepository().findByEquipment(equipment);
				for (EquipmentKeyword ek: equipmentKeywords) {
					ek.setKeyword(cleanSpecialCharacters(ek.getKeyword()));
				}
				Set<EquipmentKeyword> keywords = new HashSet<EquipmentKeyword>(equipmentKeywords);
				equipment.setEquipmentKeywords(keywords);
				
				List<Equipment_Funding> equipmentFunds = new ArrayList<Equipment_Funding>();
				List<Equipment_Class> equipmentClass = new ArrayList<Equipment_Class>();
				List<OrganisationUnit_Equipment> equipmentOrgs = new ArrayList<OrganisationUnit_Equipment>();
				List<Person_Equipment> equipmentPers = new ArrayList<Person_Equipment>();
				List<Project_Equipment> equipmentProj = new ArrayList<Project_Equipment>();
				List<ResultPublication_Equipment> equipmentRespubls = new ArrayList<ResultPublication_Equipment>();
				List<Equipment_PostalAddress> equipmentPaddrs = new ArrayList<Equipment_PostalAddress>();
				List<Facility_Equipment> equipmentFacilities = new ArrayList<Facility_Equipment>();
				List<Equipment_Service> equipmentServices = new ArrayList<Equipment_Service>();
				List<ResultProduct_Equipment> equipmentResultProd = new ArrayList<ResultProduct_Equipment>();
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
					
					//facilities
					equipmentFacilities = service.getLinkService().getFacilityEquipmentRepository().findByEquipment(equipment);
					
					//services
					equipmentServices = service.getLinkService().getEquipmentServiceRepository().findByEquipment(equipment);
					
					//result products
					equipmentResultProd = service.getLinkService().getResultProductEquipmentRepository().findByEquipment(equipment);
				}
				//fundings
				Set<Equipment_Funding> funds = new HashSet<Equipment_Funding>(equipmentFunds);
				equipment.setEquipments_fundings(funds);
				
				//classes
				Set<Equipment_Class> classes = new HashSet<Equipment_Class>(equipmentClass);
				equipment.setClasses(classes);
				
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
				
				//facilities
				Set<Facility_Equipment> facils = new HashSet<Facility_Equipment>(equipmentFacilities);
				equipment.setFacilities_equipments(facils);
				
				//services
				Set<Equipment_Service> srvs = new HashSet<Equipment_Service>(equipmentServices);
				equipment.setEquipments_services(srvs);
				
				//result products
				Set<ResultProduct_Equipment> resultProds = new HashSet<ResultProduct_Equipment>(equipmentResultProd);
				equipment.setResultProducts_equipments(resultProds);
				
				//FederatedIdentifiers
				if (showFedIds) {
					equipment.setFederatedIdentifiers(addFederatedIdentifier(ClassEnum.EQUIPMENT.getUuid(), equipment.getId()));
				}
				
				CerifEquipmentRecord equipmentRecord = new CerifEquipmentRecord(equipment);
				rs.addRecord(equipmentRecord);
				/*c++;
				System.out.println("equipment: "+equipment.getId()+", ("+c+")");*/
			}
		}
		
		
		/*
		 * FederatedIdentifier 
		 */
		if (iterFederatedIdentifier != null) {
			c=0;
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
				federatedIdentifier.setServices_fedids(services);
				
				CerifFederatedIdentifierRecord federatedIdentifierRecord = new CerifFederatedIdentifierRecord(federatedIdentifier);
				rs.addRecord(federatedIdentifierRecord);
				/*c++;
				System.out.println("federatedIdentifier: "+federatedIdentifier.getId()+", ("+c+")");*/
			}
		}
		
		
		// ------ Return ------- //
		return rs;
	}
	
	
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
			fedId.setServices_fedids(fedServices);
		}

		return fedIds;
	}
	
	
	private String cleanSpecialCharacters(String stringToClean) {
		if (stringToClean!=null) {
			return stringToClean.replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", "");
		} else return null;
	}
	
}
