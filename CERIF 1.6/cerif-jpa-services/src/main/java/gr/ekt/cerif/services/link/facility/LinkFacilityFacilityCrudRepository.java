package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityFacilityCrudRepository extends CrudRepository<Facility_Facility, String> {

	List<Facility_Facility> findByTheClass(Class theClass);
	
	List<Facility_Facility> findByFacility1(Facility facility);
	
	List<Facility_Facility> findByFacility2(Facility facility);
	
}