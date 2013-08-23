package gr.ekt.cerif.services.link.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Service_Event;

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

}
