package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkGeographicBoundingBoxMeasurementCrudRepository extends CrudRepository<GeographicBoundingBox_Measurement, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_Measurement> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<GeographicBoundingBox_Measurement> findByMeasurement(Measurement measurement);

}
