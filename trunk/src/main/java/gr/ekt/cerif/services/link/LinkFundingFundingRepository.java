package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between fundings.
 * 
 */
@Component
public class LinkFundingFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Funding_Funding entity) {
		if (entity.getFunding1() == null || entity.getFunding2() == null) {
			throw new IllegalArgumentException("Please provide both fundings.");
		}
		if (entity.getFunding1().getId() == null) {
			fundingRepository.save(entity.getFunding1());
		}
		if (entity.getFunding2().getId() == null) {
			fundingRepository.save(entity.getFunding2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Funding_Funding> entityList) {
		for (Funding_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
