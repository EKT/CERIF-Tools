package gr.ekt.cerif.services.link.metrics;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMetricsClassCrudRepository extends CrudRepository<Metrics_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Metrics_Class> findByMetrics(Metrics metrics);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Metrics_Class> findBytheClass(Class theClass);

}
