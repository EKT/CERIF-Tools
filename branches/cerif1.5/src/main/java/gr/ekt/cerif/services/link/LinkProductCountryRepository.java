/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.services.result.ResultProductRepository;
import gr.ekt.cerif.services.second.CountryRepository;

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
public class LinkProductCountryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public void save(ResultProduct_Country entity) {
		if (entity.getResultProduct() == null || entity.getCountry() == null) {
			throw new IllegalArgumentException("Please provide both a product and a country.");
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		if (entity.getCountry().getCode() == null) {
			countryRepository.save(entity.getCountry());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultProduct_Country> entityList) {
		for (ResultProduct_Country entity : entityList) {
			save(entity);
		}
	}

}
