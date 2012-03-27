package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and mediums.
 * 
 */
@Component
public class LinkFacilityMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Facility_Medium entity) {
		if (entity.getFacility() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a medium.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Medium> entityList) {
		for (Facility_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
