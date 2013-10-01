/**
 * 
 */
package gr.ekt.cerif.services.multilingual.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.MetricsKeyword;

/**
 * @author bonisv
 *
 */
@Component
public class MetricsKeywordRepositoryImpl implements MetricsKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MetricsKeywordRepositoryImpl.class);
	
	@Autowired
	private MetricsKeywordCrudRepository metricsKeywordCrudRepository;

	@Override
	public void delete(MetricsKeyword entity) {
		metricsKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MetricsKeyword> entities) {
		metricsKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MetricsKeyword> save(Iterable<MetricsKeyword> entities) {
		return metricsKeywordCrudRepository.save(entities);
	}

	@Override
	public MetricsKeyword save(MetricsKeyword entity) {
		return metricsKeywordCrudRepository.save(entity);
	}

}
