package gr.ekt.cerif.services.link.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonCvCrudRepository extends CrudRepository<Person_Cv, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_Cv> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_Cv> findByPersonAndTheClass(Person person, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.id=?2          ")
	Person_Cv findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_cvs pcv							" +
			   "  join pcv.cv cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.uri=?2          ")
	Person_Cv findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
}
