package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonMeasurementCrudRepository extends CrudRepository<Person_Measurement, Long> {
	
	List<Person_Measurement> findByPerson(Person person);
	
	List<Person_Measurement> findByMeasurement(Measurement measurement);

}
