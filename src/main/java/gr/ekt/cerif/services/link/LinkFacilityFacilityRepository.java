package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between facilities and facilities.
 * 
 */
public interface LinkFacilityFacilityRepository extends CrudRepository<Facility_Facility, String>{
	List<Facility_Facility> findByTheClass(Class theClass);
}
