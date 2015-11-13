package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityFundingCrudRepository extends CrudRepository<Facility_Funding, Long> {

	List<Facility_Funding> findByFunding(Funding funding);
	
	List<Facility_Funding> findByFacility(Facility facility);

}
