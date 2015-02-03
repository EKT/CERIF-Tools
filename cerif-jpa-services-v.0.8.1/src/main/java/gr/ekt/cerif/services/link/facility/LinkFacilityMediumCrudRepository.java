package gr.ekt.cerif.services.link.facility;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.second.Medium;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityMediumCrudRepository extends CrudRepository<Facility_Medium, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Medium> findByMedium(Medium medium);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Medium> findByFacility(Facility facility);

}
