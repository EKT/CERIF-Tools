package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and services.
 * 
 */
@Component
public class LinkResultPublicationServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(ResultPublication_Service entity) {
		if (entity.getResultPublication() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a service.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Service> entityList) {
		for (ResultPublication_Service entity : entityList) {
			save(entity);
		}
	}
	
}
