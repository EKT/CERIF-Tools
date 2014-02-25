package gr.ekt.cerif.services.link.service;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for links between facilities and postalAddresses.
 * 
 */
public interface LinkServicePostalAddressRepository {

	public void delete(Service_PostalAddress entity); 
	
	public void delete(Iterable<Service_PostalAddress> entities); 

	public Iterable<Service_PostalAddress> save(Iterable<Service_PostalAddress> entities); 
	
	public Service_PostalAddress save(Service_PostalAddress entity);
	
	List<Service_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Service_PostalAddress> findByService(Service service);
	
}
