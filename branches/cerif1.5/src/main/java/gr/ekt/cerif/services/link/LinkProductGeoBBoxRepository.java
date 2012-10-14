/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.GeographicBoundingBoxRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between classes and bounding boxes.
 * 
 */
@Component
public class LinkProductGeoBBoxRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Autowired
	private GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	@Transactional
	public void save(ResultProduct_GeographicBoundingBox entity) {
		if (entity.getResultProduct() == null || entity.getGeographicBoundingBox() == null) {
			throw new IllegalArgumentException("Please provide both a product and a geographic bounding box.");
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		if (entity.getGeographicBoundingBox().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_GeographicBoundingBox> entityList) {
		for (ResultProduct_GeographicBoundingBox entity : entityList) {
			save(entity);
		}
	}

}
