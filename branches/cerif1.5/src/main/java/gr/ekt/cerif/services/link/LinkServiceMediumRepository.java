package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Medium;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and mediumes.
 * 
 */
@Component
public class LinkServiceMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Service_Medium entity) {
		if (entity.getService() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a service and a medium.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Medium> entityList) {
		for (Service_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
