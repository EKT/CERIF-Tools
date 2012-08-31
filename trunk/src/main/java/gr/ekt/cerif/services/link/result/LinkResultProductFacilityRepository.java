package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and facilities.
 * 
 */
@Component
public class LinkResultProductFacilityRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Transactional
	public void save(ResultProduct_Facility entity) {
		if (entity.getResultProduct() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a facility.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Facility> entityList) {
		for (ResultProduct_Facility entity : entityList) {
			save(entity);
		}
	}
	
}
