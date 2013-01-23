package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.PersonList;
import gr.ekt.cerif.entities.base.PersonView;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_Medium;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_Person;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassView;
import gr.ekt.cerif.services.additional.PersonNameRepository;
import gr.ekt.cerif.services.link.person.LinkPersonClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonElectronicAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonMediumRepository;
import gr.ekt.cerif.services.link.person.LinkPersonOrganisationUnitRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPersonRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPersonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonRepositoryImpl implements PersonRepository {

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
	
	public PersonName findPersonNamesByPersonId(Long id) {
		return personCrudRepository.findPersonNamesByPersonId(id);
	}
	
	public List<PersonView> findLastEditorNamesByResPubId(Long id) {
		return personCrudRepository.findLastEditorNamesByResPubId(id);
	}
	
	public List<Long> findPersonIdsByResPubIdAndLinkClass(Long id, String classUri) {
		return personCrudRepository.findPersonIdsByResPubIdAndLinkClass(id, classUri);
	}
	
	public List<PersonName> findPersonNamesByResPubIdAndLinkClass(Long id, String classUri) {
		return personCrudRepository.findPersonNamesByResPubIdAndLinkClass(id, classUri);
	}
	
	public List<PersonList> findByProjectId(Long id) {
		return personCrudRepository.findByProjectId(id);
	}
	
	public List<PersonList> findByProjPersClassSchemeAndProjPersClassAndProjectId(String schemeUri, String classUri, Long id) {
		return personCrudRepository.findByProjPersClassSchemeAndProjPersClassAndProjectId(schemeUri, classUri, id);
	}
	
	public List<PersonList> findByOrgUnitClassSchemeAndOrgUnitClass(String schemeUri, String classUri) {
		
		return personCrudRepository.findByOrgUnitClassSchemeAndOrgUnitClass(schemeUri, classUri);
	}
	
	public List<PersonList> findByOrgUnitClassScheme(String schemeUri) {
		return personCrudRepository.findByOrgUnitClassScheme(schemeUri);
	}
	
	public List<PersonView> findByOrgUnitId(Long id) {
		return personCrudRepository.findByOrgUnitId(id);
	}
	
	public List<PersonView> findByOrgUnitIdAndPersOrgRole(Long id, String role) {
		return personCrudRepository.findByOrgUnitIdAndPersOrgRole(id, role);
	}
	
	public List<PersonList> findByPolicyType(String PolicyType) {
		return personCrudRepository.findByPolicyType(PolicyType);
	}
	
	public List<PersonList> findAllPersons() {
		return personCrudRepository.findAllPersons();
	}
	
	public List<PersonList> findAllByStakeholderCat(String stakeholderCat) {
		return personCrudRepository.findAllByStakeholderCat(stakeholderCat);
	}
	
	public List<PersonList> findAllProgrammeCommittee() {
		return personCrudRepository.findAllProgrammeCommittee();
	}
	
	public List<PersonList> findAllByStakeholderCat(String stakeholderCat, String personCat) {
		return personCrudRepository.findAllByStakeholderCat(stakeholderCat, personCat);
	}
	
	public List<PersonList> findAllByPersonCat(String personCat) {
		return personCrudRepository.findAllByPersonCat(personCat);
	}
	
	public List<PersonList> findAllWithRegistration() {
		return personCrudRepository.findAllWithRegistration();
	}

	public List<PersonList> findAllByRIPolicyBody(String policyBody) {
		return personCrudRepository.findAllByRIPolicyBody(policyBody);
	}
	
	public List<String> findStakeholderListByPersonId(Long id) {
		return personCrudRepository.findStakeholderListByPersonId(id);
	}
	
	public List<String> findClassListByPersonIdAndSchemeId(Long id, Long schemeId) {
		return personCrudRepository.findClassListByPersonIdAndSchemeId(id, schemeId);
	}
	
	public List<String> findClassListByPersonIdAndSchemeUri(Long id, String schemeUri) {
		return personCrudRepository.findClassListByPersonIdAndSchemeUri(id, schemeUri);
	}
	
	public List<ClassView> findClassViewListByPersonIdAndSchemeId(Long id, Long schemeId) {
		return personCrudRepository.findClassViewListByPersonIdAndSchemeId(id, schemeId);
	}

	public List<String> findPolicyBodiesByPersonId(Long id) {
		return personCrudRepository.findPolicyBodiesByPersonId(id);
	}

	public List<Object[]> countByStakeholderCat() {
		return personCrudRepository.countByStakeholderCat();
	}

	public List<Object[]> countRINCPNetwrokMembers() {
		return personCrudRepository.countRINCPNetwrokMembers();
	}

	public List<Object[]> countRIContactPerson() {
		return personCrudRepository.countRIContactPerson();
	}
	
	public List<Object[]> countByRIPolicyBody() {
		return personCrudRepository.countByRIPolicyBody();
	}
	
	public List<PersonView> findByPersonClassSchemeAndId(String PersonClass, Long id) {
		return personCrudRepository.findByPersonClassSchemeAndId(PersonClass, id);
	}
	
	public PersonView findByPersonId2(Long id) {
		return personCrudRepository.findByPersonId2(id);
	}

	public PersonView findByPersonId(Long id) {
		return personCrudRepository.findByPersonId(id);
	}

	public String findOrgTypeByPersonIdAndScheme(Long id, String schemeUri) {
		return personCrudRepository.findOrgTypeByPersonIdAndScheme(id, schemeUri);
	}

	public byte[] findCVByPersonIdAndClassId(Long id, String uri) {
		return personCrudRepository.findCVByPersonIdAndClassId(id, uri);
	}

	public List<PersonList> findByPolicySuperType(String PolicySuperType) {
		return personCrudRepository.findByPolicySuperType(PolicySuperType);
	}

	public List<PersonList> findAllWithCountry() {
		return personCrudRepository.findAllWithCountry();
	}

	public List<PersonList> findAllNCPWithCountry() {
		return personCrudRepository.findAllNCPWithCountry();
	}
	
	public PersonList findAllNoNCPWithCountryByRoleAndOrg(String role, Long orgId) {
		return personCrudRepository.findAllNoNCPWithCountryByRoleAndOrg(role, orgId);
	}
	
	public List<PersonList> findAllWithRIPBRole() {
		return personCrudRepository.findAllWithRIPBRole();
	}

	public String findRIPolicyBodyRoleByPersId(Long id) {
		return personCrudRepository.findRIPolicyBodyRoleByPersId(id);
	}
	
	public List<PersonList> findAllPersonsWithOrgNoRIPBRoleAndWithCountry() {
		return personCrudRepository.findAllPersonsWithOrgNoRIPBRoleAndWithCountry();
	}
	
	public List<PersonList> findAllPersonsWithProjects() {
		return personCrudRepository.findAllPersonsWithProjects();
	}
	
	public Person findByProjectAndtheClass(Project project, Class theClass) {
		return personCrudRepository.findByProjectAndtheClass(project, theClass);
	}
	
	public PersonName findPersNameByPersonId(Long personId) {
		return personCrudRepository.findPersNameByPersonId(personId);
	}

	public ElectronicAddress findElectronicAddressByPersonId(Long personId) {
		return personCrudRepository.findElectronicAddressByPersonId(personId);
	}

	public PostalAddress findPostalAddressByPersonId(Long personId) {
		return personCrudRepository.findPostalAddressByPersonId(personId);
	}
	
	public Person_Class findByPersonIdAndClassUri(Long personId, String classUri) {
		return personCrudRepository.findByPersonIdAndClassUri(personId, classUri);
	}
	
	public Person_Class findPersonUserState(Long personId) {
		return personCrudRepository.findPersonUserState(personId);
	}
	
	public Person_OrganisationUnit findByPersonIdAndSchemeId(Long personId, Long schemeId) {
		return personCrudRepository.findByPersonIdAndSchemeId(personId, schemeId);
	}
	
	public Person_OrganisationUnit findByPersonIdAndSchemeUri(Long personId, String schemeUri) {
		return personCrudRepository.findByPersonIdAndSchemeUri(personId, schemeUri);
	}
	
	public Person_Class findPersClassByPersonIdAndSchemeId(Long personId, Long schemeId) {
		return personCrudRepository.findPersClassByPersonIdAndSchemeId(personId, schemeId);
	}
	
	public Person_Class findPersClassByPersonIdAndSchemeUri(Long personId, String schemeUri) {
		return personCrudRepository.findPersClassByPersonIdAndSchemeUri(personId, schemeUri);
	}

	public Person_ResultPublication isResultPublicationFavourite(Long id, String username) {
		return personCrudRepository.isResultPublicationFavourite(id, username);
	}
	
	public Person_OrganisationUnit isOrganisationUnitFavourite(Long id, String username) {
		return personCrudRepository.isOrganisationUnitFavourite(id, username);
	}
	
	public Person_Person isPersonFavourite(Long id, String username) {
		return personCrudRepository.isPersonFavourite(id, username);
	}
	
	public List<PersonList> findFavouritePersons(Long id) {
		return personCrudRepository.findFavouritePersons(id);
	}
	
	public CV findCVByPersonIdAndClassId(Long personId, Long theClassId) {
		return personCrudRepository.findCVByPersonIdAndClassId(personId, theClassId);
	}

	public CV findCVByPersonIdAndClassUri(Long personId, String theClassUri) {
		return personCrudRepository.findCVByPersonIdAndClassUri(personId, theClassUri);
	}

	public Person_Cv findPersonCVByPersonIdAndClassId(Long personId, Long theClassId) {
		return personCrudRepository.findPersonCVByPersonIdAndClassId(personId, theClassId);
	}

	public Person_Cv findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri) {
		return personCrudRepository.findPersonCVByPersonIdAndClassUri(personId, theClassUri);
	}

	public Person findPersonByNameAndEmail(String firstName, String familyName, String email) {
		return personCrudRepository.findPersonByNameAndEmail(firstName, familyName, email);
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

}
