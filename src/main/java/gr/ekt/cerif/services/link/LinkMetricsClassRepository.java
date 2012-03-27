package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Metrics_Class;
import gr.ekt.cerif.services.second.MetricsRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between metricss and classes.
 * 
 */
@Component
public class LinkMetricsClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MetricsRepository metricsRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Metrics_Class entity) {
		if (entity.getMetrics() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a metrics and a class.");
		}
		if (entity.getMetrics().getId() == null) {
			metricsRepository.save(entity.getMetrics());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Metrics_Class> entityList) {
		for (Metrics_Class entity : entityList) {
			save(entity);
		}
	}
	
}
