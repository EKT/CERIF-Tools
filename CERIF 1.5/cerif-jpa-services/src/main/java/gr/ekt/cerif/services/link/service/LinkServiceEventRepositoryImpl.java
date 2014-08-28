package gr.ekt.cerif.services.link.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Event;
import gr.ekt.cerif.entities.second.Event;

@Component
public class LinkServiceEventRepositoryImpl implements
		LinkServiceEventRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceEventRepositoryImpl.class);
	
	@Autowired
	private LinkServiceEventCrudRepository linkServiceEventCrudRepository;

	@Override
	public void delete(Service_Event entity) {
		linkServiceEventCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Event> entities) {
		linkServiceEventCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Event> save(Iterable<Service_Event> entities) {
		return linkServiceEventCrudRepository.save(entities);
	}

	@Override
	public Service_Event save(Service_Event entity) {
		return linkServiceEventCrudRepository.save(entity);
	}

	@Override
	public List<Service_Event> findByEvent(Event event) {
		return linkServiceEventCrudRepository.findByEvent(event);
	}

	@Override
	public List<Service_Event> findByService(Service service) {
		return linkServiceEventCrudRepository.findByService(service);
	}

}
