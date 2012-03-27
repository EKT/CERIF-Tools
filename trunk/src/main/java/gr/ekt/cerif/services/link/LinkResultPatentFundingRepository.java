package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPatent_Funding;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and fundings.
 * 
 */
@Component
public class LinkResultPatentFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(ResultPatent_Funding entity) {
		if (entity.getResultPatent() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a funding.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Funding> entityList) {
		for (ResultPatent_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
