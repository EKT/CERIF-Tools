package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and classes.
 * 
 */

public interface LinkPersonClassRepository  extends CrudRepository<Person_Class, Long>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "Select pc from gr.ekt.cerif.entities.link.person.Person_Class pc join pc.person p join pc.theClass c join c.scheme s where p=?1 and c=?2 and s=?3")
	Person_Class findByPersonClassSchemeAndClass(Person person, Class theClass, ClassScheme scheme);
	
	List <Person_Class> findByPerson(Person person);
	
	Person_Class findByPersonAndTheClass(Person person, Class theClass);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query(value= "select pc from gr.ekt.cerif.entities.link.person.Person_Class " +
			"pc join pc.person p 	" +
			"join pc.theClass c 	" +
			"where p.id=?1 and c.id=?2")
	Person_Class findByPersonIdAndClassId(Long personId, Long classId);

}
