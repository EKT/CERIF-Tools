package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Metrics;

/**
 * A repository for links between resultPublications and metrics.
 * 
 */
public interface LinkResultPublicationMetricsRepository {

	public void delete(ResultPublication_Metrics entity); 
	
	public void delete(Iterable<ResultPublication_Metrics> entities); 

	public Iterable<ResultPublication_Metrics> save(Iterable<ResultPublication_Metrics> entities); 
	
	public ResultPublication_Metrics save(ResultPublication_Metrics entity);
	
	List<ResultPublication_Metrics> findByMetrics(Metrics metrics);
	
	List<ResultPublication_Metrics> findByResultPublication(ResultPublication resultPublication);
	
}
