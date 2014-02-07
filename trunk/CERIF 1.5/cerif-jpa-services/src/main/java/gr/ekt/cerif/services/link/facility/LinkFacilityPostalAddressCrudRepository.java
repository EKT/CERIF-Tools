package gr.ekt.cerif.services.link.facility;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityPostalAddressCrudRepository extends CrudRepository<Facility_PostalAddress, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_PostalAddress> findByPostalAddress(PostalAddress postalAddress);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_PostalAddress> findByFacility(Facility facility);
}
