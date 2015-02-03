/**
 * 
 */
package gr.ekt.cerif.services.multilingual.equipment;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * @author bonisv
 *
 */
public interface EquipmentKeywordCrudRepository extends CrudRepository<EquipmentKeyword, Long>  {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<EquipmentKeyword> findByEquipment(Equipment equipment);

}
