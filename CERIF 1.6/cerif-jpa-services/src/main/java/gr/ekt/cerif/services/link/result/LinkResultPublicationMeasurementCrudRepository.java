package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPublicationMeasurementCrudRepository extends CrudRepository<ResultPublication_Measurement, Long> {
	
	List<ResultPublication_Measurement> findByMeasurement(Measurement measurement);
	
	List<ResultPublication_Measurement> findByResultPublication(ResultPublication resultPublication);

}
