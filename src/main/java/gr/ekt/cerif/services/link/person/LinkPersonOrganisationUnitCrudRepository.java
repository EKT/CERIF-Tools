package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonOrganisationUnitCrudRepository extends CrudRepository<Person_OrganisationUnit, Long> {

	List <Person_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	List <Person_OrganisationUnit> findByPerson(Person person);
	
	Person_OrganisationUnit findByOrganisationUnitAndPerson(OrganisationUnit organisationUnit,Person person);
	
	List<Person_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass);
	
}
