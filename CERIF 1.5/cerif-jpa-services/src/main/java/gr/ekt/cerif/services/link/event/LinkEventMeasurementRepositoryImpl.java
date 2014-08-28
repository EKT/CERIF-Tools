package gr.ekt.cerif.services.link.event;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Event_Measurement;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.Measurement;

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

	@Override
	public List<Event_Measurement> findByEvent(Event event) {
		return linkEventMeasurementCrudRepository.findByEvent(event);
	}

	@Override
	public List<Event_Measurement> findByMeasurement(Measurement mkeasurement) {
		return linkEventMeasurementCrudRepository.findByMeasurement(mkeasurement);
	}

}
