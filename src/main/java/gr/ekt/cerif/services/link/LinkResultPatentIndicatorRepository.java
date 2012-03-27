package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and indicators.
 * 
 */
@Component
public class LinkResultPatentIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(ResultPatent_Indicator entity) {
		if (entity.getResultPatent() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a indicator.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Indicator> entityList) {
		for (ResultPatent_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
