package gr.ekt.cerif.services.multilingual.classscheme;

import javax.persistence.QueryHint;

import gr.ekt.cerif.features.multilingual.ClassSchemeName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface ClassSchemeNameCrudRepository extends CrudRepository<ClassSchemeName, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	ClassSchemeName findByName(String name);
	
}
