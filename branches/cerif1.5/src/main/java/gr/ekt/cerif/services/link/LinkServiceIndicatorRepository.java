package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Indicator;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between services and indicators.
 * 
 */
@Component
public class LinkServiceIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Service_Indicator entity) {
		if (entity.getService() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a service and a indicator.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Indicator> entityList) {
		for (Service_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
