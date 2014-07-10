package gr.ekt.cerif.services.link.equipment;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Equipment;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentEquipmentCrudRepository extends CrudRepository<Equipment_Equipment, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Equipment_Equipment> findByEquipment1(Equipment equipment);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Equipment_Equipment> findByEquipment2(Equipment equipment);

}
