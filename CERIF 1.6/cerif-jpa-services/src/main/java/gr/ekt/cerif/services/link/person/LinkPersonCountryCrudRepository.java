package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Country;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonCountryCrudRepository extends CrudRepository<Person_Country, Long> {
	
	List <Person_Country> findByPerson(Person person);

}
