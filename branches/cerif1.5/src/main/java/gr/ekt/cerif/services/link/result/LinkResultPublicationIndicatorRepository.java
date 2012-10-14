package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and indicators.
 * 
 */
@Component
public class LinkResultPublicationIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(ResultPublication_Indicator entity) {
		if (entity.getResultPublication() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a indicator.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Indicator> entityList) {
		for (ResultPublication_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
