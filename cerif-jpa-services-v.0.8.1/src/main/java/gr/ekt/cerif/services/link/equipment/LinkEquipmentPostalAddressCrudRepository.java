package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentPostalAddressCrudRepository extends CrudRepository<Equipment_PostalAddress, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Equipment_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Equipment_PostalAddress> findByEquipment(Equipment equipment);

}
