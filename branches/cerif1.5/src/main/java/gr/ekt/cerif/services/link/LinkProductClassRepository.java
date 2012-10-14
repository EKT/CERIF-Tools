/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between classes and products.
 * 
 */
@Component
public class LinkProductClassRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(ResultProduct_Class entity) {
		if (entity.getResultProduct() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a product and a class.");
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Class> entityList) {
		for (ResultProduct_Class entity : entityList) {
			save(entity);
		}
	}

}
