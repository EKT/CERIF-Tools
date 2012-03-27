/**
 * 
 */
package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.result.ResultProductRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and products.
 * 
 */
@Component
public class LinkPersonProductRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ResultProductRepository productRepository;
	
	@Transactional
	public void save(Person_ResultProduct entity) {
		if (entity.getPerson() == null || entity.getResultProduct() == null) {
			throw new IllegalArgumentException("Please provide both a person and a product.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getResultProduct().getId() == null) {
			productRepository.save(entity.getResultProduct());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_ResultProduct> entityList) {
		for (Person_ResultProduct entity : entityList) {
			save(entity);
		}
	}

}
