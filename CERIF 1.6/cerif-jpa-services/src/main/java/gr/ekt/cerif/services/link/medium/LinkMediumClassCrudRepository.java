package gr.ekt.cerif.services.link.medium;

import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMediumClassCrudRepository extends CrudRepository<Medium_Class, Long> {
	
	List<Medium_Class> findByMedium(Medium medium);
	
	List<Medium_Class> findBytheClass(Class theClass);

}
