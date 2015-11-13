package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.multilingual.FacilityName;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FacilityNameCrudRepository extends CrudRepository<FacilityName, Long> {
	
	List<FacilityName> findByFacility(Facility facility);

}
