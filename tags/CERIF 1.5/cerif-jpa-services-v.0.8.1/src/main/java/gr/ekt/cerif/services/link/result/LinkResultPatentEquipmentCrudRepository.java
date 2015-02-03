package gr.ekt.cerif.services.link.result;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.link.result.ResultPatent_Equipment;
import gr.ekt.cerif.entities.result.ResultPatent;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentEquipmentCrudRepository extends CrudRepository<ResultPatent_Equipment, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Equipment> findByEquipment(Equipment equipment);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<ResultPatent_Equipment> findByResultPatent(ResultPatent resultPatent);

}
