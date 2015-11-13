package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.person.Person_Facility;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonFacilityCrudRepository extends CrudRepository<Person_Facility, Long> {
	
	List<Person_Facility> findByFacility(Facility facility);
	
	List<Person_Facility> findByPerson(Person person);

}
