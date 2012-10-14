package gr.ekt.cerif.services.link;

import java.util.List;

import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for links between facilities and fundings.
 * 
 */
public interface LinkFacilityFundingRepository extends CrudRepository<Facility_Funding, Long> {
	List<Facility_Funding> findByFunding(Funding funding);
}
