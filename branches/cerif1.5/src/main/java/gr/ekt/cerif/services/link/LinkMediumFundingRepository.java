package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Medium_Funding;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between mediums and fundings.
 * 
 */
@Component
public class LinkMediumFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Medium_Funding entity) {
		if (entity.getMedium() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a medium and a funding.");
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Medium_Funding> entityList) {
		for (Medium_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
