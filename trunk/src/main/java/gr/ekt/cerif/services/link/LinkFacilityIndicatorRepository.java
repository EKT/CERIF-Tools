package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Indicator;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.IndicatorRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and indicators.
 * 
 */
@Component
public class LinkFacilityIndicatorRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Transactional
	public void save(Facility_Indicator entity) {
		if (entity.getFacility() == null || entity.getIndicator() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a indicator.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Indicator> entityList) {
		for (Facility_Indicator entity : entityList) {
			save(entity);
		}
	}
	
}
