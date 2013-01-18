package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityClassCrudRepository extends CrudRepository<Facility_Class, String>{

	List<Facility_Class> findByTheClass(Class theClass);
	
}
