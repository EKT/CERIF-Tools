package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkResultPatentMeasurementCrudRepository extends CrudRepository<ResultPatent_Measurement, Long> {
	
	List<ResultPatent_Measurement> findByMeasurement(Measurement measurement);
	
	List<ResultPatent_Measurement> findByResultPatent(ResultPatent resultPatent);

}
