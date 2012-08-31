package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and services.
 * 
 */
@Component
public class LinkResultProductServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(ResultProduct_Service entity) {
		if (entity.getResultProduct() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a service.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Service> entityList) {
		for (ResultProduct_Service entity : entityList) {
			save(entity);
		}
	}
	
}
