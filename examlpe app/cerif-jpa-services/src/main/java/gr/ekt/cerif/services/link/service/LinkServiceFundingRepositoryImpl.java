package gr.ekt.cerif.services.link.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Service_Funding;

@Component
public class LinkServiceFundingRepositoryImpl implements
		LinkServiceFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceFundingRepositoryImpl.class);
	
	@Autowired
	private LinkServiceFundingCrudRepository linkServiceFundingCrudRepository;

	@Override
	public void delete(Service_Funding entity) {
		linkServiceFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Funding> entities) {
		linkServiceFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Funding> save(Iterable<Service_Funding> entities) {
		return linkServiceFundingCrudRepository.save(entities);
	}

	@Override
	public Service_Funding save(Service_Funding entity) {
		return linkServiceFundingCrudRepository.save(entity);
	}

}
