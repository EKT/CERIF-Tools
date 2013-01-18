package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.features.semantics.Class;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between classs and classes.
 * 
 */
public interface LinkClassClassRepository extends CrudRepository<Class_Class, Long>{
		
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Query("Select cc from gr.ekt.cerif.entities.link.Class_Class cc where cc.theClass1=?1 and cc.theClass2=?2")	
	Class_Class findBytheClass1AndtheClass2(Class theClass1, Class theClass2);
}

