package gr.ekt.cerif.services.link.measurement;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkMeasurementClassCrudRepository extends CrudRepository<Measurement_Class, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Measurement_Class> findByMeasurement(Measurement measurement);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Measurement_Class> findBytheClass(Class theClass);

}
