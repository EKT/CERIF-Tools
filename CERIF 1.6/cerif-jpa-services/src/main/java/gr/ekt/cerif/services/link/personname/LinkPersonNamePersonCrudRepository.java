package gr.ekt.cerif.services.link.personname;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkPersonNamePersonCrudRepository extends CrudRepository<PersonName_Person, Long> {
	
	public List<PersonName_Person> findByPersonName(PersonName personName);
	
	public List<PersonName_Person> findByPerson(Person person);

}
