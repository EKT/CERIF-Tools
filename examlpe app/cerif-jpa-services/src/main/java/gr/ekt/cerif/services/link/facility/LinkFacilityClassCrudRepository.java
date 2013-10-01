package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityClassCrudRepository extends CrudRepository<Facility_Class, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Class> findByTheClass(Class theClass);
	
}
