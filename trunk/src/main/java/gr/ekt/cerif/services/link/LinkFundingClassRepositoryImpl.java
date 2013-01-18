package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFundingClassRepositoryImpl implements LinkFundingClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private LinkFundingClassCrudRepository linkFundingClassCrudRepository;
	
	@Transactional
	public Funding_Class save(Funding_Class entity) {
		if (entity.getFunding() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a funding and a class.");
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<? extends Funding_Class> save(Iterable<? extends Funding_Class> entities) {
		for (Funding_Class entity : entities) {
			save(entity);
		}
		return entities;
	}

	public List<Funding_Class> findByTheClass(Class theClass) {
		return linkFundingClassCrudRepository.findByTheClass(theClass);
	}

	public List<Funding_Class> findByTheClassAndFunding(Class theClass, Funding funding) {
		return linkFundingClassCrudRepository.findByTheClassAndFunding(theClass, funding);
	}

	@Transactional
	public void delete(Funding_Class entity) {
		linkFundingClassCrudRepository.delete(entity);
	}
	
}
