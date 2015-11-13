package gr.ekt.cerif.services.link.metrics;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMetricsClassCrudRepository extends CrudRepository<Metrics_Class, Long> {
	
	List<Metrics_Class> findByMetrics(Metrics metrics);
	
	List<Metrics_Class> findBytheClass(Class theClass);

}
