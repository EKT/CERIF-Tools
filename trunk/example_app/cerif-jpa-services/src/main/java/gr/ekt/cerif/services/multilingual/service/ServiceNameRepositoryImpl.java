package gr.ekt.cerif.services.multilingual.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ServiceName;

@Component
public class ServiceNameRepositoryImpl implements ServiceNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceNameRepositoryImpl.class);
	
	@Autowired
	private ServiceNameCrudRepository serviceNameCrudRepository;

	@Override
	public void delete(ServiceName entity) {
		serviceNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ServiceName> entities) {
		serviceNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ServiceName> save(Iterable<ServiceName> entities) {
		return serviceNameCrudRepository.save(entities);
	}

	@Override
	public ServiceName save(ServiceName entity) {
		return serviceNameCrudRepository.save(entity);
	}

}
