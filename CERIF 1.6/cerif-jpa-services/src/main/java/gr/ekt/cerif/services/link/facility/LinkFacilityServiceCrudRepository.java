package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Facility_Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityServiceCrudRepository extends CrudRepository<Facility_Service, Long> {
	
	List<Facility_Service> findByService(Service service);
	
	List<Facility_Service> findByFacility(Facility facility);

}
