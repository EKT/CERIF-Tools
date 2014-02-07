package gr.ekt.cerif.services.link.facility;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for links between facilities and postalAddresses.
 * 
 */
public interface LinkFacilityPostalAddressRepository {

	public void delete(Facility_PostalAddress entity); 
	
	public void delete(Iterable<Facility_PostalAddress> entities); 

	public Iterable<Facility_PostalAddress> save(Iterable<Facility_PostalAddress> entities); 
	
	public Facility_PostalAddress save(Facility_PostalAddress entity);

	List<Facility_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Facility_PostalAddress> findByFacility(Facility facility);
	
}
