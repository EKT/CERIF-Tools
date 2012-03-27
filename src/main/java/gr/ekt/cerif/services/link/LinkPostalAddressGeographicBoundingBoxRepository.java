package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;
import gr.ekt.cerif.services.second.GeographicBoundingBoxRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between geographic bounding boxes and postalAddresses.
 * 
 */
@Component
public class LinkPostalAddressGeographicBoundingBoxRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Transactional
	public void save(PostalAddress_GeographicBoundingBox entity) {
		if (entity.getGeographicBoundingBox() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both a geographicBoundingBox and a postalAddress.");
		}
		if (entity.getGeographicBoundingBox().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox());
		}
		if (entity.getPostalAddress().getId() == null) {
			postalAddressRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<PostalAddress_GeographicBoundingBox> entityList) {
		for (PostalAddress_GeographicBoundingBox entity : entityList) {
			save(entity);
		}
	}
	
}
