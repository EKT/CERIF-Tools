package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityIndicatorCrudRepository extends CrudRepository<Facility_Indicator, Long> {
	
	List<Facility_Indicator> findByIndicator(Indicator indicator);
	
	List<Facility_Indicator> findByFacility(Facility facility);

}
