package gr.ekt.cerif.services.link.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Measurement;

@Component
public class LinkEventMeasurementRepositoryImpl implements
		LinkEventMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkEventMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkEventMeasurementCrudRepository linkEventMeasurementCrudRepository;

	@Override
	public void delete(Event_Measurement entity) {
		linkEventMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Event_Measurement> entities) {
		linkEventMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Event_Measurement> save(Iterable<Event_Measurement> entities) {
		return linkEventMeasurementCrudRepository.save(entities);
	}

	@Override
	public Event_Measurement save(Event_Measurement entity) {
		return linkEventMeasurementCrudRepository.save(entity);
	}

}
