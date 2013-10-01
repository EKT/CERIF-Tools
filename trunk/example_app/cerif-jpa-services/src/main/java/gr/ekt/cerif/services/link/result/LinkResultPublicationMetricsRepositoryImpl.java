package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;

@Component
public class LinkResultPublicationMetricsRepositoryImpl implements
		LinkResultPublicationMetricsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationMetricsRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationMetricsCrudRepository linkResultPublicationMetricsCrudRepository;

	@Override
	public void delete(ResultPublication_Metrics entity) {
		linkResultPublicationMetricsCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Metrics> entities) {
		linkResultPublicationMetricsCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Metrics> save(
			Iterable<ResultPublication_Metrics> entities) {
		return linkResultPublicationMetricsCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Metrics save(ResultPublication_Metrics entity) {
		return linkResultPublicationMetricsCrudRepository.save(entity);
	}

}
