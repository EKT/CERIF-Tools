package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonOrganisationUnitCrudRepository extends CrudRepository<Person_OrganisationUnit, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <Person_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <Person_OrganisationUnit> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_OrganisationUnit> findByOrganisationUnitAndPerson(OrganisationUnit organisationUnit,Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_OrganisationUnit> findByPersonAndTheClass(Person person, Class theClass);
	
}
