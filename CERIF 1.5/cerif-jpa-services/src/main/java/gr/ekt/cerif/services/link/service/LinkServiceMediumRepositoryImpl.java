package gr.ekt.cerif.services.link.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.entities.second.Medium;

@Component
public class LinkServiceMediumRepositoryImpl implements	LinkServiceMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceMediumRepositoryImpl.class);
	
	@Autowired
	private LinkServiceMediumCrudRepository linkServiceMediumCrudRepository;

	@Override
	public void delete(Service_Medium entity) {
		linkServiceMediumCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Medium> entities) {
		linkServiceMediumCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Medium> save(Iterable<Service_Medium> entities) {
		return linkServiceMediumCrudRepository.save(entities);
	}

	@Override
	public Service_Medium save(Service_Medium entity) {
		return linkServiceMediumCrudRepository.save(entity);
	}

	@Override
	public List<Service_Medium> findByMedium(Medium medium) {
		return linkServiceMediumCrudRepository.findByMedium(medium);
	}

	@Override
	public List<Service_Medium> findByService(Service service) {
		return linkServiceMediumCrudRepository.findByService(service);
	}

}
