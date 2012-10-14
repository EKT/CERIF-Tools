package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.services.result.ResultProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultProducts.
 * 
 */
@Component
public class LinkResultProductResultProductRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository resultProductRepository;

	
	@Transactional
	public void save(ResultProduct_ResultProduct entity) {
		if (entity.getResultProduct1() == null || entity.getResultProduct2() == null) {
			throw new IllegalArgumentException("Please provide both resultProducts.");
		}
		if (entity.getResultProduct1().getId() == null) {
			resultProductRepository.save(entity.getResultProduct1());
		}
		if (entity.getResultProduct2().getId() == null) {
			resultProductRepository.save(entity.getResultProduct2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_ResultProduct> entityList) {
		for (ResultProduct_ResultProduct entity : entityList) {
			save(entity);
		}
	}
	
}
