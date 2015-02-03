package gr.ekt.cerif.services.link.personname;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.PersonName_Person;
import gr.ekt.cerif.features.additional.PersonName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonNamePersonCrudRepository extends CrudRepository<PersonName_Person, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PersonName_Person> findByPersonName(PersonName personName);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<PersonName_Person> findByPerson(Person person);

}
