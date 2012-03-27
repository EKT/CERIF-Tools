package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts and mediums.
 * 
 */
@Component
public class LinkResultProductMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(ResultProduct_Medium entity) {
		if (entity.getResultProduct() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a resultProduct and a medium.");
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Medium> entityList) {
		for (ResultProduct_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
