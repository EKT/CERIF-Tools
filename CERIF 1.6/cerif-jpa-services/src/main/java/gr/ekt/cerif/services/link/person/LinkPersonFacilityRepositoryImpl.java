package gr.ekt.cerif.services.link.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.person.Person_Facility;

@Component
public class LinkPersonFacilityRepositoryImpl implements
		LinkPersonFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonFacilityRepositoryImpl.class);
	
	@Autowired
	private LinkPersonFacilityCrudRepository linkPersonFacilityCrudRepository;

	@Override
	public void delete(Person_Facility entity) {
		linkPersonFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Facility> entities) {
		linkPersonFacilityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Facility> save(Iterable<Person_Facility> entities) {
		return linkPersonFacilityCrudRepository.save(entities);
	}

	@Override
	public Person_Facility save(Person_Facility entity) {
		return linkPersonFacilityCrudRepository.save(entity);
	}

	@Override
	public List<Person_Facility> findByFacility(Facility facility) {
		return linkPersonFacilityCrudRepository.findByFacility(facility);
	}

	@Override
	public List<Person_Facility> findByPerson(Person person) {
		return linkPersonFacilityCrudRepository.findByPerson(person);
	}

}
