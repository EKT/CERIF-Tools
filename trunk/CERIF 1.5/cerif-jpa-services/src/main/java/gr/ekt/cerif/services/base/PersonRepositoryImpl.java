package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.services.GenericSuperRepository;
import gr.ekt.cerif.services.additional.PersonNameRepository;
import gr.ekt.cerif.services.link.person.LinkPersonClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCvRepository;
import gr.ekt.cerif.services.link.person.LinkPersonElectronicAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMediumRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPersonRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;
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
	
	private GenericSuperRepository personGenericRepository;
	
	public Person findPersonById(Long id) {
		return personCrudRepository.findPersonById(id);
	}

	public Person findPersonName(String familyNames) {
		return personCrudRepository.findPersonName(familyNames);
	}
	
	public Person findPersonByOtherName(String otherNames) {
		return personCrudRepository.findPersonByOtherName(otherNames);
	}
	
	public Object findPersonNameByPersonId(Long id) {
		return personCrudRepository.findPersonNameByPersonId(id);
	}
	

	@Transactional
	public void delete(Person entity) {
		List<Person_OrganisationUnit> po = linkPersonOrganisationUnitRepository.findByPerson(entity);
		if (po != null) linkPersonOrganisationUnitRepository.delete(po);
		entity.setPersons_organisationUnits(null);
		
		List<Person_Class> pc = linkPersonClassRepository.findByPerson(entity);
		if (pc != null) linkPersonClassRepository.delete(pc);
		entity.setClasses(null);
		
		List<Person_ElectronicAddress> pe = linkPersonElectronicAddressRepository.findByPerson(entity);
		if (pe != null) linkPersonElectronicAddressRepository.delete(pe);
		entity.setPersons_electronicAddresses(null);
		
		List<Person_PostalAddress> pp = linkPersonPostalAddressRepository.findByPerson(entity);
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
		
		//delete the relations where the person is the first in the relation
		List<Person_Person> p2a = linkPersonPersonRepository.findByPerson1(entity);
		if (p2a != null) linkPersonPersonRepository.delete(p2a);
		entity.setPerson1_persons(null);
		
		//delete the relations where the person is the second in the relation
		List<Person_Person> p2b = linkPersonPersonRepository.findByPerson2(entity);
		if (p2b != null) linkPersonPersonRepository.delete(p2b);
		entity.setPerson2_persons(null);
		
		List<Person_Medium> pm = linkPersonMediumRepository.findByPerson(entity);
		if (pm != null) linkPersonMediumRepository.delete(pm);
		
		List<Person_Cv> pcv = linkPersonCvRepository.findByPerson(entity);
		if (pcv != null) linkPersonCvRepository.delete(pcv);
		
		//save it before deleting it to commit all other changes
		entity = personCrudRepository.save(entity);
		personCrudRepository.delete(entity);
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
	
	
}
