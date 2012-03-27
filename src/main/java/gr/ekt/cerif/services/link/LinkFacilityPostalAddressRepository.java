package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and postalAddresses.
 * 
 */
@Component
public class LinkFacilityPostalAddressRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Transactional
	public void save(Facility_PostalAddress entity) {
		if (entity.getFacility() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a postalAddress.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getPostalAddress().getId() == null) {
			postalAddressRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_PostalAddress> entityList) {
		for (Facility_PostalAddress entity : entityList) {
			save(entity);
		}
	}
	
}
