package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationFacilityCrudRepository extends CrudRepository<ResultPublication_Facility, Long> {
	
	List<ResultPublication_Facility> findByResultPublication(ResultPublication resultPublication);
	
	List<ResultPublication_Facility> findByFacility(Facility facility);

}
