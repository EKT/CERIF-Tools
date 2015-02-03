package gr.ekt.cerif.services.infrastructure;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gr.ekt.cerif.entities.infrastructure.Equipment;

public interface EquipmentRepository {
	
	void delete(Equipment entity); 
	
	void delete(Iterable<Equipment> entities); 

	Iterable<Equipment> save(Iterable<Equipment> entities); 
	
	Equipment save(Equipment entity);
	
	List<Equipment> findAll();
	
	Page<Equipment> findAll(Pageable page);

	Equipment findById(Long id);

	List<Equipment> findByUri(String uri);

	Equipment findByUuid(String uuid);
}
