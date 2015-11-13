package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityPostalAddressCrudRepository extends CrudRepository<Facility_PostalAddress, Long> {

	List<Facility_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	List<Facility_PostalAddress> findByFacility(Facility facility);
}
