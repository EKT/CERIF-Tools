package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Funding;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and fundings.
 * 
 */
@Component
public class LinkResultPublicationFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(ResultPublication_Funding entity) {
		if (entity.getResultPublication() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a funding.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Funding> entityList) {
		for (ResultPublication_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
