package gr.ekt.cerif.services.link.funding;

import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFundingClassRepositoryImpl implements LinkFundingClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFundingClassRepositoryImpl.class);

	@Autowired
	private LinkFundingClassCrudRepository linkFundingClassCrudRepository;
	
	@Transactional
	public Funding_Class save(Funding_Class entity) {
		return linkFundingClassCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<? extends Funding_Class> save(Iterable<? extends Funding_Class> entities) {
		return linkFundingClassCrudRepository.save(entities);
	}
	
	@Override
	public List<Funding_Class> findByTheClass(Class theClass) {
		return linkFundingClassCrudRepository.findByTheClass(theClass);
	}
	
	@Override
	public List<Funding_Class> findByTheClassAndFunding(Class theClass, Funding funding) {
		return linkFundingClassCrudRepository.findByTheClassAndFunding(theClass, funding);
	}

	@Transactional
	public void delete(Funding_Class entity) {
		linkFundingClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Funding_Class> entities) {
		linkFundingClassCrudRepository.delete(entities);		
	}

	@Override
	public List<Funding_Class> findByFunding(Funding funding) {
		return linkFundingClassCrudRepository.findByFunding(funding);
	}
	
}
