package gr.ekt.cerif.services.multilingual.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonKeyword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonKeywordCrudRepository extends CrudRepository<PersonKeyword, Long>  {
	
	List<PersonKeyword> findByPerson(Person person);

}
