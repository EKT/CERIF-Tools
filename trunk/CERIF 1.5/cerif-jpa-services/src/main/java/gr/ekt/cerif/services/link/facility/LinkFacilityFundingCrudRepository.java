package gr.ekt.cerif.services.link.facility;

import java.util.List;

import javax.persistence.QueryHint;

import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityFundingCrudRepository extends CrudRepository<Facility_Funding, Long> {

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Facility_Funding> findByFunding(Funding funding);

}
