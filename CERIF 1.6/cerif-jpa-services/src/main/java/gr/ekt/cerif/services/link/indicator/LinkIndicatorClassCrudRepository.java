package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkIndicatorClassCrudRepository extends CrudRepository<Indicator_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Class> findByTheClass(Class theClass);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Indicator_Class> findByIndicator(Indicator indicator);

}
