package gr.ekt.cerif.services.link.funding;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Funding_Funding;
import gr.ekt.cerif.entities.second.Funding;

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
		linkFundingFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Funding_Funding> save(Iterable<Funding_Funding> entities) {
		return linkFundingFundingCrudRepository.save(entities);
	}

	@Override
	public Funding_Funding save(Funding_Funding entity) {
		return linkFundingFundingCrudRepository.save(entity);
	}

	@Override
	public List<Funding_Funding> findByFunding1(Funding funding) {
		return linkFundingFundingCrudRepository.findByFunding1(funding);
	}

	@Override
	public List<Funding_Funding> findByFunding2(Funding funding) {
		return linkFundingFundingCrudRepository.findByFunding2(funding);
	}

	@Override
	public Funding_Funding findByFunding1AndFunding2(Funding funding1,
			Funding funding2) {
		return linkFundingFundingCrudRepository.findByFunding1AndFunding2(funding1, funding2);
	}

}
