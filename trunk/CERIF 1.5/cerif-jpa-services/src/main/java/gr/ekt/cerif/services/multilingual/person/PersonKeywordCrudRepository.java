package gr.ekt.cerif.services.multilingual.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.multilingual.PersonKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PersonKeywordCrudRepository extends CrudRepository<PersonKeyword, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<PersonKeyword> findByPerson(Person person);

}
