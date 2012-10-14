package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and fundings.
 * 
 */
@Component
public abstract class LinkFacilityFundingRepositoryImpl implements LinkFacilityFundingRepository{
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public Facility_Funding save(Facility_Funding entity) {
		if (entity.getFacility() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a funding.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Funding> entityList) {
		for (Facility_Funding entity : entityList) {
			save(entity);
		}
	}
}
