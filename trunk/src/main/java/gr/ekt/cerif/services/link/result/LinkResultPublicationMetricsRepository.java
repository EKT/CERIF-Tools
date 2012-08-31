package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Metrics;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.MetricsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and metrics.
 * 
 */
@Component
public class LinkResultPublicationMetricsRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private MetricsRepository metricsRepository;
	
	@Transactional
	public void save(ResultPublication_Metrics entity) {
		if (entity.getResultPublication() == null || entity.getMetrics() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a metrics.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getMetrics().getId() == null) {
			metricsRepository.save(entity.getMetrics());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Metrics> entityList) {
		for (ResultPublication_Metrics entity : entityList) {
			save(entity);
		}
	}
	
}
