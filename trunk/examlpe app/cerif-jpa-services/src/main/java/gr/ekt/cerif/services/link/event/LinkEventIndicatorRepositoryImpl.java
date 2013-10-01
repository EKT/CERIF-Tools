package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Indicator;

@Component
public class LinkEventIndicatorRepositoryImpl implements
		LinkEventIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEventIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkEventIndicatorCrudRepository linkEventIndicatorCrudRepository;

	@Override
	public void delete(Event_Indicator entity) {
		linkEventIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event_Indicator> entities) {
		linkEventIndicatorCrudRepository.save(entities);
	}

	@Override
	public Iterable<Event_Indicator> save(Iterable<Event_Indicator> entities) {
		return linkEventIndicatorCrudRepository.save(entities);
	}

	@Override
	public Event_Indicator save(Event_Indicator entity) {
		return linkEventIndicatorCrudRepository.save(entity);
	}

}
