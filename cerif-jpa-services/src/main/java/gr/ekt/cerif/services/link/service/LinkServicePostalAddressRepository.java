package gr.ekt.cerif.services.link.service;

import gr.ekt.cerif.entities.link.Service_PostalAddress;

/**
 * A repository for links between facilities and postalAddresses.
 * 
 */
public interface LinkServicePostalAddressRepository {

	public void delete(Service_PostalAddress entity); 
	
	public void delete(Iterable<Service_PostalAddress> entities); 

	public Iterable<Service_PostalAddress> save(Iterable<Service_PostalAddress> entities); 
	
	public Service_PostalAddress save(Service_PostalAddress entity);
	
}
