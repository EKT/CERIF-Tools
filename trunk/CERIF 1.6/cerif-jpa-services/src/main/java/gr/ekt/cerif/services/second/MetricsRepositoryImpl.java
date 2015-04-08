/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Metrics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

	@Override
	public List<Metrics> findAll() {
		return metricsCrudRepository.findAll();
	}

	@Override
	public Page<Metrics> findAll(Pageable page) {
		return metricsCrudRepository.findAll(page);
	}

	@Override
	public Metrics findById(Long id) {
		return metricsCrudRepository.findById(id);
	}

	@Override
	public List<Metrics> findByUri(String uri) {
		return metricsCrudRepository.findByUri(uri);
	}

	@Override
	public Metrics findByUuid(String uuid) {
		return metricsCrudRepository.findByUuid(uuid);
	}

}
