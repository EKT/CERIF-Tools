package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPatent_Service;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and services.
 * 
 */
@Component
public class LinkResultPatentServiceRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Transactional
	public void save(ResultPatent_Service entity) {
		if (entity.getResultPatent() == null || entity.getService() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a service.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Service> entityList) {
		for (ResultPatent_Service entity : entityList) {
			save(entity);
		}
	}
	
}
