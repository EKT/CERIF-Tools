package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.second.Medium;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityMediumCrudRepository extends CrudRepository<Facility_Medium, Long> {
	
	List<Facility_Medium> findByMedium(Medium medium);
	
	List<Facility_Medium> findByFacility(Facility facility);

}
