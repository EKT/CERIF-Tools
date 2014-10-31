/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

/**
 * A repository for equipments.
 * 
 */
public interface EquipmentCrudRepository extends CrudRepository<Equipment, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Equipment> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<Equipment> findAll(Pageable page);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Equipment findById(Long id);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Equipment> findByUri(String uri);

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Equipment findByUuid(String uuid);

}
