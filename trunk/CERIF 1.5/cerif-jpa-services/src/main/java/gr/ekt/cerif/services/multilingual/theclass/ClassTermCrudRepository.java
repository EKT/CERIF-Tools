package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassTermCrudRepository extends CrudRepository<ClassTerm, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ClassTerm findByTerm(String term);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassTerm> findByTheClass(Class theClass);
	
}
