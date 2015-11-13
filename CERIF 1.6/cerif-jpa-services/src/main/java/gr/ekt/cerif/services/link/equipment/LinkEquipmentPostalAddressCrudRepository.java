package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentPostalAddressCrudRepository extends CrudRepository<Equipment_PostalAddress, Long> {
	
	List<Equipment_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Equipment_PostalAddress> findByEquipment(Equipment equipment);

}
