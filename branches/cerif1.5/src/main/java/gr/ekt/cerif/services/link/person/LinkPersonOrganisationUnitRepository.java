package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Class;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and organisationUnits.
 * 
 */

public interface LinkPersonOrganisationUnitRepository   extends CrudRepository<Person_OrganisationUnit, Long> {

	List <Person_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	List <Person_OrganisationUnit> findByPerson(Person person);
	Person_OrganisationUnit findByOrganisationUnitAndPerson(OrganisationUnit organisationUnit,Person person);
}
