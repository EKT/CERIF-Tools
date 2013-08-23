package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.features.additional.PersonName;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from Person p where p.id = ?1")
	Person findPersonById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select p from Person p join p.personNames pn where pn.familyNames = ?1")
	Person findPersonName(String familyNames);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select p	" +
			   "  from Person p    		 	" +
			   "  left join p.personNames pn		" +
			   " where pn.otherNames = ?1            ")
	Person findPersonByOtherName(String otherNames);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select				" +
			   "       pn.familyNames   " +
			   "  from Person p    						 	" +
			   "  join p.personNames pn		 				" +
			   " where p.id = ?1                            ")
	Object findPersonNameByPersonId(Long id);
	
}
