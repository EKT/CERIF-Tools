package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between indicators.
 * 
 */
@Component
public class LinkIndicatorIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Indicator_Indicator entity) {
		if (entity.getIndicator1() == null || entity.getIndicator2() == null) {
			throw new IllegalArgumentException("Please provide both indicators.");
		}
		if (entity.getIndicator1().getId() == null) {
			indicatorRepository.save(entity.getIndicator1());
		}
		if (entity.getIndicator2().getId() == null) {
			indicatorRepository.save(entity.getIndicator2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Indicator_Indicator> entityList) {
		for (Indicator_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
