package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Country;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Equipment;
import gr.ekt.cerif.entities.link.person.Person_Event;
import gr.ekt.cerif.entities.link.person.Person_ExpertiseAndSkills;
import gr.ekt.cerif.entities.link.person.Person_Facility;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.link.person.Person_ResultPatent;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_Service;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.multilingual.PersonKeyword;
import gr.ekt.cerif.features.multilingual.PersonResearchInterest;
import gr.ekt.cerif.services.GenericSuperRepository;
import gr.ekt.cerif.services.additional.PersonNameRepository;
import gr.ekt.cerif.services.link.person.LinkPersonClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCountryRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCvRepository;
import gr.ekt.cerif.services.link.person.LinkPersonElectronicAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEquipmentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonEventRepository;
import gr.ekt.cerif.services.link.person.LinkPersonExpertiseAndSkillsRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFacilityRepository;
import gr.ekt.cerif.services.link.person.LinkPersonFundingRepository;
import gr.ekt.cerif.services.link.person.LinkPersonIndicatorRepository;
import gr.ekt.cerif.services.link.person.LinkPersonLanguageRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMeasurementRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMediumRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPersonRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPrizeRepository;
import gr.ekt.cerif.services.link.person.LinkPersonQualificationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPatentRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultProductRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonServiceRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
import gr.ekt.cerif.services.multilingual.person.PersonKeywordRepository;
import gr.ekt.cerif.services.multilingual.person.PersonResearchInterestRepository;
import gr.ekt.cerif.services.second.ElectronicAddressRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonRepositoryImpl implements PersonRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PersonRepositoryImpl.class);

	@Autowired
	private PersonCrudRepository personCrudRepository;
	
	@Autowired
	private LinkPersonOrganisationUnitRepository linkPersonOrganisationUnitRepository;
	
	@Autowired
	private LinkPersonClassRepository linkPersonClassRepository;
	
	@Autowired
	private LinkPersonCountryRepository linkPersonCountryRepository;
	
	@Autowired
	private LinkPersonElectronicAddressRepository linkPersonElectronicAddressRepository;
	
	@Autowired
	private LinkPersonPostalAddressRepository linkPersonPostalAddressRepository;
	
	@Autowired
	private LinkPersonResultPublicationRepository linkPersonResultPublicationRepository;
	
	@Autowired
	private LinkProjectPersonRepository linkProjectPersonRepository;
	
	@Autowired
	private PersonNameRepository personNameRepository;
	
	@Autowired
	private LinkPersonPersonRepository linkPersonPersonRepository;
	
	@Autowired
	private LinkPersonMediumRepository linkPersonMediumRepository;
	
	@Autowired
	private OrganisationUnitRepository organisationUnitRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ClassSchemeRepository classSchemeRepository;
	
	@Autowired
	private LinkPersonCvRepository linkPersonCvRepository;
	
	@Autowired
	private ElectronicAddressRepository electronicAddressRepository;
	
	@Autowired
	private LinkPersonEquipmentRepository linkPersonEquipmentRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private LinkPersonEventRepository linkPersonEventRepository;
	
	@Autowired
	private LinkPersonExpertiseAndSkillsRepository linkPersonExpertiseAndSkillsRepository;
	
	@Autowired
	private LinkPersonFacilityRepository linkPersonFacilityRepository;
	
	@Autowired
	private LinkPersonFundingRepository linkPersonFundingRepository;
	
	@Autowired
	private LinkPersonIndicatorRepository linkPersonIndicatorRepository;
	
	@Autowired
	private LinkPersonLanguageRepository linkPersonLanguageRepository;
	
	@Autowired
	private LinkPersonMeasurementRepository linkPersonMeasurementRepository;
	
	@Autowired
	private LinkPersonPrizeRepository linkPersonPrizeRepository;
	
	@Autowired
	private LinkPersonQualificationRepository linkPersonQualificationRepository;
	
	@Autowired
	private LinkPersonResultPatentRepository linkPersonResultPatentRepository;
	
	@Autowired
	private LinkPersonResultProductRepository linkPersonResultProductRepository;
	
	@Autowired
	private LinkPersonServiceRepository linkPersonServiceRepository;
	
	@Autowired
	private PersonKeywordRepository personKeywordRepository;
	
	@Autowired
	private PersonResearchInterestRepository personResearchInterestRepository;
	
	private GenericSuperRepository personGenericRepository;
	
	
	@Override
	@Transactional
	public void delete(Person entity) {
		List<Person_OrganisationUnit> po = linkPersonOrganisationUnitRepository.findByPerson(entity);
		if (po != null) linkPersonOrganisationUnitRepository.delete(po);
		entity.setPersons_organisationUnits(null);
		
		List<Person_Class> pc = linkPersonClassRepository.findByPerson(entity);
		if (pc != null) linkPersonClassRepository.delete(pc);
		entity.setClasses(null);
		
		List<Person_ElectronicAddress> pe = linkPersonElectronicAddressRepository.findByPerson(entity);
		List<ElectronicAddress> ea = electronicAddressRepository.findByPerson(entity);
		if (pe != null) linkPersonElectronicAddressRepository.delete(pe);
		entity.setPersons_electronicAddresses(null);		
		
		List<Person_PostalAddress> pp = linkPersonPostalAddressRepository.findByPerson(entity);
		List<PostalAddress> lpa = postalAddressRepository.findByPerson(entity);
		if (pp != null) linkPersonPostalAddressRepository.delete(pp);
		entity.setPersons_postalAddresses(null);		

		List<Person_ResultPublication> pr = linkPersonResultPublicationRepository.findByPerson(entity);
		if (pr != null) linkPersonResultPublicationRepository.delete(pr);
		entity.setPersons_resultPublications(null);
		
		List<Project_Person> prp = linkProjectPersonRepository.findByPerson(entity);
		if (prp != null) linkProjectPersonRepository.delete(prp);
		entity.setProjects(null);
		
		List<PersonName> pn = personNameRepository.findByPerson(entity);
		if (pn != null) personNameRepository.delete(pn);
		entity.setPersonNames(null);
		
		List<PersonKeyword> pk = personKeywordRepository.findByPerson(entity);
		if (pk != null) personKeywordRepository.delete(pk);
		entity.setPersonKeywords(null);
		
		List<PersonResearchInterest> pri = personResearchInterestRepository.findByPerson(entity);
		if (pri != null) personResearchInterestRepository.delete(pri);
		entity.setPersonResearchInterests(null);
		
		//delete the relations where the person is the first in the relation
		List<Person_Person> p2a = linkPersonPersonRepository.findByPerson1(entity);
		if (p2a != null) linkPersonPersonRepository.delete(p2a);
		entity.setPersons_persons1(null);
		
		//delete the relations where the person is the second in the relation
		List<Person_Person> p2b = linkPersonPersonRepository.findByPerson2(entity);
		if (p2b != null) linkPersonPersonRepository.delete(p2b);
		entity.setPersons_persons2(null);
		
		List<Person_Medium> pm = linkPersonMediumRepository.findByPerson(entity);
		if (pm != null) linkPersonMediumRepository.delete(pm);
		entity.setPersons_mediums(null);
		
		List<Person_Cv> pcv = linkPersonCvRepository.findByPerson(entity);
		if (pcv != null) linkPersonCvRepository.delete(pcv);
		entity.setPersons_cvs(null);
		
		List <Person_Country> pcoun = linkPersonCountryRepository.findByPerson(entity);
		if (pcoun != null) linkPersonCountryRepository.delete(pcoun);
		entity.setPersons_countries(null);
		
		List<Person_Equipment> pequ = linkPersonEquipmentRepository.findByPerson(entity);
		if (pequ != null) linkPersonEquipmentRepository.delete(pequ);
		entity.setPersons_equipments(null);
		
		List<Person_Event> pev = linkPersonEventRepository.findByPerson(entity);
		if (pev != null) linkPersonEventRepository.delete(pev);
		entity.setPersons_events(null);
		
		List<Person_ExpertiseAndSkills> pexps = linkPersonExpertiseAndSkillsRepository.findByPerson(entity);
		if (pexps != null) linkPersonExpertiseAndSkillsRepository.delete(pexps);
		entity.setPersons_expertiseAndSkills(null);
		
		List<Person_Facility> pfac = linkPersonFacilityRepository.findByPerson(entity);
		if (pfac != null) linkPersonFacilityRepository.delete(pfac);
		entity.setPersons_facilities(null);
		
		List<Person_Funding> pfun = linkPersonFundingRepository.findByPerson(entity);
		if (pfun != null) linkPersonFundingRepository.delete(pfun);
		entity.setPersons_fundings(null);
		
		List<Person_Indicator> pin = linkPersonIndicatorRepository.findByPerson(entity);
		if (pin != null) linkPersonIndicatorRepository.delete(pin);
		entity.setPersons_indicators(null);
		
		List<Person_Language> plan = linkPersonLanguageRepository.findByPerson(entity);
		if (plan != null) linkPersonLanguageRepository.delete(plan);
		entity.setPersons_languages(null);
		
		List<Person_Measurement> pmeas = linkPersonMeasurementRepository.findByPerson(entity);
		if (pmeas != null) linkPersonMeasurementRepository.delete(pmeas);
		entity.setPersons_measurements(null);
		
		List<Person_Prize> ppr = linkPersonPrizeRepository.findByPerson(entity);
		if (ppr != null) linkPersonPrizeRepository.delete(ppr);
		entity.setPersons_prizes(null);
		
		List<Person_Qualification> pqual = linkPersonQualificationRepository.findByPerson(entity);
		if (pqual != null) linkPersonQualificationRepository.delete(pqual);
		entity.setPersons_qualifications(null);
		
		List<Person_ResultPatent> rpat = linkPersonResultPatentRepository.findByPerson(entity);
		if (rpat != null) linkPersonResultPatentRepository.delete(rpat);
		entity.setPersons_resultPatents(null);
		
		List<Person_ResultProduct> pprod = linkPersonResultProductRepository.findByPerson(entity);
		if (pprod != null) linkPersonResultProductRepository.delete(pprod);
		entity.setPersons_resultProducts(null);
		
		List<Person_Service> pser = linkPersonServiceRepository.findByPerson(entity);
		if (pser != null) linkPersonServiceRepository.delete(pser);
		entity.setPersons_services(null);
		
		entity = personCrudRepository.save(entity);
		personCrudRepository.delete(entity);
		
		if (ea != null) electronicAddressRepository.delete(ea);
		if (lpa != null) postalAddressRepository.delete(lpa);
	}

	@Transactional
	public Iterable<Person> save(Iterable<Person> entities) {
		return personCrudRepository.save(entities);
	}

	@Transactional
	public Person save(Person entity) {
		return personCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<Person> entities) {
		personCrudRepository.delete(entities);
	}

	/**
	 * @return the personGenericRepository
	 */
	public GenericSuperRepository getPersonGenericRepository() {
		return personGenericRepository;
	}

	/**
	 * @param personGenericRepository the personGenericRepository to set
	 */
	public void setPersonGenericRepository(
			GenericSuperRepository personGenericRepository) {
		this.personGenericRepository = personGenericRepository;
	}

	@Override
	public Iterable<Person> findAll() {
		return personCrudRepository.findAll();
	}

	@Override
	public Page<Person> findAll(Pageable page) {
		return personCrudRepository.findAll(page);
	}

	@Override
	public Person findById(Long id) {
		return personCrudRepository.findOne(id);
	}

	@Override
	public Person findByUUID(String uuid) {
		return personCrudRepository.findByUuid(uuid);
	}

	@Override
	public Person findByUri(String uri) {
		return personCrudRepository.findByUri(uri);
	}
	
	
}
