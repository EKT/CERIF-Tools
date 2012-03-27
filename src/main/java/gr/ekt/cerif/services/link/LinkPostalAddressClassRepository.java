package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.services.second.PostalAddressRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between postalAddresses and classes.
 * 
 */
@Component
public class LinkPostalAddressClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(PostalAddress_Class entity) {
		if (entity.getPostalAddress() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a postalAddress and a class.");
		}
		if (entity.getPostalAddress().getId() == null) {
			postalAddressRepository.save(entity.getPostalAddress());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<PostalAddress_Class> entityList) {
		for (PostalAddress_Class entity : entityList) {
			save(entity);
		}
	}
	
}
