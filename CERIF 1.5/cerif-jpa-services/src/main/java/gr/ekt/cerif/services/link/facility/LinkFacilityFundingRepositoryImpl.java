package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and fundings.
 * 
 */
@Component
public class LinkFacilityFundingRepositoryImpl implements LinkFacilityFundingRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityFundingRepositoryImpl.class);

	@Autowired
	private LinkFacilityFundingCrudRepository linkFacilityFundingCrudRepository;
	
	@Transactional
	public Facility_Funding save(Facility_Funding entity) {
		return linkFacilityFundingCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Facility_Funding> save(Iterable<Facility_Funding> entityList) {
		return linkFacilityFundingCrudRepository.save(entityList);
	}
	
	public List<Facility_Funding> findByFunding(Funding funding) {
		return linkFacilityFundingCrudRepository.findByFunding(funding);
	}

	@Transactional
	public void delete(Facility_Funding entity) {
		linkFacilityFundingCrudRepository.delete(entity);
	}

	public Iterable<Facility_Funding> findAll() {
		return linkFacilityFundingCrudRepository.findAll();
	}

	@Override
	public void delete(Iterable<Facility_Funding> entities) {
		linkFacilityFundingCrudRepository.delete(entities);		
	}

	@Override
	public List<Facility_Funding> findByFacility(Facility facility) {
		return linkFacilityFundingCrudRepository.findByFacility(facility);
	}
	
}
