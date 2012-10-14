package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Medium_Indicator;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between mediums and indicators.
 * 
 */
@Component
public class LinkMediumIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Medium_Indicator entity) {
		if (entity.getMedium() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a medium and a indicator.");
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Medium_Indicator> entityList) {
		for (Medium_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
