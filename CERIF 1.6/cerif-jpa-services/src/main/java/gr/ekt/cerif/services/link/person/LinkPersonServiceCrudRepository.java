package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.person.Person_Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonServiceCrudRepository extends CrudRepository<Person_Service, Long> {
	
	List<Person_Service> findByService(Service service);
	
	List<Person_Service> findByPerson(Person person);

}
