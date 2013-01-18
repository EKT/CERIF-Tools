package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeCrudRepository extends CrudRepository<ClassScheme, Long> {

	ClassScheme findByUri(String uri);
	
}
