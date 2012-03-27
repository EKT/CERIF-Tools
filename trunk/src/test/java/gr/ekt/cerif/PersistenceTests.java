package gr.ekt.cerif;

import gr.ekt.cerif.browse.BrowseBox;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.link.project.Project_Project;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;
import gr.ekt.cerif.features.multilingual.ProjectKeyword;
import gr.ekt.cerif.features.multilingual.ProjectTitle;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;
import gr.ekt.cerif.features.multilingual.ResultPatentTitle;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.BrowseService;
import gr.ekt.cerif.services.IndexService;
import gr.ekt.cerif.services.PersistenceService;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test suite for persistence.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 * @author Nikolaos Konstantinou <nkons@ekt.gr>
 * @author Nikos Houssos <nhoussos@ekt.gr>
 * @author Christina Paschou <cpaschou@ekt.gr>
 */
@ContextConfiguration("cerif-persistence-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=false)
public class PersistenceTests {
	
	/**
	 * The persistence service.
	 */
	@Autowired
	PersistenceService service;
	
	@Autowired
	IndexService indexService;
	
	@Autowired
	BrowseService browse;
	
	/**
	 * Tries to save an organisation.
	 */
	@Test
	@Transactional
	public void testSaveOrganisation() {
		OrganisationUnit organisationUnit = new OrganisationUnit();
		//organisationUnit.setId("A1");
		organisationUnit.setUri("www.ekt.gr");
		organisationUnit.setAcronym("Act");
		organisationUnit.setHeadCount(200);
		//organisationUnit.setCurrentCode("EKT");
		service.save(organisationUnit);
		
		organisationUnit = new OrganisationUnit();
		//organisationUnit.setId("A1");
		organisationUnit.setUri("www.ekt.gr");
		organisationUnit.setAcronym("Act");
		organisationUnit.setHeadCount(200);
		//organisationUnit.setCurrentCode("EKT");
		service.save(organisationUnit);
		
		Language language = new Language();
		language.setCode("GR");
		language.setUri("http://example.gr");
		service.save(language);
		
		service.save(organisationUnit);
		
	//////////////////////////////////////////////////////////////////////////////////////////
		
		organisationUnit = new OrganisationUnit();
		organisationUnit.setUri("www.eie.gr");
		organisationUnit.setAcronym("Act for EIE");
		organisationUnit.setHeadCount(200);
		Currency currency = new Currency();
		currency.setCode("euro123");
		currency.setNumeric("101");
//		service.save(currency);
		organisationUnit.setCurrency(currency);
		
		Language language1 = new Language();
		language1.setCode("GR1");
		language1.setUri("http://gr1.gr");
		
		Language language2 = new Language();
		language2.setCode("ENG");
		language2.setUri("http://eng2.gr");
		
		OrganisationUnitName organisationUnitName = new OrganisationUnitName();
		organisationUnitName.setLanguage(language1);
		organisationUnitName.setName("Όνομα στα ελληνικά");
		organisationUnitName.setTranslation(Translation.HUMAN);
		organisationUnitName.setOrganisationUnit(organisationUnit);
		service.save(organisationUnitName);
		
		OrganisationUnitName organisationUnitName2 = new OrganisationUnitName();
		organisationUnitName2.setLanguage(language2);
		organisationUnitName2.setName("Anf in english");
		organisationUnitName2.setTranslation(Translation.HUMAN);
		organisationUnitName2.setOrganisationUnit(organisationUnit);
		service.save(organisationUnitName2);
		
		OrganisationUnitResearchActivity organisationUnitResearchActivity = new OrganisationUnitResearchActivity();
		organisationUnitResearchActivity.setLanguage(language1);
		organisationUnitResearchActivity.setResearchActivity("Ψηφιακά Αποθετήρια");
		organisationUnitResearchActivity.setTranslation(Translation.HUMAN);
		organisationUnitResearchActivity.setOrganisationUnit(organisationUnit);
		service.save(organisationUnitResearchActivity);
		
		OrganisationUnitKeyword organisationUnitKeywords = new OrganisationUnitKeyword();
		organisationUnitKeywords.setLanguage(language2);
		organisationUnitKeywords.setKeyword("keyword1");
		organisationUnitKeywords.setTranslation(Translation.HUMAN);
		organisationUnitKeywords.setOrganisationUnit(organisationUnit);
		service.save(organisationUnitKeywords);
		
		service.save(organisationUnit);	
	}
		
	/**
	 * Tries to save a person.
	 */
	@Test
	@Transactional
	public void testSavePerson() {
		Person person = new Person();
		person.setGender("m");
		person.setBirthDate(new Date());
		
//		Saving research interest of person in GR1 language		
		PersonResearchInterest personResearchInterest = new PersonResearchInterest();
		personResearchInterest.setPerson(person);
		
		Language language = new Language();
		language.setCode("GR1");
		language.setUri("http://gr1.again.gr");
		
		personResearchInterest.setLanguage(language);
		personResearchInterest.setTranslation(Translation.HUMAN);
		personResearchInterest.setResearchInterests("informatics");
		service.save(personResearchInterest);
		
//		Saving keyword of person in GR1 language
		PersonKeyword personKeyword = new PersonKeyword();
		personKeyword.setPerson(person);		
		
		personKeyword.setLanguage(language);
		personKeyword.setTranslation(Translation.HUMAN);
		personKeyword.setKeyword("semantic web");
		service.save(personKeyword);
		
		PersonName personName = new PersonName();
		personName.setFamilyNames("Paschou");
		personName.setFirstNames("Christina");
		personName.setOtherNames("Eleni");
		personName.setPerson(person);
		service.save(personName);

		service.save(person);
	}
	
	/**
	 * Tries to save a project.
	 */
	@Test
	@Transactional
	public void testSaveProject() {
		Project project = new Project();
		project.setAcronym("ESPA");
		project.setUri("espa.gr");
		
		Project project1 = new Project();
		project1.setAcronym("AAAA");
		project1.setUri("AAAA.gr");
		service.save(project1);
		
//		Saving title of project in GR1 language		
		ProjectTitle projectTitle = new ProjectTitle();
		projectTitle.setProject(project);
				
		projectTitle.setLanguage(Language.ENGLISH);
		projectTitle.setTranslation(Translation.HUMAN);
		projectTitle.setTitle("Project Title");
		service.save(projectTitle);
		
//		Saving keyword of person in GR1 language
		ProjectKeyword projectKeyword = new ProjectKeyword();
		projectKeyword.setProject(project);		
		
		projectKeyword.setLanguage(Language.GERMAN);
		projectKeyword.setTranslation(Translation.HUMAN);
		projectKeyword.setKeyword("semantic web");
		service.save(projectKeyword);		

		service.save(project);
	}
	
	/**
	 * Tries to save a patent.
	 */
	@Test
	@Transactional
	public void testSavePatent() {
		ResultPatent patent = new ResultPatent();
		patent.setNumber("12345");
		patent.setApprovalDate(new Date());
		
		ResultPatentTitle patentTitle = new ResultPatentTitle();
		patentTitle.setResultPatent(patent);
		patentTitle.setLanguage(Language.ENGLISH);
		patentTitle.setTranslation(Translation.HUMAN);
		patentTitle.setTitle("Patent Title");
		service.save(patentTitle);
		
		ResultPatentAbstract patentAbstract = new ResultPatentAbstract();
		patentAbstract.setResultPatent(patent);
		patentAbstract.setLanguage(Language.ENGLISH);
		patentAbstract.setTranslation(Translation.HUMAN);
		patentAbstract.setAbstractText("Patent Abstract");
		service.save(patentAbstract);
		
		ResultPatentKeyword patentKeyword = new ResultPatentKeyword();
		patentKeyword.setResultPatent(patent);
		patentKeyword.setLanguage(Language.ENGLISH);
		patentKeyword.setTranslation(Translation.HUMAN);
		patentKeyword.setKeyword("Patent keyword");
		service.save(patentKeyword);
		service.save(patent);
	}
	
	/**
	 * Tries to save a product.
	 */
	@Test
	@Transactional
	public void testSaveProduct() {
		ResultProduct product = new ResultProduct();
		product.setUri("www.ekt.gr");
		service.save(product);
		
		product = new ResultProduct();
		product.setUri("www.ekt.gr");
		service.save(product);
	}
	
	/**
	 * Tries to save a publication.
	 */
	@Test
	@Transactional
	public void testSavePublication() {
		ResultPublication publication = new ResultPublication();
		publication.setEdition("Edition1");
		publication.setStartPage("I");
		publication.setEndPage("XVII");
		
		ResultPublicationTitle resultPublicationTitle = new ResultPublicationTitle();
		resultPublicationTitle.setResultPublication(publication);
		resultPublicationTitle.setLanguage(Language.ENGLISH);
		resultPublicationTitle.setTranslation(Translation.HUMAN);
		resultPublicationTitle.setTitle("publication Title");
		service.save(resultPublicationTitle);
		
		ResultPublicationSubtitle resultPublicationSubtitle = new ResultPublicationSubtitle();
		resultPublicationSubtitle.setResultPublication(publication);
		resultPublicationSubtitle.setLanguage(Language.GERMAN);
		resultPublicationSubtitle.setTranslation(Translation.HUMAN);
		resultPublicationSubtitle.setSubtitle("publication subTitle");
		service.save(resultPublicationSubtitle);
		
		ResultPublicationAbstract resultPublicationAbstract = new ResultPublicationAbstract();
		resultPublicationAbstract.setResultPublication(publication);
		resultPublicationAbstract.setLanguage(Language.ENGLISH);
		resultPublicationAbstract.setTranslation(Translation.HUMAN);
		resultPublicationAbstract.setAbstractText("Patent Abstract");
		service.save(resultPublicationAbstract);
		
		ResultPublicationKeyword resultPublicationKeyword = new ResultPublicationKeyword();
		resultPublicationKeyword.setResultPublication(publication);
		resultPublicationKeyword.setLanguage(Language.ENGLISH);
		resultPublicationKeyword.setTranslation(Translation.HUMAN);
		resultPublicationKeyword.setKeyword("Patent keyword");
		service.save(resultPublicationKeyword);
		
		service.save(publication);
	}
	
	/**
	 * Tries to save a country.
	 */
	@Test
	@Transactional
	public void testSaveCountry() {
		Country country = new Country();
		country.setCode("el");
		service.save(country);
	}
	
	/**
	 * Tries to save an electronic address.
	 */
	@Test
	@Transactional
	public void testSaveElectronicAddress() {
		ElectronicAddress address = new ElectronicAddress();
		service.save(address);
	}
	
	/**
	 * Tries to save a language.
	 */
	@Test
	@Transactional
	public void testSaveLanguage() {
		Language language = new Language();
		language.setCode("el_GR");
		service.save(language);
		
		language = new Language();
		language.setCode("el_GR");
		service.save(language);
	}
	
	/**
	 * Tries to save a facility.
	 */
	@Test
	@Transactional
	public void testSaveFacility() {
		Facility facility = new Facility();
		facility.setAcronym("acronumo");
		facility.setUri("uri acronumou");
		service.save(facility);			
	}
	
	/**
	 * Tries to save an event.
	 */
	@Test
	@Transactional
	public void testSaveEvent() {
		Event event = new Event();
		event.setUri("event2.gr");
		event.setFeeOrFree("Free2");
		
		Country country = new Country();
		country.setCode("gh");
		//service.save(country);
		
		event.setCountry(country);
		service.save(event);			
	}
	
	/**
	 * Tries to save a postal address.
	 */
	@Test
	@Transactional
	public void testSavePostalAddress() {
		PostalAddress address = new PostalAddress();
		address.setPostalCode("123456");
		address.setCityTown("Athens4");
		
		Country country = new Country();
		country.setCode("fd");
		//service.save(country);
		
		address.setCountry(country);
		
		service.save(address);
	}
	
	/**
	 * Tries to save a classification class.
	 */
	@Test
	@Transactional
	public void testSaveClass() {
		Class myClass = new Class();
		myClass.setUri("namespace:form");
		service.save(myClass);
		
		ClassScheme myClassScheme = new ClassScheme();
		myClassScheme.setUri("namespaceSCHEME:form");
		service.save(myClassScheme);
		
		ClassDescription classDescription = new ClassDescription();
		classDescription.setTheClass(myClass);
		classDescription.setClassScheme(myClassScheme);
		classDescription.setLanguage(Language.ENGLISH);
		classDescription.setTranslation(Translation.HUMAN);
		classDescription.setDescription("Class Desrciption");
		service.save(classDescription);
		
		ClassTerm classTerm = new ClassTerm();
		classTerm.setTheClass(myClass);
		classTerm.setClassScheme(myClassScheme);
		classTerm.setLanguage(Language.DUTCH);
		classTerm.setTranslation(Translation.HUMAN);
		classTerm.setTerm("Class Term");
		service.save(classTerm);
		
	}
	
	/**
	 * Tries to save a classification scheme.
	 */
	@Test
	@Transactional
	public void testSaveScheme() {
		ClassScheme scheme = new ClassScheme();
		scheme.setUri("scheme:list");
		service.save(scheme);
		
		ClassSchemeDescription classSchemeDescription = new ClassSchemeDescription();
		classSchemeDescription.setClassScheme(scheme);
		classSchemeDescription.setLanguage(Language.ENGLISH);
		classSchemeDescription.setTranslation(Translation.HUMAN);
		classSchemeDescription.setDescription("Scheme Desrciption");
		service.save(classSchemeDescription);
		
		ClassSchemeName classSchemeName = new ClassSchemeName();
		classSchemeName.setClassScheme(scheme);
		classSchemeName.setLanguage(Language.ENGLISH);
		classSchemeName.setTranslation(Translation.HUMAN);
		classSchemeName.setName("Scheme Name");
		service.save(classSchemeName);
	}
	
	@Test
	@Transactional
	public void testSaveLink() {
		
		OrganisationUnit organisation = new OrganisationUnit();
		organisation.setAcronym("sdfasdfsd");
		service.save(organisation);
		
		ResultProduct product = new ResultProduct();
		product.setUri("sadfasdfasdf");
		service.save(product);
		
		Class aclass = new Class();
		aclass.setUri("asdasdasd");
		service.save(aclass);
		
		ClassScheme scheme = new ClassScheme();
		scheme.setUri("scheme:mods");
		service.save(scheme);
		
		Currency currency = new Currency();
		currency.setCode("euro");
		service.save(currency);
		
		OrganisationUnit_ResultProduct link = new OrganisationUnit_ResultProduct();
		link.setOrganisationUnit(organisation);
		link.setResultProduct(product);
		link.setAvailability("availability");
		link.setConditions("conditions");
		link.setTheClass(aclass);
//		link.setClassScheme(scheme);
		link.setCurrency(currency);
		service.save(link);
		
	}
	
	@Test
	@Transactional
	public void testSaveLinkProjectProject() {
		Project project1 = new Project();
		project1.setAcronym("ESPA-GR");
		project1.setUri("espa-gr");		
		service.save(project1);
		
		Project project2 = new Project();
		project2.setAcronym("EPSET-GR");
		project2.setUri("epset-gr");		
		service.save(project2);
				
		Class aclass = new Class();
		aclass.setUri("Project_ProjectCLASS");
		service.save(aclass);
		
		ClassScheme scheme = new ClassScheme();
		scheme.setUri("scheme:dc");
		service.save(scheme);
		
		Project_Project link = new Project_Project();
		link.setProject1(project1);
		link.setProject2(project2);		
		link.setEndDate(new Date());
		link.setStartDate(new Date());
		link.setTheClass(aclass);
//		link.setClassScheme(scheme);
		
		service.save(link);
	}
	
	@Test
	@Transactional
	public void testSaveLinkProjectPerson() {
		Project project1 = new Project();
		project1.setAcronym("ESPA-GR");
		project1.setUri("espa-gr");		
		service.save(project1);
		
		Person person = new Person();
		person.setGender("f");
		person.setBirthDate(new Date());		
		service.save(person);
				
		Class aclass = new Class();
		aclass.setUri("Project_ProjectCLASS");
		service.save(aclass);
		
		ClassScheme scheme = new ClassScheme();
		scheme.setUri("scheme:dc");
		service.save(scheme);
		
		Project_Person link = new Project_Person();
		link.setProject(project1);
		link.setPerson(person);		
		link.setEndDate(new Date());
		link.setStartDate(new Date());
		link.setTheClass(aclass);
//		link.setClassScheme(scheme);
		
		service.save(link);
	}
	
	
	@Test
	@Transactional
	public void testIndexAndSearch() {
		
		indexService.createIndex();

		List<CerifComponent> results = indexService.queryIndex("Act");
		
		System.out.println("Found " + results.size() + " results");
		for (CerifComponent result : results) {
			System.out.println(((OrganisationUnit) result).getHeadCount());
		}

	}
	
	@Test
	@Transactional
	public void testSaveResultProductTranslation() {
		
		Language language = Language.ENGLISH;
		service.save(language);
		
		ResultProduct resProd = new ResultProduct();
		resProd.setUri("www.uri.com");
		
		ResultProductName resProdName = new ResultProductName();		 
		resProdName.setResultProduct(resProd);
		resProdName.setName("Name");		
		resProdName.setLanguage(Language.ENGLISH);
		resProdName.setTranslation(Translation.MACHINE);
		
		ResultProductDescription resProdDescription = new ResultProductDescription();		 
		resProdDescription.setResultProduct(resProd);
		resProdDescription.setLanguage(Language.ENGLISH);
		resProdDescription.setTranslation(Translation.MACHINE);
		resProdDescription.setDescription("Description");
		
		ResultProductKeyword resProdKeyword = new ResultProductKeyword();		 
		resProdKeyword.setResultProduct(resProd);
		resProdKeyword.setLanguage(Language.ENGLISH);
		resProdKeyword.setTranslation(Translation.MACHINE);
		resProdKeyword.setKeyword("My keywords");
		
		service.save(resProdName);
		service.save(resProdDescription);
		service.save(resProdKeyword);
		
		service.save(resProd);
		
	}
	
	@Test
	@Transactional
	public void testSearchByKeyword() {
		List<ResultProduct> list = service.getProductsByKeyword("statistics");
		System.out.println(list.size());
	}

//	@Test
//	@Transactional
//	public void testBrowseData() {
//		List<BrowseBox> list = browse.getBoxes();
//		for (BrowseBox box : list) {
//			System.out.println(box);
//		}
//	}
	
}
