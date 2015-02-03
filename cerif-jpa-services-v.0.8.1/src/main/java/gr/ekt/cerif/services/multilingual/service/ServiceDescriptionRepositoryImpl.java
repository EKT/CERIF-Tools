package gr.ekt.cerif.services.multilingual.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.features.multilingual.ServiceDescription;

@Component
public class ServiceDescriptionRepositoryImpl implements ServiceDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceDescriptionRepositoryImpl.class);
	
	@Autowired
	private ServiceDescriptionCrudRepository serviceDescriptionCrudRepository;

	@Override
	public void delete(ServiceDescription entity) {
		serviceDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ServiceDescription> entities) {
		serviceDescriptionCrudRepository.delete(entities);

	}

	@Override
	public Iterable<ServiceDescription> save(Iterable<ServiceDescription> entities) {
		return serviceDescriptionCrudRepository.save(entities);
	}

	@Override
	public ServiceDescription save(ServiceDescription entity) {
		return serviceDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<ServiceDescription> findByService(Service service) {
		return serviceDescriptionCrudRepository.findByService(service);
	}

}
