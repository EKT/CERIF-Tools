package gr.ekt.cerif.services.link.measurement;

import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkMeasurementClassCrudRepository extends CrudRepository<Measurement_Class, Long> {
	
	List<Measurement_Class> findByMeasurement(Measurement measurement);
	
	List<Measurement_Class> findBytheClass(Class theClass);

}
