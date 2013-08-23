/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Metrics;

/**
 * @author bonisv
 *
 */
@Component
public class MetricsRepositoryImpl implements MetricsRepository {

	private static final Logger log = LoggerFactory.getLogger(MetricsRepositoryImpl.class);

	@Autowired
	private MetricsCrudRepository metricsCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MetricsRepository#delete(gr.ekt.cerif.entities.second.Metrics)
	 */
	@Override
	public void delete(Metrics entity) {
		metricsCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MetricsRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Metrics> entities) {
		metricsCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MetricsRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Metrics> save(Iterable<Metrics> entities) {
		return metricsCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MetricsRepository#save(gr.ekt.cerif.entities.second.Metrics)
	 */
	@Override
	public Metrics save(Metrics entity) {
		return metricsCrudRepository.save(entity);
	}

}
