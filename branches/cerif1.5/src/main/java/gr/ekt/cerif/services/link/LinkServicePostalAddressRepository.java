package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
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
public class LinkServicePostalAddressRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Transactional
	public void save(Service_PostalAddress entity) {
		if (entity.getService() == null || entity.getPostalAddress() == null) {
			throw new IllegalArgumentException("Please provide both a service and a postalAddress.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getPostalAddress().getId() == null) {
			postalAddressRepository.save(entity.getPostalAddress());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_PostalAddress> entityList) {
		for (Service_PostalAddress entity : entityList) {
			save(entity);
		}
	}
	
}
