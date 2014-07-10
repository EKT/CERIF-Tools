package gr.ekt.cerif.services.link.classscheme;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkClassSchemeClassCrudRepository extends CrudRepository<ClassScheme_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassScheme_Class> findByRelatedClassScheme(ClassScheme classScheme);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ClassScheme_Class> findByRelatedClass(Class theClass);

}
