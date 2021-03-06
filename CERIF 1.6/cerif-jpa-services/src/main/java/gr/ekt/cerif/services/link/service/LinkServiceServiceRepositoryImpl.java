package gr.ekt.cerif.services.link.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Service;

@Component
public class LinkServiceServiceRepositoryImpl implements
		LinkServiceServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceServiceRepositoryImpl.class);
	
	@Autowired
	private LinkServiceServiceCrudRepository linkServiceServiceCrudRepository;

	@Override
	public void delete(Service_Service entity) {
		linkServiceServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Service> entities) {
		linkServiceServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Service> save(Iterable<Service_Service> entities) {
		return linkServiceServiceCrudRepository.save(entities);
	}

	@Override
	public Service_Service save(Service_Service entity) {
		return linkServiceServiceCrudRepository.save(entity);
	}

	@Override
	public List<Service_Service> findByService1(Service service) {
		return linkServiceServiceCrudRepository.findByService1(service);
	}

	@Override
	public List<Service_Service> findByService2(Service service) {
		return linkServiceServiceCrudRepository.findByService2(service);
	}

}
