package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonOrganisationUnitRepositoryImpl implements LinkPersonOrganisationUnitRepository {

	@Autowired
	private LinkPersonOrganisationUnitCrudRepository linkPersonOrganisationUnitCrudRepository;
	
	public List<Person_OrganisationUnit> findByOrganisationUnit(OrganisationUnit organisationUnit) {
		return linkPersonOrganisationUnitCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	public List<Person_OrganisationUnit> findByPerson(Person person) {
		return linkPersonOrganisationUnitCrudRepository.findByPerson(person);
	}

	public Person_OrganisationUnit findByOrganisationUnitAndPerson(OrganisationUnit organisationUnit, Person person) {
		return linkPersonOrganisationUnitCrudRepository.findByOrganisationUnitAndPerson(organisationUnit, person);
	}

	public List<Person_OrganisationUnit> findByOrganisationUnitAndTheClass(OrganisationUnit organisationUnit, Class theClass) {
		return linkPersonOrganisationUnitCrudRepository.findByOrganisationUnitAndTheClass(organisationUnit, theClass);
	}

	@Transactional
	public void delete(Person_OrganisationUnit entity) {
		linkPersonOrganisationUnitCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<Person_OrganisationUnit> entities) {
		linkPersonOrganisationUnitCrudRepository.delete(entities);
		
	}

	@Transactional
	public Iterable<Person_OrganisationUnit> save(Iterable<Person_OrganisationUnit> entities) {
		return linkPersonOrganisationUnitCrudRepository.save(entities);
	}

	@Transactional
	public Person_OrganisationUnit save(Person_OrganisationUnit entity) {
		return linkPersonOrganisationUnitCrudRepository.save(entity);
	}

}
