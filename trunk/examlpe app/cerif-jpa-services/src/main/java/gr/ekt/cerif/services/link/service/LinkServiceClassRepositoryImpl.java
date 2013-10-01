package gr.ekt.cerif.services.link.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Service_Class;

@Component
public class LinkServiceClassRepositoryImpl implements
		LinkServiceClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceClassRepositoryImpl.class);
	
	@Autowired
	private LinkServiceClassCrudRepository linkServiceClassCrudRepository;

	@Override
	public void delete(Service_Class entity) {
		linkServiceClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Class> entities) {
		linkServiceClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Class> save(Iterable<Service_Class> entities) {
		return linkServiceClassCrudRepository.save(entities);
	}

	@Override
	public Service_Class save(Service_Class entity) {
		return linkServiceClassCrudRepository.save(entity);
	}

}
