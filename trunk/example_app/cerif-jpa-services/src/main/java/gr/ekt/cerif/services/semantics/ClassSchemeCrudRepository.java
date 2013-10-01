package gr.ekt.cerif.services.semantics;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeCrudRepository extends CrudRepository<ClassScheme, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ClassScheme findByUri(String uri);
	
}
