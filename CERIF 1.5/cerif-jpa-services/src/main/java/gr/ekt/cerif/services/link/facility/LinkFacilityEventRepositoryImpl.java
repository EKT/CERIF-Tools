package gr.ekt.cerif.services.link.facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Event;
import gr.ekt.cerif.entities.second.Event;

@Component
public class LinkFacilityEventRepositoryImpl implements
		LinkFacilityEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityEventRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityEventCrudRepository linkFacilityEventCrudRepository;

	@Override
	public void delete(Facility_Event entity) {
		linkFacilityEventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Event> entities) {
		linkFacilityEventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Facility_Event> save(Iterable<Facility_Event> entities) {
		return linkFacilityEventCrudRepository.save(entities);
	}

	@Override
	public Facility_Event save(Facility_Event entity) {
		return linkFacilityEventCrudRepository.save(entity);
	}

	@Override
	public List<Facility_Event> findByFacility(Facility facility) {
		return linkFacilityEventCrudRepository.findByFacility(facility);
	}

	@Override
	public List<Facility_Event> findByEvent(Event event) {
		return linkFacilityEventCrudRepository.findByEvent(event);
	}

}
