/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.features.multilingual.MetricsDescription;
import gr.ekt.cerif.features.multilingual.MetricsKeyword;
import gr.ekt.cerif.features.multilingual.MetricsName;
import gr.ekt.cerif.services.link.metrics.LinkMetricsClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMetricsRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsDescriptionRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsKeywordRepository;
import gr.ekt.cerif.services.multilingual.metrics.MetricsNameRepository;

/**
 * @author bonisv
 *
 */
@Component
public class MetricsRepositoryImpl implements MetricsRepository {

	private static final Logger log = LoggerFactory.getLogger(MetricsRepositoryImpl.class);

	@Autowired
	private MetricsCrudRepository metricsCrudRepository;
	
	@Autowired
	private LinkResultPublicationMetricsRepository linkResultPublicationMetricsRepository;
	
	@Autowired
	private MetricsNameRepository metricsNameRepository;
	
	@Autowired
	private MetricsKeywordRepository metricsKeywordRepository;
	
	@Autowired
	private MetricsDescriptionRepository metricsDescriptionRepository;
	
	@Autowired
	private LinkMetricsClassRepository linkMetricsClassRepository;
	
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MetricsRepository#delete(gr.ekt.cerif.entities.second.Metrics)
	 */
	@Override
	@Transactional
	public void delete(Metrics entity) {
		List<MetricsName> metrname = metricsNameRepository.findByMetrics(entity);
		if (metrname != null) metricsNameRepository.delete(metrname);
		entity.setMetricsNames(null);
		
		List<MetricsKeyword> metrkey = metricsKeywordRepository.findByMetrics(entity);
		if (metrkey != null) metricsKeywordRepository.delete(metrkey);
		entity.setMetricsKeywords(null);
		
		List<MetricsDescription> metrdescr = metricsDescriptionRepository.findByMetrics(entity);
		if (metrdescr != null) metricsDescriptionRepository.delete(metrdescr);
		entity.setMetricsDescriptions(null);
		
		List<ResultPublication_Metrics> respublmetr = linkResultPublicationMetricsRepository.findByMetrics(entity);
		if (respublmetr != null) linkResultPublicationMetricsRepository.delete(respublmetr);
		entity.setResultPublications_metrics(null);
		
		List<Metrics_Class> metrcl = linkMetricsClassRepository.findByMetrics(entity);
		if (metrcl != null) linkMetricsClassRepository.delete(metrcl);
		entity.setMetrics_classes(null);
		
		entity = metricsCrudRepository.save(entity);
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
