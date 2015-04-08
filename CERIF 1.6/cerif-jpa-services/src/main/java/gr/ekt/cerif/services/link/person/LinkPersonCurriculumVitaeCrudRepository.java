package gr.ekt.cerif.services.link.person;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_CurriculumVitae;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonCurriculumVitaeCrudRepository extends CrudRepository<Person_CurriculumVitae, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_CurriculumVitae> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_CurriculumVitae> findByCurriculumVitae(CurriculumVitae CurriculumVitae);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Person_CurriculumVitae> findByPersonAndTheClass(Person person, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_curriculumVitaes pcv							" +
			   "  join pcv.curriculumVitae cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.id=?2          ")
	Person_CurriculumVitae findPersonCVByPersonIdAndClassId(Long personId, Long theClassId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select pcv			   							" +
			   "  from Person p										" +
			   "  join p.persons_curriculumVitaes pcv							" +
			   "  join pcv.curriculumVitae cv									" +
			   "  join pcv.theClass c								" +
			   " where p.id = ?1 and c.uri=?2          ")
	Person_CurriculumVitae findPersonCVByPersonIdAndClassUri(Long personId, String theClassUri);
	
}
