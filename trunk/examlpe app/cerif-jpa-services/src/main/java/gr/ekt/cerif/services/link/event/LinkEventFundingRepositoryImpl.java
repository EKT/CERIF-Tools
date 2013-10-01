package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Funding;

@Component
public class LinkEventFundingRepositoryImpl implements
		LinkEventFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEventFundingRepositoryImpl.class);
	
	@Autowired
	private LinkEventFundingCrudRepository linkEventFundingCrudRepository;

	@Override
	public void delete(Event_Funding entity) {
		linkEventFundingCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event_Funding> entities) {
		linkEventFundingCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event_Funding> save(Iterable<Event_Funding> entities) {
		return linkEventFundingCrudRepository.save(entities);
	}

	@Override
	public Event_Funding save(Event_Funding entity) {
		return linkEventFundingCrudRepository.save(entity);
	}

}
