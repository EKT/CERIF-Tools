package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between fundings and classes.
 * 
 */
@Component
public class LinkFundingClassServiceImpl implements LinkFundingClassService {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Override
	@Transactional
	public void save(Funding_Class entity) {
		if (entity.getFunding() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a funding and a class.");
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	

	@Override
	public void save(List<? extends Funding_Class> entities) {
		for (Funding_Class entity : entities) {
			save(entity);
		}
		
	}
	
}
