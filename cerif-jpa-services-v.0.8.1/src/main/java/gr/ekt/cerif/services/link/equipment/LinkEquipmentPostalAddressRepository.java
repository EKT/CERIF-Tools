package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

/**
 * A repository for links between equipments and postalAddresses.
 * 
 */
public interface LinkEquipmentPostalAddressRepository {

	public void delete(Equipment_PostalAddress entity); 
	
	public void delete(Iterable<Equipment_PostalAddress> entities); 

	public Iterable<Equipment_PostalAddress> save(Iterable<Equipment_PostalAddress> entities); 
	
	public Equipment_PostalAddress save(Equipment_PostalAddress entity);
	
	List<Equipment_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Equipment_PostalAddress> findByEquipment(Equipment equipment);
	
}
