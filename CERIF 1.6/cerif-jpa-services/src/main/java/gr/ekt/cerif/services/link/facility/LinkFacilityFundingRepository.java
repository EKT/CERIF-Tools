package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

/**
 * A repository for links between facilities and fundings.
 * 
 */
public interface LinkFacilityFundingRepository {
	
	List<Facility_Funding> findByFunding(Funding funding);
	
	List<Facility_Funding> findByFacility(Facility facility);
	
	void delete(Facility_Funding entity);
	
	void delete(Iterable<Facility_Funding> entities);
	
	Iterable<Facility_Funding> save(Iterable<Facility_Funding> entities);
	
	Facility_Funding save(Facility_Funding entity);
	
	Iterable<Facility_Funding> findAll();
}
