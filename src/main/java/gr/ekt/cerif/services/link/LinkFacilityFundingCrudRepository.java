package gr.ekt.cerif.services.link;

import java.util.List;

import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import org.springframework.data.repository.CrudRepository;

public interface LinkFacilityFundingCrudRepository extends CrudRepository<Facility_Funding, Long> {

	List<Facility_Funding> findByFunding(Funding funding);

}
