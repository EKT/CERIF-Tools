package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and indicators.
 * 
 */
@Component
public class LinkResultProductIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(ResultProduct_Indicator entity) {
		if (entity.getResultProduct() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a indicator.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Indicator> entityList) {
		for (ResultProduct_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
