package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class ServiceRepositoryImpl implements ServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceRepositoryImpl.class);
	
	@Autowired
	private ServiceCrudRepository serviceCrudRepository;
	

	@Override
	@Transactional
	public void delete(Service entity) {
		serviceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service> entities) {
		serviceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service> save(Iterable<Service> entities) {
		return serviceCrudRepository.save(entities);
	}

	@Override
	public Service save(Service entity) {
		return serviceCrudRepository.save(entity);
	}

	@Override
	public List<Service> findAll() {
		return serviceCrudRepository.findAll();
	}

	@Override
	public Page<Service> findAll(Pageable page) {
		return serviceCrudRepository.findAll(page);
	}

	@Override
	public Service findById(Long id) {
		return serviceCrudRepository.findById(id);
	}

	@Override
	public Service findByUuid(String uuid) {
		return serviceCrudRepository.findByUuid(uuid);
	}

	@Override
	public List<Service> findByUri(String uri) {
		return serviceCrudRepository.findByUri(uri);
	}

}
