/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentDescription;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentDescriptionCrudRepository extends CrudRepository<EquipmentDescription, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<EquipmentDescription> findByEquipment(Equipment equipment);

}
