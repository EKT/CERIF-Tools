package gr.ekt.cerif.services.link.metrics;

import gr.ekt.cerif.entities.link.Metrics_Class;

/**
 * A repository for links between metricss and classes.
 * 
 */
public interface LinkMetricsClassRepository {

	public void delete(Metrics_Class entity); 
	
	public void delete(Iterable<Metrics_Class> entities); 

	public Iterable<Metrics_Class> save(Iterable<Metrics_Class> entities); 
	
	public Metrics_Class save(Metrics_Class entity);
	
}
