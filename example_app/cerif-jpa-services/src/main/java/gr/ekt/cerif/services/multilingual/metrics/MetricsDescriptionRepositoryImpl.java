/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.MetricsDescription;

/**
 * @author bonisv
 *
 */
@Component
public class MetricsDescriptionRepositoryImpl implements MetricsDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MetricsDescriptionRepositoryImpl.class);
	
	@Autowired
	private MetricsDescriptionCrudRepository metricsDescriptionCrudRepository;

	@Override
	public void delete(MetricsDescription entity) {
		metricsDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MetricsDescription> entities) {
		metricsDescriptionCrudRepository.save(entities);
	}

	@Override
	public Iterable<MetricsDescription> save(Iterable<MetricsDescription> entities) {
		return metricsDescriptionCrudRepository.save(entities);
	}

	@Override
	public MetricsDescription save(MetricsDescription entity) {
		return metricsDescriptionCrudRepository.save(entity);
	}

}
