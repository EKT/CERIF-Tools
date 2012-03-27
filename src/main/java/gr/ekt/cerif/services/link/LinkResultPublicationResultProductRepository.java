package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.result.ResultProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and resultProducts.
 * 
 */
@Component
public class LinkResultPublicationResultProductRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Transactional
	public void save(ResultPublication_ResultProduct entity) {
		if (entity.getResultPublication() == null || entity.getResultProduct() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a resultProduct.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getResultProduct().getId() == null) {
			resultProductRepository.save(entity.getResultProduct());
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
