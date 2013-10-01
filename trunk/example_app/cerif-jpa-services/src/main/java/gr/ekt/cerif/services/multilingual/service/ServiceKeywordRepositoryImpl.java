package gr.ekt.cerif.services.multilingual.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ServiceKeyword;

@Component
public class ServiceKeywordRepositoryImpl implements ServiceKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceKeywordRepositoryImpl.class);
	
	@Autowired
	private ServiceKeywordCrudRepository serviceKeywordCrudRepository;

	@Override
	public void delete(ServiceKeyword entity) {
		serviceKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ServiceKeyword> entities) {
		serviceKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ServiceKeyword> save(Iterable<ServiceKeyword> entities) {
		return serviceKeywordCrudRepository.save(entities);
	}

	@Override
	public ServiceKeyword save(ServiceKeyword entity) {
		return serviceKeywordCrudRepository.save(entity);
	}

}
