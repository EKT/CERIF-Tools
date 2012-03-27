package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Class;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between services and classes.
 * 
 */
@Component
public class LinkServiceClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Service_Class entity) {
		if (entity.getService() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a service and a class.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Class> entityList) {
		for (Service_Class entity : entityList) {
			save(entity);
		}
	}
	
}
