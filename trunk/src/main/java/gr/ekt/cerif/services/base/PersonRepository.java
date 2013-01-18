/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.PersonList;
import gr.ekt.cerif.entities.base.PersonView;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.person.Person_Person;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.additional.PersonName;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassView;

import java.util.List;

/**
 * A repository for persons.
 * 
 */
public interface PersonRepository {

	Person findPersonById(Long id);
	
	Person findPersonName(String familyNames);
	
	Person findPersonByOtherName(String otherNames);
	
	Object findPersonNameByPersonId(Long id);
	
	PersonName findPersonNamesByPersonId(Long id);
	
	List<PersonView> findLastEditorNamesByResPubId(Long id);
	
	List<Long> findPersonIdsByResPubIdAndLinkClass(Long id, String classUri);
	
	List<PersonName> findPersonNamesByResPubIdAndLinkClass(Long id, String classUri);
	
	List<PersonList> findByProjectId(Long id);
	
	List<PersonList> findByProjPersClassSchemeAndProjPersClassAndProjectId(String schemeUri, String classUri, Long id);
	
	List<PersonList> findByOrgUnitClassSchemeAndOrgUnitClass(String schemeUri, String classUri);
	
	List<PersonList> findByOrgUnitClassScheme(String schemeUri);
	
	List<PersonView> findByOrgUnitId(Long id);
	
	List<PersonView> findByOrgUnitIdAndPersOrgRole(Long id, String role);
	
	List<PersonList> findByPolicyType(String PolicyType);
	
	List<PersonList> findAllPersons();
	
	List<PersonList> findAllByStakeholderCat(String stakeholderCat);
	
	List<PersonList> findAllProgrammeCommittee();
	
	List<PersonList> findAllByStakeholderCat(String stakeholderCat, String personCat);
	
	List<PersonList> findAllByPersonCat(String personCat);
	
	List<PersonList> findAllWithRegistration();
	
	List<PersonList> findAllByRIPolicyBody(String policyBody);
	
	List<String> findStakeholderListByPersonId(Long id);
	
	List<String> findClassListByPersonIdAndSchemeId(Long id, Long schemeId);
	
	List<String> findClassListByPersonIdAndSchemeUri(Long id, String schemeUri);
	
	List<ClassView> findClassViewListByPersonIdAndSchemeId(Long id, Long schemeId);
	
	List<String> findPolicyBodiesByPersonId(Long id);
	
	List<Object[]> countByStakeholderCat();
	
	List<Object[]> countRINCPNetwrokMembers();
	
	List<Object[]> countRIContactPerson();
	
	List<Object[]> countByRIPolicyBody();
	
	List<PersonView> findByPersonClassSchemeAndId(String PersonClass, Long id);
	
	PersonView findByPersonId2(Long id);
	
	PersonView findByPersonId(Long id);
	
	String findOrgTypeByPersonIdAndScheme(Long id,String schemeUri);
	
	byte[] findCVByPersonIdAndClassId(Long id, String uri);
	
	List<PersonList> findByPolicySuperType(String PolicySuperType);
	
	List<PersonList> findAllWithCountry();
	
	List<PersonList> findAllNCPWithCountry();
	
	PersonList findAllNoNCPWithCountryByRoleAndOrg(String role, Long orgId);
	
	List<PersonList> findAllWithRIPBRole();
	
	String findRIPolicyBodyRoleByPersId(Long id);
	
	List<PersonList> findAllPersonsWithOrgNoRIPBRoleAndWithCountry();

	List<PersonList> findAllPersonsWithProjects();
	
	Person findByProjectAndtheClass(Project project, Class theClass);
	
	PersonName findPersNameByPersonId(Long personId);
	
	ElectronicAddress findElectronicAddressByPersonId(Long personId);
	
	PostalAddress findPostalAddressByPersonId(Long personId);
	
	Person_Class findByPersonIdAndClassUri(Long personId, String classUri);
	
	Person_Class findPersonUserState(Long personId);
	
	Person_OrganisationUnit findByPersonIdAndSchemeId(Long personId, Long schemeId);
	
	Person_OrganisationUnit findByPersonIdAndSchemeUri(Long personId, String schemeUri);
	
	Person_Class findPersClassByPersonIdAndSchemeId(Long personId, Long schemeId);

	Person_Class findPersClassByPersonIdAndSchemeUri(Long personId, String schemeUri);
	
	Person_ResultPublication isResultPublicationFavourite(Long id, String username);
	
	Person_OrganisationUnit isOrganisationUnitFavourite(Long id, String username);
	
	Person_Person isPersonFavourite(Long id, String username);
	
	List<PersonList> findFavouritePersons(Long id);

	CV findCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	CV findCVByPersonIdAndClassUri(Long personId, String theClassUri);

	Person_Cv findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	Person_Cv findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
	Person findPersonByNameAndEmail(String firstName, String familyName, String email);
	
	void delete(Person entity);
	
	Iterable<Person> save(Iterable<Person> entities);
	
	Person save(Person entity);
	
}
