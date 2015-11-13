package gr.ekt.cerif.services.link.indicator;

import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorClassCrudRepository extends CrudRepository<Indicator_Class, Long> {
	
	List<Indicator_Class> findByTheClass(Class theClass);

	List<Indicator_Class> findByIndicator(Indicator indicator);

}
