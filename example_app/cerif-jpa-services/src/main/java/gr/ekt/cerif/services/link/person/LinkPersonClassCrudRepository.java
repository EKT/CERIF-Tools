package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkPersonClassCrudRepository extends CrudRepository<Person_Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "Select pc from gr.ekt.cerif.entities.link.person.Person_Class pc where pc.id=?1 ")
	Person_Class findById(Long id);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "Select pc from gr.ekt.cerif.entities.link.person.Person_Class pc join pc.person p join pc.theClass c join c.scheme s where p=?1 and c=?2 and s=?3")
	Person_Class findByPersonClassSchemeAndClass(Person person, Class theClass, ClassScheme scheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "Select pc from gr.ekt.cerif.entities.link.person.Person_Class pc join pc.person p join pc.theClass c join c.scheme s where p=?1 and s=?2")
	List<Person_Class> findByPersonClassScheme(Person person, ClassScheme scheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "Select pc from gr.ekt.cerif.entities.link.person.Person_Class pc left join pc.person p left join pc.theClass c left join c.scheme s where p.id=?1 and s.uri=?2")
	List<Person_Class> findByPersonIdClassSchemeUri(Long personId, String schemeUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List <Person_Class> findByPerson(Person person);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Person_Class findByPersonAndTheClass(Person person, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select pc from gr.ekt.cerif.entities.link.person.Person_Class " +
			"pc join pc.person p 	" +
			"join pc.theClass c 	" +
			"where p.id=?1 and c.id=?2")
	Person_Class findByPersonIdAndClassId(Long personId, Long classId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select pc from gr.ekt.cerif.entities.link.person.Person_Class " +
			"pc left join pc.person p 	" +
			"left join pc.theClass c 	" +
			"where p.id=?1 and c.uri=?2")
	Person_Class findByPersonIdAndClassUri(Long personId, String classUri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  left join p.classes ppc							" +
			   "  left join ppc.theClass c							" +
			   "  left join c.scheme cs							" +
			   " where p.id = ?1 and cs.uri='userstates' ")
	Person_Class findPersonUserState(Long personId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  join p.classes ppc							" +
			   "  join ppc.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.id=?2          ")
	Person_Class findPersClassByPersonIdAndSchemeId(Long personId, Long schemeId);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value = "select ppc			   							" +
			   "  from Person p										" +
			   "  join p.classes ppc							" +
			   "  join ppc.theClass c							" +
			   "  join c.scheme s								" +
			   " where p.id = ?1 and s.uri=?2          ")
	Person_Class findPersClassByPersonIdAndSchemeUri(Long personId, String schemeUri);
}
