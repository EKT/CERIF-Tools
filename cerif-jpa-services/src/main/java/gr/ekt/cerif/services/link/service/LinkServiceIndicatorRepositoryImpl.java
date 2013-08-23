package gr.ekt.cerif.services.link.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Service_Indicator;

@Component
public class LinkServiceIndicatorRepositoryImpl implements LinkServiceIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkServiceIndicatorCrudRepository linkServiceIndicatorCrudRepository;

	@Override
	public void delete(Service_Indicator entity) {
		linkServiceIndicatorCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Service_Indicator> entities) {
		linkServiceIndicatorCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Service_Indicator> save(Iterable<Service_Indicator> entities) {
		return linkServiceIndicatorCrudRepository.save(entities);
	}

	@Override
	public Service_Indicator save(Service_Indicator entity) {
		return linkServiceIndicatorCrudRepository.save(entity);
	}

}
