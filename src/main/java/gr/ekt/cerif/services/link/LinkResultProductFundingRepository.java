package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and fundings.
 * 
 */
@Component
public class LinkResultProductFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(ResultProduct_Funding entity) {
		if (entity.getResultProduct() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a funding.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Funding> entityList) {
		for (ResultProduct_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
