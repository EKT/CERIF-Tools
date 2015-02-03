package gr.ekt.cerif.services.link.facility;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Facility_Service;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityServiceCrudRepository extends CrudRepository<Facility_Service, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Service> findByService(Service service);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Service> findByFacility(Facility facility);

}
