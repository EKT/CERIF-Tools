package gr.ekt.cerif.services.link.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Metrics_Class;

@Component
public class LinkMetricsClassRepositoryImpl implements
		LinkMetricsClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMetricsClassRepositoryImpl.class);
	
	@Autowired
	private LinkMetricsClassCrudRepository linkMetricsClassCrudRepository;

	@Override
	public void delete(Metrics_Class entity) {
		linkMetricsClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Metrics_Class> entities) {
		linkMetricsClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Metrics_Class> save(Iterable<Metrics_Class> entities) {
		return linkMetricsClassCrudRepository.save(entities);
	}

	@Override
	public Metrics_Class save(Metrics_Class entity) {
		return linkMetricsClassCrudRepository.save(entity);
	}

}
