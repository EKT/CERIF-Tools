package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentFacilityCrudRepository extends CrudRepository<ResultPatent_Facility, Long> {
	
	List<ResultPatent_Facility> findByFacility(Facility facility);
	
	List<ResultPatent_Facility> findByResultPatent(ResultPatent resultPatent);

}
