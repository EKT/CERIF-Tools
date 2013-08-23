package gr.ekt.cerif.services.link.funding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Funding_Indicator;

@Component
public class LinkFundingIndicatorRepositoryImpl implements
		LinkFundingIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFundingIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkFundingIndicatorCrudRepository linkFundingIndicatorCrudRepository;

	@Override
	public void delete(Funding_Indicator entity) {
		linkFundingIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Funding_Indicator> entities) {
		linkFundingIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Funding_Indicator> save(Iterable<Funding_Indicator> entities) {
		return linkFundingIndicatorCrudRepository.save(entities);
	}

	@Override
	public Funding_Indicator save(Funding_Indicator entity) {
		return linkFundingIndicatorCrudRepository.save(entity);
	}

}
