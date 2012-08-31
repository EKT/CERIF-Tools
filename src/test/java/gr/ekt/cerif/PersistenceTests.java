package gr.ekt.cerif;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
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
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.FacilityDescription;
import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.features.multilingual.FundingName;
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
import gr.ekt.cerif.services.IndexService;
import gr.ekt.cerif.services.PersistenceService;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(PersistenceTests.class);
	/**
	 * The persistence service.
	 */
	@Autowired
	PersistenceService service;
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	IndexService indexService;
	
	/**
	 * Tries to save an organisation.
	 */
	@Test
	@Transactional
	public void testSaveOrganisation() {
		
		OrganisationUnit organisationUnit = new OrganisationUnit();
		organisationUnit.setUri("www.ekt.gr");
		organisationUnit.setAcronym("Act");
		organisationUnit.setHeadCount(200);
		service.save(organisationUnit);
		
		organisationUnit = new OrganisationUnit();
		organisationUnit.setUri("www.ekt.gr");
		organisationUnit.setAcronym("Act");
		organisationUnit.setHeadCount(200);
		service.save(organisationUnit);
		
		Language language = new Language();
		language.setCode("GR");
		language.setUri("http://example.gr");
		service.save(language);
		
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
		service.save(person);
		
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
		service.save(project);		
		
	}
	
	
	
	
	
	
	
	
	
}
