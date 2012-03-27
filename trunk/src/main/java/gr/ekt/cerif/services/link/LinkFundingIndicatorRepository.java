package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Indicator;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and indicators.
 * 
 */
@Component
public class LinkFundingIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Funding_Indicator entity) {
		if (entity.getFunding() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a funding and a indicator.");
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Funding_Indicator> entityList) {
		for (Funding_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
