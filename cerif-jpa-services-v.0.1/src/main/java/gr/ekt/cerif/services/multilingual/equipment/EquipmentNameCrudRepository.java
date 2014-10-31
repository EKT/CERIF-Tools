/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentName;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentNameCrudRepository extends CrudRepository<EquipmentName, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<EquipmentName> findByEquipment(Equipment equipment);

}
