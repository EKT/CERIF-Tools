package gr.ekt.cerif.services.link.metrics;

import java.util.List;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between metricss and classes.
 * 
 */
public interface LinkMetricsClassRepository {

	public void delete(Metrics_Class entity); 
	
	public void delete(Iterable<Metrics_Class> entities); 

	public Iterable<Metrics_Class> save(Iterable<Metrics_Class> entities); 
	
	public Metrics_Class save(Metrics_Class entity);
	
	List<Metrics_Class> findByMetrics(Metrics metrics);
	
	List<Metrics_Class> findBytheClass(Class theClass);
	
}
