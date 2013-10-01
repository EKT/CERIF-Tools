package gr.ekt.cerif.services.link.funding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Funding_Funding;

@Component
public class LinkFundingFundingRepositoryImpl implements
		LinkFundingFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFundingFundingRepositoryImpl.class);
	
	@Autowired
	private LinkFundingFundingCrudRepository linkFundingFundingCrudRepository;

	@Override
	public void delete(Funding_Funding entity) {
		linkFundingFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Funding_Funding> entities) {
		linkFundingFundingCrudRepository.save(entities);
	}

	@Override
	public Iterable<Funding_Funding> save(Iterable<Funding_Funding> entities) {
		return linkFundingFundingCrudRepository.save(entities);
	}

	@Override
	public Funding_Funding save(Funding_Funding entity) {
		return linkFundingFundingCrudRepository.save(entity);
	}

}
