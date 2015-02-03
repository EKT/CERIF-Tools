/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsName;

/**
 * @author bonisv
 *
 */
@Component
public class MetricsNameRepositoryImpl implements MetricsNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MetricsNameRepositoryImpl.class);
	
	@Autowired
	private MetricsNameCrudRepository metricsNameCrudRepository;

	@Override
	public void delete(MetricsName entity) {
		metricsNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MetricsName> entities) {
		metricsNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MetricsName> save(Iterable<MetricsName> entities) {
		return metricsNameCrudRepository.save(entities);
	}

	@Override
	public MetricsName save(MetricsName entity) {
		return metricsNameCrudRepository.save(entity);
	}

	@Override
	public List<MetricsName> findByMetrics(Metrics metrics) {
		return metricsNameCrudRepository.findByMetrics(metrics);
	}

}
