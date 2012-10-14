/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * A repository for links between publications and products.
 * 
 */
@Component
public class LinkPublicationProductRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository publicationRepository;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Transactional
	public void save(ResultPublication_ResultProduct entity) {
		if (entity.getResultPublication() == null || entity.getResultProduct() == null) {
			throw new IllegalArgumentException("Please provide both a publication and a product.");
		}
		if (entity.getResultPublication().getId() == null) {
			publicationRepository.save(entity.getResultPublication());
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_ResultProduct> entityList) {
		for (ResultPublication_ResultProduct entity : entityList) {
			save(entity);
		}
	}

}
