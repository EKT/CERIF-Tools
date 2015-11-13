/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Equipment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for equipments.
 * 
 */
public interface EquipmentCrudRepository extends CrudRepository<Equipment, Long> {
	
	public List<Equipment> findAll();
	
	public Page<Equipment> findAll(Pageable page);

	public Equipment findById(Long id);

	public List<Equipment> findByUri(String uri);

	public Equipment findByUuid(String uuid);

}
