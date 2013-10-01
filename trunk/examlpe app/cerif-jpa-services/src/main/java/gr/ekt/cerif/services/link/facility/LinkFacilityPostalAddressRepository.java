package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_PostalAddress;

/**
 * A repository for links between facilities and postalAddresses.
 * 
 */
public interface LinkFacilityPostalAddressRepository {

	public void delete(Facility_PostalAddress entity); 
	
	public void delete(Iterable<Facility_PostalAddress> entities); 

	public Iterable<Facility_PostalAddress> save(Iterable<Facility_PostalAddress> entities); 
	
	public Facility_PostalAddress save(Facility_PostalAddress entity);
	
}
