package gr.ekt.cerif.services.link.classscheme;

import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkClassSchemeClassCrudRepository extends CrudRepository<ClassScheme_Class, Long> {
	
	List<ClassScheme_Class> findByRelatedClassScheme(ClassScheme classScheme);
	
	List<ClassScheme_Class> findByRelatedClass(Class theClass);
	
	List<ClassScheme_Class> findByRelatedClassSchemeAndRelatedClassAndTheClass(ClassScheme classScheme, Class relatedClass, Class theClass);

}
