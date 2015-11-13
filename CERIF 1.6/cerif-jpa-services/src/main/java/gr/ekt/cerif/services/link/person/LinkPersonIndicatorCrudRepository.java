package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonIndicatorCrudRepository extends CrudRepository<Person_Indicator, Long> {
	
	List<Person_Indicator> findByIndicator(Indicator indicator);
	
	List<Person_Indicator> findByPerson(Person person);

}
