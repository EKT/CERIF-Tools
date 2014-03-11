/**
 * 
 */
package gr.ekt.cerif.xml.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_Service;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Funding;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Service;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Class;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.features.multilingual.FundingName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.ProjectAbstract;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.ServiceName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.cerif.xml.loadingSpecs.LoadingSpecs;
import gr.ekt.cerif.xml.records.CerifClassRecord;
import gr.ekt.cerif.xml.records.CerifFacilityRecord;
import gr.ekt.cerif.xml.records.CerifFundingRecord;
import gr.ekt.cerif.xml.records.CerifOrganisationUnitRecord;
import gr.ekt.cerif.xml.records.CerifPersonRecord;
import gr.ekt.cerif.xml.records.CerifPostalAddressRecord;
import gr.ekt.cerif.xml.records.CerifProjectRecord;
import gr.ekt.cerif.xml.records.CerifResultProductRecord;
import gr.ekt.cerif.xml.records.CerifResultPublicationRecord;
import gr.ekt.cerif.xml.records.CerifServiceRecord;
import gr.ekt.transformationengine.core.DataLoader;
import gr.ekt.transformationengine.core.RecordSet;

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
	Iterable<PostalAddress> postalAddresses;
	Iterator<PostalAddress> iterPostalAddress;
	List<Funding> fundings;
	Iterator<Funding> iterFunding;
	List<Class> theClasses;
	Iterator<Class> iterClass;
	List<ResultPublication> resultPublications;
	Iterator<ResultPublication> iterResultPublication;
	List<Facility> facilities;
	Iterator<Facility> iterFacility;
	List<ResultProduct> resultProducts;
	Iterator<ResultProduct> iterResultProduct;
	List<Service> services;
	Iterator<Service> iterService;

	public CerifToXmlDataLoader() {
		super();
	}
	
	@Override
	public RecordSet loadData() {
		RecordSet rs = new RecordSet();
		Integer windowSize = ((LoadingSpecs)this.getLoadingSpec()).getWindowSize();
		Integer windowOffset = ((LoadingSpecs)this.getLoadingSpec()).getWindowOffset();
		boolean links = ((LoadingSpecs)this.getLoadingSpec()).isLinks();

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
			if (projects instanceof Collection)
				size = ((Collection<Project>)projects).size();
			System.out.println("projects: "+size);
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
			if (organisations instanceof Collection)
				size = ((Collection<OrganisationUnit>)organisations).size();
			System.out.println("organisations: "+size);
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
			if (persons instanceof Collection)
				size = ((Collection<Person>)persons).size();
			System.out.println("persons: "+size);
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
			if (postalAddresses instanceof Collection)
				size = ((Collection<PostalAddress>)postalAddresses).size();
			System.out.println("postalAddresses: "+size);
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
			if (fundings instanceof Collection)
				size = ((Collection<Funding>)fundings).size();
			System.out.println("fundings: "+size);
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
			if (theClasses instanceof Collection)
				size = ((Collection<Class>)theClasses).size();
			System.out.println("classes: "+size);
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
			if (resultPublications instanceof Collection)
				size = ((Collection<ResultPublication>)resultPublications).size();
			System.out.println("resultPublications: "+size);
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
			if (facilities instanceof Collection)
				size = ((Collection<Facility>)facilities).size();
			System.out.println("facilities: "+size);
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
			if (resultProducts instanceof Collection)
				size = ((Collection<ResultProduct>)resultProducts).size();
			System.out.println("resultProducts: "+size);
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
			if (services instanceof Collection)
				size = ((Collection<Service>)services).size();
			System.out.println("services: "+size);
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
					t.setTitle(t.getTitle().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ProjectTitle> titles = new HashSet<ProjectTitle>(projTitles);
				project.setProjectTitles(titles);
				
				//abstract
				List<ProjectAbstract> projAbs = service.getTranslationService().getProjectAbstractRepository().findByProject(project);
				for (ProjectAbstract a:projAbs) {
					a.setAbstractText(a.getAbstractText().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ProjectAbstract> abs = new HashSet<ProjectAbstract>(projAbs);
				project.setProjectAbstracts(abs);
				
				//keywords
				List<ProjectKeyword> projKeys = service.getTranslationService().getProjectKeywordRepository().findByProject(project);
				for (ProjectKeyword k:projKeys) {
					k.setKeyword(k.getKeyword().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
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
				
				CerifProjectRecord projectRecord = new CerifProjectRecord(project);
				rs.addRecord(projectRecord);
				c++;
				System.out.println("project: "+project.getId()+", ("+c+")");
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
					on.setName(on.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<OrganisationUnitName> names = new HashSet<OrganisationUnitName>(orgNames);
				organisation.setOrganisationUnitNames(names);
				
				List<OrganisationUnit_Class> orgclas = new ArrayList<OrganisationUnit_Class>();
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
					orgclas = service.getLinkService().getOrganisationUnitClassRepository().findByOrganisationUnit(organisation);
					
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
				Set<OrganisationUnit_Class> classes = new HashSet<OrganisationUnit_Class>(orgclas);
				organisation.setClasses(classes);
				
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
						
				
				CerifOrganisationUnitRecord organisationUnitRecord = new CerifOrganisationUnitRecord(organisation);
				rs.addRecord(organisationUnitRecord);
				c++;
				System.out.println("organisation: "+organisation.getId()+", ("+c+")");
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
				
				List<Person_Class> persClas = new ArrayList<Person_Class>();
				List<Person_Facility> persFacilities = new ArrayList<Person_Facility>();
				List<Person_Funding> persFunds = new ArrayList<Person_Funding>();
				List<Person_OrganisationUnit> persOrg = new ArrayList<Person_OrganisationUnit>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Project_Person> persProj = new ArrayList<Project_Person>();
				List<Person_PostalAddress> persPaddrs = new ArrayList<Person_PostalAddress>();
				List<Person_ResultPublication> persRespubls = new ArrayList<Person_ResultPublication>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				if (links) {
					//classes
					persClas = service.getLinkService().getPersonClassRepository().findByPerson(person);
					
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
				//classes
				Set<Person_Class> classes = new HashSet<Person_Class>(persClas);
				person.setClasses(classes);
				
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
				
				
				CerifPersonRecord personRecord = new CerifPersonRecord(person);
				rs.addRecord(personRecord);		
				c++;
				System.out.println("person: "+person.getId()+", ("+c+")");
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
				List<Facility_PostalAddress> facilityPaddrs = new ArrayList<Facility_PostalAddress>();
				List<Service_PostalAddress> servicePaddrs = new ArrayList<Service_PostalAddress>();
				if (links) {
					//organisations
					orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//persons
					persPaddrs = service.getLinkService().getPersonPostalAddressRepository().findByPostalAddress(postalAddress);
					
					//classes
					paddrClass = service.getLinkService().getPostalAddressClassRepository().findByPostalAddress(postalAddress);
					
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
				
				//facilities
				Set<Facility_PostalAddress> facils = new HashSet<Facility_PostalAddress>(facilityPaddrs);
				postalAddress.setFacilities_postalAddresses(facils);
				
				//services
				Set<Service_PostalAddress> srvs = new HashSet<Service_PostalAddress>(servicePaddrs);
				postalAddress.setServices_postalAddresses(srvs);
				
				
				CerifPostalAddressRecord postalAddressRecord = new CerifPostalAddressRecord(postalAddress);
				rs.addRecord(postalAddressRecord);	
				c++;
				System.out.println("postalAddress: "+postalAddress.getId()+", ("+c+")");
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
					name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<FundingName> names = new HashSet<FundingName>(fundNames);
				funding.setNames(names);
		
				//descriptions
				List<FundingDescription> fundDescr = service.getTranslationService().getFundingDescriptionRepository().findByFunding(funding);
				for (FundingDescription descr:fundDescr) {
					descr.setDescription(descr.getDescription().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<FundingDescription> descrs = new HashSet<FundingDescription>(fundDescr);
				funding.setDescriptions(descrs);
				
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Funding_Class> fundingClas = new ArrayList<Funding_Class>();
				List<OrganisationUnit_Funding> orgFunds = new ArrayList<OrganisationUnit_Funding>();
				List<Person_Funding> persFunds = new ArrayList<Person_Funding>();
				List<Project_Funding> projFunds = new ArrayList<Project_Funding>();
				List<ResultProduct_Funding> resprodFunds = new ArrayList<ResultProduct_Funding>();
				List<ResultPublication_Funding> respublFunds = new ArrayList<ResultPublication_Funding>();
				List<Service_Funding> serviceFunds = new ArrayList<Service_Funding>();
				if (links) {
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

				
				CerifFundingRecord fundingRecord = new CerifFundingRecord(funding);
				rs.addRecord(fundingRecord);	
				c++;
				System.out.println("funding: "+funding.getId()+", ("+c+")");
			}
		}
		
		
		/*
		 * Class 
		 */
		if (iterClass != null) {
			c=0;
			while (iterClass.hasNext()) {
				Class theClass = iterClass.next(); 
				
				//terms
				List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(theClass);
				Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
				theClass.setTerms(terms);
				
				
				CerifClassRecord classRecord = new CerifClassRecord(theClass);
				rs.addRecord(classRecord);	
				c++;
				System.out.println("class: "+theClass.getId()+", ("+c+")");
			}
		}
		
		
		/*
		 * ResultPublication 
		 */
		if (iterResultPublication != null) {
			c=0;
			while (iterResultPublication.hasNext()) {
				ResultPublication resultPublication = iterResultPublication.next(); 
				
				List<ResultPublication_Class> respublClas = new ArrayList<ResultPublication_Class>();
				List<Person_ResultPublication> persRespubl = new ArrayList<Person_ResultPublication>();
				List<OrganisationUnit_ResultPublication> orgRespubls = new ArrayList<OrganisationUnit_ResultPublication>();
				List<Project_ResultPublication> resPublProj = new ArrayList<Project_ResultPublication>();
				List<ResultPublication_Funding> respublFunds = new ArrayList<ResultPublication_Funding>();
				List<ResultPublication_Facility> respublFacils = new ArrayList<ResultPublication_Facility>();
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
				
				//result products
				Set<ResultPublication_ResultProduct> resultProds = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
				resultPublication.setResultPublications_resultProducts(resultProds);
				
				//Services
				Set<ResultPublication_Service> srvs = new HashSet<ResultPublication_Service>(serviceRespubls);
				resultPublication.setResultPublications_services(srvs);
				
				//titles
				List<ResultPublicationTitle> respublTitles = service.getTranslationService().getResultPublicationTitleRepository().findByResultPublication(resultPublication);
				for (ResultPublicationTitle title:respublTitles) {
					title.setTitle(title.getTitle().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultPublicationTitle> titles = new HashSet<ResultPublicationTitle>(respublTitles);
				resultPublication.setResultPublicationTitles(titles);
				
				//subtitles
				List<ResultPublicationSubtitle> respublSubtitles = service.getTranslationService().getResultPublicationSubtitleRepository().findByResultPublication(resultPublication);
				for (ResultPublicationSubtitle subtitle:respublSubtitles) {
					subtitle.setSubtitle(subtitle.getSubtitle().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultPublicationSubtitle> subtitles = new HashSet<ResultPublicationSubtitle>(respublSubtitles);
				resultPublication.setResultPublicationSubtitles(subtitles);
				
				//keywords
				List<ResultPublicationKeyword> respublKeywords = service.getTranslationService().getResultPublicationKeywordRepository().findByResultPublication(resultPublication);
				for (ResultPublicationKeyword keyword:respublKeywords) {
					keyword.setKeyword(keyword.getKeyword().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultPublicationKeyword> keywords = new HashSet<ResultPublicationKeyword>(respublKeywords);
				resultPublication.setResultPublicationKeywords(keywords);
				
				//abstracts
				List<ResultPublicationAbstract> respublAbstracts = service.getTranslationService().getResultPublicationAbstractRepository().findByResultPublication(resultPublication);
				for (ResultPublicationAbstract abstractInst:respublAbstracts) {
					abstractInst.setAbstractText(abstractInst.getAbstractText().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultPublicationAbstract> abstracts = new HashSet<ResultPublicationAbstract>(respublAbstracts);
				resultPublication.setResultPublicationAbstracts(abstracts);
				
				
				CerifResultPublicationRecord resultPublicationRecord = new CerifResultPublicationRecord(resultPublication);
				rs.addRecord(resultPublicationRecord);	
				c++;
				System.out.println("resultPublication: "+resultPublication.getId()+", ("+c+")");
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
					name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultProductName> names = new HashSet<ResultProductName>(resprodNames);
				resultProduct.setResultProductNames(names);
				
				//descriptions
				List<ResultProductDescription> resprodDescr = service.getTranslationService().getResultProductDescriptionRepository().findByResultProduct(resultProduct);
				for (ResultProductDescription descr:resprodDescr) {
					descr.setDescription(descr.getDescription().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ResultProductDescription> descrs = new HashSet<ResultProductDescription>(resprodDescr);
				resultProduct.setResultProductDescriptions(descrs);
				
				List<OrganisationUnit_ResultProduct> orgResprod = new ArrayList<OrganisationUnit_ResultProduct>();
				List<Person_ResultProduct> persResprod = new ArrayList<Person_ResultProduct>();
				List<Project_ResultProduct> projResultProd = new ArrayList<Project_ResultProduct>();
				List<ResultProduct_Class> resprodClas = new ArrayList<ResultProduct_Class>();
				List<ResultProduct_Funding> resprodFunds = new ArrayList<ResultProduct_Funding>();
				List<ResultPublication_ResultProduct> respublResultProd = new ArrayList<ResultPublication_ResultProduct>();
				List<ResultProduct_Facility> resprodFacilities = new ArrayList<ResultProduct_Facility>();
				List<ResultProduct_Service> serviceResultProd = new ArrayList<ResultProduct_Service>();
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
				
				
				CerifResultProductRecord resultProductRecord = new CerifResultProductRecord(resultProduct);
				rs.addRecord(resultProductRecord);
				c++;
				System.out.println("resultProduct: "+resultProduct.getId()+", ("+c+")");
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
					name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<FacilityName> names = new HashSet<FacilityName>(facilityNames);
				facility.setNames(names);
				
				List<Facility_Class> facilityClass = new ArrayList<Facility_Class>();
				List<OrganisationUnit_Facility> orgFacilities = new ArrayList<OrganisationUnit_Facility>();
				List<Facility_Funding> facilityFunds = new ArrayList<Facility_Funding>();
				List<Person_Facility> facilityPers = new ArrayList<Person_Facility>();
				List<Project_Facility> projFacilities = new ArrayList<Project_Facility>();
				List<ResultPublication_Facility> respublFacilities = new ArrayList<ResultPublication_Facility>();
				List<Facility_PostalAddress> facilityPaddrs = new ArrayList<Facility_PostalAddress>();
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
				
				//services
				Set<Facility_Service> srvs = new HashSet<Facility_Service>(serviceFacilities);
				facility.setFacilities_services(srvs);
				
				//Result products
				Set<ResultProduct_Facility> resultProds = new HashSet<ResultProduct_Facility>(resprodFacilities);
				facility.setResultProducts_facilities(resultProds);
				
				
				CerifFacilityRecord facilityRecord = new CerifFacilityRecord(facility);
				rs.addRecord(facilityRecord);	
				c++;
				System.out.println("facility: "+facility.getId()+", ("+c+")");
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
					name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
				}
				Set<ServiceName> names = new HashSet<ServiceName>(serviceNames);
				serviceInst.setNames(names);
				
				List<OrganisationUnit_Service> serviceOrgs = new ArrayList<OrganisationUnit_Service>();
				List<Person_Service> servicePers = new ArrayList<Person_Service>();
				List<Service_Funding> serviceFunds = new ArrayList<Service_Funding>();
				List<Service_PostalAddress> servicePaddrs = new ArrayList<Service_PostalAddress>();
				List<Facility_Service> serviceFacilities = new ArrayList<Facility_Service>();
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
				
				
				CerifServiceRecord serviceRecord = new CerifServiceRecord(serviceInst);
				rs.addRecord(serviceRecord);
				c++;
				System.out.println("service: "+serviceInst.getId()+", ("+c+")");
			}
		}
		
		
		return rs;
	}
}
