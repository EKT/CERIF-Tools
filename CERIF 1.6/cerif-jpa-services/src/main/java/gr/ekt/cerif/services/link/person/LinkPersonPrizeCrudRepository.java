package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.second.Prize;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonPrizeCrudRepository extends CrudRepository<Person_Prize, Long> {
	
	List<Person_Prize> findByPerson(Person person);
	
	List<Person_Prize> findByPrize(Prize prize);

}
