package gr.ekt.cerif.services.semantics;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeCrudRepository extends CrudRepository<ClassScheme, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ClassScheme findByUri(String uri);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassScheme> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Page<ClassScheme> findAll(Pageable page);
	
}
