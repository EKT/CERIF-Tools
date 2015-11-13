package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonFundingCrudRepository extends CrudRepository<Person_Funding, Long> {
	
	List<Person_Funding> findByFunding(Funding funding);
	
	List<Person_Funding> findByPerson(Person person);

}
