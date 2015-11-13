package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityClassCrudRepository extends CrudRepository<Facility_Class, Long> {

	List<Facility_Class> findByTheClass(Class theClass);
	
	List<Facility_Class> findByFacility(Facility facility);
	
}
