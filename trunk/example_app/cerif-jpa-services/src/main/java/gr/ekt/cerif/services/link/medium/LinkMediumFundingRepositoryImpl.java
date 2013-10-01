package gr.ekt.cerif.services.link.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Medium_Funding;

@Component
public class LinkMediumFundingRepositoryImpl implements
		LinkMediumFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMediumFundingRepositoryImpl.class);
	
	@Autowired
	private LinkMediumFundingCrudRepository linkMediumFundingCrudRepository;

	@Override
	public void delete(Medium_Funding entity) {
		linkMediumFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Medium_Funding> entities) {
		linkMediumFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Medium_Funding> save(Iterable<Medium_Funding> entities) {
		return linkMediumFundingCrudRepository.save(entities);
	}

	@Override
	public Medium_Funding save(Medium_Funding entity) {
		return linkMediumFundingCrudRepository.save(entity);
	}

}
