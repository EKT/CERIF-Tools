package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Service;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between services.
 * 
 */
@Component
public class LinkServiceServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(Service_Service entity) {
		if (entity.getService1() == null || entity.getService2() == null) {
			throw new IllegalArgumentException("Please provide both services.");
		}
		if (entity.getService1().getId() == null) {
			serviceRepository.save(entity.getService1());
		}
		if (entity.getService2().getId() == null) {
			serviceRepository.save(entity.getService2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Service> entityList) {
		for (Service_Service entity : entityList) {
			save(entity);
		}
	}
	
}
