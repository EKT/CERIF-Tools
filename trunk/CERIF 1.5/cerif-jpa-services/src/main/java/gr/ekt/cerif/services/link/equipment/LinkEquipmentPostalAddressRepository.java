package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.link.Equipment_PostalAddress;

/**
 * A repository for links between equipments and postalAddresses.
 * 
 */
public interface LinkEquipmentPostalAddressRepository {

	public void delete(Equipment_PostalAddress entity); 
	
	public void delete(Iterable<Equipment_PostalAddress> entities); 

	public Iterable<Equipment_PostalAddress> save(Iterable<Equipment_PostalAddress> entities); 
	
	public Equipment_PostalAddress save(Equipment_PostalAddress entity);
	
}
