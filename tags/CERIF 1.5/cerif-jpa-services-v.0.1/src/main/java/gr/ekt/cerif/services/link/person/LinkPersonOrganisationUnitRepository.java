package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between persons and organisationUnits.
 * 
 */

public interface LinkPersonOrganisationUnitRepository {

	List <Person_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	List <Person_OrganisationUnit> findByPerson(Person person);
	
	List<Person_OrganisationUnit> findByOrganisationUnitAndPerson(OrganisationUnit organisationUnit,Person person);
	
	List<Person_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass);
	
	List <Person_OrganisationUnit> findByPersonAndTheClass(Person person, Class theClass);
	
	void delete(Person_OrganisationUnit entity);
	
	void delete(Iterable<Person_OrganisationUnit> entities);
	
	Iterable<Person_OrganisationUnit> save(Iterable<Person_OrganisationUnit> entities);
	
	Person_OrganisationUnit save(Person_OrganisationUnit entity);
	
}
