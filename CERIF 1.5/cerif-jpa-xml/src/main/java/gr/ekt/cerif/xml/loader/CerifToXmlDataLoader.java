/**
 * 
 */
package gr.ekt.cerif.xml.loader;

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
import org.springframework.stereotype.Component;

/**
 * @author bonisv
 *
 */
@Component
public class CerifToXmlDataLoader extends DataLoader {
	
	@Autowired
	private PersistenceService service;

	public CerifToXmlDataLoader() {
		super();
	}
	
	@Override
	public RecordSet loadData() {
		RecordSet rs = new RecordSet();

		Iterable<Project> projects = service.getBaseService().getProjectRepository().findAll();
		Iterator<Project> iterProject = projects.iterator();
		
		Iterable<OrganisationUnit> organisations = service.getBaseService().getOrganisationUnitRepository().findAll();
		Iterator<OrganisationUnit> iterOrganisationUnit = organisations.iterator();
		
		Iterable<Person> persons = service.getBaseService().getPersonRepository().findAll();
		Iterator<Person> iterPerson = persons.iterator();
		
		Iterable<PostalAddress> postalAddresses = service.getSecondService().getPostalAddressRepository().findAll();
		Iterator<PostalAddress> iterPostalAddress = postalAddresses.iterator();
		
		List<Funding> fundings = service.getSecondService().getFundingRepository().findAll();
		Iterator<Funding> iterFunding = fundings.iterator();
		
		List<Class> theClasses = service.getSemanticService().getClassRepository().findAll();
		Iterator<Class> iterClass = theClasses.iterator();
		
		List<ResultPublication> resultPublications = service.getResultService().getResultPublicationRepository().findAll();
		Iterator<ResultPublication> iterResultPublication = resultPublications.iterator();
		
		List<Facility> facilities = service.getInfrastructureService().getFacilityRepository().findAll();
		Iterator<Facility> iterFacility = facilities.iterator();
		
		List<ResultProduct> resultProducts = service.getResultService().getResultProductRepository().findAll();
		Iterator<ResultProduct> iterResultProduct = resultProducts.iterator();
		
		List<Service> services = service.getInfrastructureService().getServiceRepository().findAll();
		Iterator<Service> iterService = services.iterator();

		/*
		 * Project 
		 */
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
			
			//facilities
			List<Project_Facility> projFacilities = service.getLinkService().getProjectFacilityRepository().findByProject(project);
			Set<Project_Facility> facils = new HashSet<Project_Facility>(projFacilities);
			project.setProjects_facilities(facils);
			
			//fundings
			List<Project_Funding> projFunds = service.getLinkService().getProjectFundingRepository().findByProject(project);
			Set<Project_Funding> funds = new HashSet<Project_Funding>(projFunds);
			project.setProjects_fundings(funds);
			
			//organisations
			List<Project_OrganisationUnit> projorgs = service.getLinkService().getProjectOrganisationUnitRepository().findByProject(project);
			Set<Project_OrganisationUnit> orgs = new HashSet<Project_OrganisationUnit>(projorgs);
			project.setOrganisationUnits(orgs);
			
			//persons
			List<Project_Person> projpers = service.getLinkService().getProjectPersonRepository().findByProject(project);
			Set<Project_Person> pers = new HashSet<Project_Person>(projpers);
			project.setPersons(pers);
			
			//result products
			List<Project_ResultProduct> projResultProd = service.getLinkService().getProjectResultProductRepository().findByProject(project);
			Set<Project_ResultProduct> resultProds = new HashSet<Project_ResultProduct>(projResultProd);
			project.setProjects_resultProducts(resultProds);
			
			//Result Publications
			List<Project_ResultPublication> projRespubls = service.getLinkService().getProjectResultPublicationRepository().findByProject(project);
			Set<Project_ResultPublication> resultPubls = new HashSet<Project_ResultPublication>(projRespubls);
			project.setProjects_resultPublications(resultPubls);
			
			//services
			List<Project_Service> serviceProj = service.getLinkService().getProjectServiceRepository().findByProject(project);
			Set<Project_Service> srvs = new HashSet<Project_Service>(serviceProj);
			project.setProjects_services(srvs);
			
			//classes
			List<Project_Class> projclas = service.getLinkService().getProjectClassRepository().findByProject(project);
			Set<Project_Class> classes = new HashSet<Project_Class>(projclas);
			project.setProjects_classes(classes);
			
			
			CerifProjectRecord projectRecord = new CerifProjectRecord(project);
			rs.addRecord(projectRecord);
		}
		
		/*
		 * OrganisationUnits
		 */
		while (iterOrganisationUnit.hasNext()) {
			OrganisationUnit organisation = iterOrganisationUnit.next(); 
			
			//names
			List<OrganisationUnitName> orgNames = service.getTranslationService().getOrganisationUnitNameRepository().findByOrganisationUnit(organisation);
			for (OrganisationUnitName on:orgNames) {
				on.setName(on.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
			}
			Set<OrganisationUnitName> names = new HashSet<OrganisationUnitName>(orgNames);
			organisation.setOrganisationUnitNames(names);
			
			//classes
			List<OrganisationUnit_Class> orgclas = service.getLinkService().getOrganisationUnitClassRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_Class> classes = new HashSet<OrganisationUnit_Class>(orgclas);
			organisation.setClasses(classes);
			
			//facilities
			List<OrganisationUnit_Facility> orgFacilities = service.getLinkService().getOrganisationUnitFacilityRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_Facility> facils = new HashSet<OrganisationUnit_Facility>(orgFacilities);
			organisation.setOrganisationUnits_facilities(facils);
			
			//funding
			List<OrganisationUnit_Funding> orgFunds = service.getLinkService().getOrganisationUnitFundingRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_Funding> funds = new HashSet<OrganisationUnit_Funding>(orgFunds);
			organisation.setOrganisationUnits_fundings(funds);
			
			//result products
			List<OrganisationUnit_ResultProduct> orgResprod = service.getLinkService().getOrganisationUnitResultProductRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_ResultProduct> resultProds = new HashSet<OrganisationUnit_ResultProduct>(orgResprod);
			organisation.setResultProducts(resultProds);
			
			//persons
			List<Person_OrganisationUnit> persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByOrganisationUnit(organisation);
			Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
			organisation.setPersons_organisationUnits(pers);
			
			//projects
			List<Project_OrganisationUnit> projorgs = service.getLinkService().getProjectOrganisationUnitRepository().findByOrganisationUnit(organisation);
			Set<Project_OrganisationUnit> projs = new HashSet<Project_OrganisationUnit>(projorgs);
			organisation.setProjects(projs);
			
			//addresses
			List<OrganisationUnit_PostalAddress> orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_PostalAddress> paddrs = new HashSet<OrganisationUnit_PostalAddress>(orgPaddrs);
			organisation.setPostalAddresses(paddrs);
			
			//Result Publications
			List<OrganisationUnit_ResultPublication> orgRespubls = service.getLinkService().getOrganisationUnitResultPublicationRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
			organisation.setResultPublications(resultPublications2);
			
			//services
			List<OrganisationUnit_Service> serviceOrgs = service.getLinkService().getOrganisationUnitServiceRepository().findByOrganisationUnit(organisation);
			Set<OrganisationUnit_Service> srvs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
			organisation.setOrganisationUnits_services(srvs);
			
					
			CerifOrganisationUnitRecord organisationUnitRecord = new CerifOrganisationUnitRecord(organisation);
			rs.addRecord(organisationUnitRecord);
		}
		
		
		/*
		 * Person 
		 */
		while (iterPerson.hasNext()) {
			Person person = iterPerson.next(); 
			
			//classes
			List<Person_Class> persClas = service.getLinkService().getPersonClassRepository().findByPerson(person);
			Set<Person_Class> classes = new HashSet<Person_Class>(persClas);
			person.setClasses(classes);
			
			//facilities
			List<Person_Facility> persFacilities = service.getLinkService().getPersonFacilityRepository().findByPerson(person);
			Set<Person_Facility> facils = new HashSet<Person_Facility>(persFacilities);
			person.setPersons_facilities(facils);
			
			//funding
			List<Person_Funding> persFunds = service.getLinkService().getPersonFundingRepository().findByPerson(person);
			Set<Person_Funding> funds = new HashSet<Person_Funding>(persFunds);
			person.setPersons_fundings(funds);
			
			//organisations
			List<Person_OrganisationUnit> persOrg = service.getLinkService().getPersonOrganisationUnitRepository().findByPerson(person);
			Set<Person_OrganisationUnit> pers = new HashSet<Person_OrganisationUnit>(persOrg);
			person.setPersons_organisationUnits(pers);
			
			//Result products
			List<Person_ResultProduct> persResprod = service.getLinkService().getPersonResultProductRepository().findByPerson(person);
			Set<Person_ResultProduct> resultProds = new HashSet<Person_ResultProduct>(persResprod);
			person.setPersons_resultProducts(resultProds);
			
			//projects
			List<Project_Person> persProj = service.getLinkService().getProjectPersonRepository().findByPerson(person);
			Set<Project_Person> projs = new HashSet<Project_Person>(persProj);
			person.setProjects(projs);
			
			//addresses
			List<Person_PostalAddress> persPaddrs = service.getLinkService().getPersonPostalAddressRepository().findByPerson(person);
			Set<Person_PostalAddress> paddrs = new HashSet<Person_PostalAddress>(persPaddrs);
			person.setPersons_postalAddresses(paddrs);
			
			//names
			List<PersonName> persNames = service.getAdditionalService().getPersonNameRepository().findByPerson(person);
			Set<PersonName> names = new HashSet<PersonName>(persNames);
			person.setPersonNames(names);
			
			//Result Publications
			List<Person_ResultPublication> persRespubls = service.getLinkService().getPersonResultPublicationRepository().findByPerson(person);
			Set<Person_ResultPublication> resultPublications2 = new HashSet<Person_ResultPublication>(persRespubls);
			person.setPersons_resultPublications(resultPublications2);
			
			//services
			List<Person_Service> servicePers = service.getLinkService().getPersonServiceRepository().findByPerson(person);
			Set<Person_Service> srvs = new HashSet<Person_Service>(servicePers);
			person.setPersons_services(srvs);
			
			
			CerifPersonRecord personRecord = new CerifPersonRecord(person);
			rs.addRecord(personRecord);			
		}
		
		
		/*
		 * PostalAddress 
		 */
		while (iterPostalAddress.hasNext()) {
			PostalAddress postalAddress = iterPostalAddress.next(); 
			
			//organisations
			List<OrganisationUnit_PostalAddress> orgPaddrs = service.getLinkService().getOrganisationUnitPostalAddressRepository().findByPostalAddress(postalAddress);
			Set<OrganisationUnit_PostalAddress> orgs = new HashSet<OrganisationUnit_PostalAddress>(orgPaddrs);
			postalAddress.setOrganisationUnits(orgs);
			
			//persons
			List<Person_PostalAddress> persPaddrs = service.getLinkService().getPersonPostalAddressRepository().findByPostalAddress(postalAddress);
			Set<Person_PostalAddress> pers = new HashSet<Person_PostalAddress>(persPaddrs);
			postalAddress.setPersons_postalAddresses(pers);
			
			//classes
			List<PostalAddress_Class> paddrClass = service.getLinkService().getPostalAddressClassRepository().findByPostalAddress(postalAddress);
			Set<PostalAddress_Class> classes = new HashSet<PostalAddress_Class>(paddrClass);
			postalAddress.setClasses(classes);
			
			//facilities
			List<Facility_PostalAddress> facilityPaddrs = service.getLinkService().getFacilityPostalAddressRepository().findByPostalAddress(postalAddress);
			Set<Facility_PostalAddress> facils = new HashSet<Facility_PostalAddress>(facilityPaddrs);
			postalAddress.setFacilities_postalAddresses(facils);
			
			//services
			List<Service_PostalAddress> servicePaddrs = service.getLinkService().getServicePostalAddressRepository().findByPostalAddress(postalAddress);
			Set<Service_PostalAddress> srvs = new HashSet<Service_PostalAddress>(servicePaddrs);
			postalAddress.setServices_postalAddresses(srvs);
			
			CerifPostalAddressRecord postalAddressRecord = new CerifPostalAddressRecord(postalAddress);
			rs.addRecord(postalAddressRecord);	
		}
		
		
		/*
		 * Funding 
		 */
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
			
			//facilities
			List<Facility_Funding> facilityFunds = service.getLinkService().getFacilityFundingRepository().findByFunding(funding);
			Set<Facility_Funding> facils = new HashSet<Facility_Funding>(facilityFunds);
			funding.setFacilities_fundings(facils);
			
			//classes
			List<Funding_Class> fundingClas = service.getLinkService().getFundingClassRepository().findByFunding(funding);
			Set<Funding_Class> classes = new HashSet<Funding_Class>(fundingClas);
			funding.setClasses(classes);
			
			//organistaions
			List<OrganisationUnit_Funding> orgFunds = service.getLinkService().getOrganisationUnitFundingRepository().findByFunding(funding);
			Set<OrganisationUnit_Funding> orgs = new HashSet<OrganisationUnit_Funding>(orgFunds);
			funding.setOrganisationUnits_fundings(orgs);
			
			//persons
			List<Person_Funding> persFunds = service.getLinkService().getPersonFundingRepository().findByFunding(funding);
			Set<Person_Funding> pers = new HashSet<Person_Funding>(persFunds);
			funding.setPersons_fundings(pers);
			
			//projects
			List<Project_Funding> projFunds = service.getLinkService().getProjectFundingRepository().findByFunding(funding);
			Set<Project_Funding> projs = new HashSet<Project_Funding>(projFunds);
			funding.setProjects_fundings(projs);
			
			//Result Products
			List<ResultProduct_Funding> resprodFunds = service.getLinkService().getResultProductFundingRepository().findByFunding(funding);
			Set<ResultProduct_Funding> resprods = new HashSet<ResultProduct_Funding>(resprodFunds);
			funding.setResultProducts_fundings(resprods);
			
			//Result Publications
			List<ResultPublication_Funding> respublFunds = service.getLinkService().getResultPublicationFundingRepository().findByFunding(funding);
			Set<ResultPublication_Funding> respubls = new HashSet<ResultPublication_Funding>(respublFunds);
			funding.setResultPublications_fundings(respubls);
			
			//services
			List<Service_Funding> serviceFunds = service.getLinkService().getServiceFundingRepository().findByFunding(funding);
			Set<Service_Funding> srvs = new HashSet<Service_Funding>(serviceFunds);
			funding.setServices_fundings(srvs);
			
			CerifFundingRecord fundingRecord = new CerifFundingRecord(funding);
			rs.addRecord(fundingRecord);	
		}
		
		
		/*
		 * Class 
		 */
		while (iterClass.hasNext()) {
			Class theClass = iterClass.next(); 
			
			//terms
			List<ClassTerm> classTerms = service.getTranslationService().getClassTermRepository().findByTheClass(theClass);
			Set<ClassTerm> terms = new HashSet<ClassTerm>(classTerms);
			theClass.setTerms(terms);
			
			
			CerifClassRecord classRecord = new CerifClassRecord(theClass);
			rs.addRecord(classRecord);	
		}
		
		
		/*
		 * ResultPublication 
		 */
		while (iterResultPublication.hasNext()) {
			ResultPublication resultPublication = iterResultPublication.next(); 
			
			//classes
			List<ResultPublication_Class> respublClas = service.getLinkService().getResultPublicationClassRepository().findByResultPublication(resultPublication);
			Set<ResultPublication_Class> classes = new HashSet<ResultPublication_Class>(respublClas);
			resultPublication.setResultPublications_classes(classes);
			
			//persons
			List<Person_ResultPublication> persRespubl = service.getLinkService().getPersonResultPublicationRepository().findByResultPublication(resultPublication);
			Set<Person_ResultPublication> pers = new HashSet<Person_ResultPublication>(persRespubl);
			resultPublication.setPersons_resultPublications(pers);
			
			//organisations
			List<OrganisationUnit_ResultPublication> orgRespubls = service.getLinkService().getOrganisationUnitResultPublicationRepository().findByResultPublication(resultPublication);
			Set<OrganisationUnit_ResultPublication> resultPublications2 = new HashSet<OrganisationUnit_ResultPublication>(orgRespubls);
			resultPublication.setOrganisationUnit_resultPublications(resultPublications2);
			
			//projects
			List<Project_ResultPublication> resPublProj = service.getLinkService().getProjectResultPublicationRepository().findByResultPublication(resultPublication);
			Set<Project_ResultPublication> projs = new HashSet<Project_ResultPublication>(resPublProj);
			resultPublication.setProjects_resultPublications(projs);
			
			//funding
			List<ResultPublication_Funding> respublFunds = service.getLinkService().getResultPublicationFundingRepository().findByResultPublication(resultPublication);
			Set<ResultPublication_Funding> funds = new HashSet<ResultPublication_Funding>(respublFunds);
			resultPublication.setResultPublications_fundings(funds);
			
			//facilities
			List<ResultPublication_Facility> respublFacils = service.getLinkService().getResultPublicationFacilityRepository().findByResultPublication(resultPublication);
			Set<ResultPublication_Facility> facils = new HashSet<ResultPublication_Facility>(respublFacils);
			resultPublication.setResultPublications_facilities(facils);
			
			//result products
			List<ResultPublication_ResultProduct> respublResultProd = service.getLinkService().getResultPublicationResultProductRepository().findByResultPublication(resultPublication);
			Set<ResultPublication_ResultProduct> resultProds = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
			resultPublication.setResultPublications_resultProducts(resultProds);
			
			//Services
			List<ResultPublication_Service> serviceRespubls = service.getLinkService().getResultPublicationServiceRepository().findByResultPublication(resultPublication);
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
		}
		
		
		/*
		 * ResultProduct 
		 */
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
			
			//OrganisationUnits
			List<OrganisationUnit_ResultProduct> orgResprod = service.getLinkService().getOrganisationUnitResultProductRepository().findByResultProduct(resultProduct);
			Set<OrganisationUnit_ResultProduct> resultProds = new HashSet<OrganisationUnit_ResultProduct>(orgResprod);
			resultProduct.setOrganisationUnits_resultProducts(resultProds);
			
			//persons
			List<Person_ResultProduct> persResprod = service.getLinkService().getPersonResultProductRepository().findByResultProduct(resultProduct);
			Set<Person_ResultProduct> pers = new HashSet<Person_ResultProduct>(persResprod);
			resultProduct.setPersons_resultProducts(pers);
			
			//projects
			List<Project_ResultProduct> projResultProd = service.getLinkService().getProjectResultProductRepository().findByResultProduct(resultProduct);
			Set<Project_ResultProduct> projs = new HashSet<Project_ResultProduct>(projResultProd);
			resultProduct.setProjects_resultProducts(projs);
			
			//classes
			List<ResultProduct_Class> resprodClas = service.getLinkService().getResultProductClassRepository().findByResultProduct(resultProduct);
			Set<ResultProduct_Class> classes = new HashSet<ResultProduct_Class>(resprodClas);
			resultProduct.setClasses(classes);
			
			//funding
			List<ResultProduct_Funding> resprodFunds = service.getLinkService().getResultProductFundingRepository().findByResultProduct(resultProduct);
			Set<ResultProduct_Funding> funds = new HashSet<ResultProduct_Funding>(resprodFunds);
			resultProduct.setResultProducts_fundings(funds);
			
			//result publications
			List<ResultPublication_ResultProduct> respublResultProd = service.getLinkService().getResultPublicationResultProductRepository().findByResultProduct(resultProduct);
			Set<ResultPublication_ResultProduct> resultPubls = new HashSet<ResultPublication_ResultProduct>(respublResultProd);
			resultProduct.setResultPublications(resultPubls);
			
			//facilities
			List<ResultProduct_Facility> resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByResultProduct(resultProduct);
			Set<ResultProduct_Facility> facils = new HashSet<ResultProduct_Facility>(resprodFacilities);
			resultProduct.setResultProducts_facilities(facils);
			
			//services
			List<ResultProduct_Service> serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByResultProduct(resultProduct);
			Set<ResultProduct_Service> srvs = new HashSet<ResultProduct_Service>(serviceResultProd);
			resultProduct.setResultProducts_services(srvs);
			
			
			CerifResultProductRecord resultProductRecord = new CerifResultProductRecord(resultProduct);
			rs.addRecord(resultProductRecord);	
		}
		
		
		/*
		 * Facility 
		 */
		while (iterFacility.hasNext()) {
			Facility facility = iterFacility.next(); 
			
			//names
			List<FacilityName> facilityNames = service.getTranslationService().getFacilityNameRepository().findByFacility(facility);
			for (FacilityName name:facilityNames) {
				name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
			}
			Set<FacilityName> names = new HashSet<FacilityName>(facilityNames);
			facility.setNames(names);
			
			//classes
			List<Facility_Class> facilityClass = service.getLinkService().getFacilityClassRepository().findByFacility(facility);
			Set<Facility_Class> classes = new HashSet<Facility_Class>(facilityClass);
			facility.setClasses(classes);
			
			//organisations
			List<OrganisationUnit_Facility> orgFacilities = service.getLinkService().getOrganisationUnitFacilityRepository().findByFacility(facility);
			Set<OrganisationUnit_Facility> orgs = new HashSet<OrganisationUnit_Facility>(orgFacilities);
			facility.setOrganisationUnits_facilities(orgs);
			
			//fundings
			List<Facility_Funding> facilityFunds = service.getLinkService().getFacilityFundingRepository().findByFacility(facility);
			Set<Facility_Funding> funds = new HashSet<Facility_Funding>(facilityFunds);
			facility.setFacilities_fundings(funds);
			
			//persons
			List<Person_Facility> facilityPers = service.getLinkService().getPersonFacilityRepository().findByFacility(facility);
			Set<Person_Facility> pers = new HashSet<Person_Facility>(facilityPers);
			facility.setPersons_facilities(pers);
			
			//projects
			List<Project_Facility> projFacilities = service.getLinkService().getProjectFacilityRepository().findByFacility(facility);
			Set<Project_Facility> projs = new HashSet<Project_Facility>(projFacilities);
			facility.setProjects_facilities(projs);
			
			//Result Publications
			List<ResultPublication_Facility> respublFacilities = service.getLinkService().getResultPublicationFacilityRepository().findByFacility(facility);
			Set<ResultPublication_Facility> respubls = new HashSet<ResultPublication_Facility>(respublFacilities);
			facility.setResultPublications_facilities(respubls);
			
			//addresses
			List<Facility_PostalAddress> facilityPaddrs = service.getLinkService().getFacilityPostalAddressRepository().findByFacility(facility);
			Set<Facility_PostalAddress> paddrs = new HashSet<Facility_PostalAddress>(facilityPaddrs);
			facility.setPostalAddresses(paddrs);
			
			//services
			List<Facility_Service> serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByFacility(facility);
			Set<Facility_Service> srvs = new HashSet<Facility_Service>(serviceFacilities);
			facility.setFacilities_services(srvs);
			
			//Result products
			List<ResultProduct_Facility> resprodFacilities = service.getLinkService().getResultProductFacilityRepository().findByFacility(facility);
			Set<ResultProduct_Facility> resultProds = new HashSet<ResultProduct_Facility>(resprodFacilities);
			facility.setResultProducts_facilities(resultProds);
			
			CerifFacilityRecord facilityRecord = new CerifFacilityRecord(facility);
			rs.addRecord(facilityRecord);	
		}
		
		
		/*
		 * Service 
		 */
		while (iterService.hasNext()) {
			Service serviceInst = iterService.next(); 
			
			//names
			List<ServiceName> serviceNames = service.getTranslationService().getServiceNameRepository().findByService(serviceInst);
			for (ServiceName name:serviceNames) {
				name.setName(name.getName().replaceAll("\n", " ").replaceAll("\t", "").replaceAll("\r", " ").replaceAll("\\v", ""));
			}
			Set<ServiceName> names = new HashSet<ServiceName>(serviceNames);
			serviceInst.setNames(names);
			
			//OrganisationUnits
			List<OrganisationUnit_Service> serviceOrgs = service.getLinkService().getOrganisationUnitServiceRepository().findByService(serviceInst);
			Set<OrganisationUnit_Service> orgs = new HashSet<OrganisationUnit_Service>(serviceOrgs);
			serviceInst.setOrganisationUnit_services(orgs);
			
			//persons
			List<Person_Service> servicePers = service.getLinkService().getPersonServiceRepository().findByService(serviceInst);
			Set<Person_Service> pers = new HashSet<Person_Service>(servicePers);
			serviceInst.setPersons_services(pers);
			
			//fundings
			List<Service_Funding> serviceFunds = service.getLinkService().getServiceFundingRepository().findByService(serviceInst);
			Set<Service_Funding> funds = new HashSet<Service_Funding>(serviceFunds);
			serviceInst.setServices_fundings(funds);
			
			//addresses
			List<Service_PostalAddress> servicePaddrs = service.getLinkService().getServicePostalAddressRepository().findByService(serviceInst);
			Set<Service_PostalAddress> paddrs = new HashSet<Service_PostalAddress>(servicePaddrs);
			serviceInst.setServices_postalAdresses(paddrs);
			
			//facilities
			List<Facility_Service> serviceFacilities = service.getLinkService().getFacilityServiceRepository().findByService(serviceInst);
			Set<Facility_Service> facils = new HashSet<Facility_Service>(serviceFacilities);
			serviceInst.setFacilities_services(facils);
			
			//Result Publications
			List<ResultPublication_Service> serviceRespubls = service.getLinkService().getResultPublicationServiceRepository().findByService(serviceInst);
			Set<ResultPublication_Service> resultPubls = new HashSet<ResultPublication_Service>(serviceRespubls);
			serviceInst.setResultPublications_services(resultPubls);
			
			//result products
			List<ResultProduct_Service> serviceResultProd = service.getLinkService().getResultProductServiceRepository().findByService(serviceInst);
			Set<ResultProduct_Service> resultProds = new HashSet<ResultProduct_Service>(serviceResultProd);
			serviceInst.setResultProducts_services(resultProds);
			
			//classes
			List<Service_Class> serviceClass = service.getLinkService().getServiceClassRepository().findByService(serviceInst);
			Set<Service_Class> classes = new HashSet<Service_Class>(serviceClass);
			serviceInst.setServices_classes(classes);
			
			//projects
			List<Project_Service> serviceProj = service.getLinkService().getProjectServiceRepository().findByService(serviceInst);
			Set<Project_Service> projs = new HashSet<Project_Service>(serviceProj);
			serviceInst.setProjects_services(projs);
			
			CerifServiceRecord serviceRecord = new CerifServiceRecord(serviceInst);
			rs.addRecord(serviceRecord);
		}
		return rs;
	}
}
