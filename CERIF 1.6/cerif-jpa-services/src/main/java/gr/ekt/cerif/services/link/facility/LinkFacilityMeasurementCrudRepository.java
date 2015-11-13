package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityMeasurementCrudRepository extends CrudRepository<Facility_Measurement, Long> {
	
	List<Facility_Measurement> findByMeasurement(Measurement measurement);
	
	List<Facility_Measurement> findByFacility(Facility facility);

}
