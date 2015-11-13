package gr.ekt.cerif.services.link.equipment;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.Equipment_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkEquipmentFundingCrudRepository extends CrudRepository<Equipment_Funding, Long> {
	
	List<Equipment_Funding> findByFunding(Funding funding);
	
	List<Equipment_Funding> findByEquipment(Equipment equipment);

}
