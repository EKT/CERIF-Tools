package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityFacilityRepositoryImpl implements LinkFacilityFacilityRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;

	@Autowired
	private LinkFacilityFacilityCrudRepository linkFacilityFacilityCrudRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;

	@Transactional
	public Facility_Facility save(Facility_Facility entity) {
		if (entity.getFacility1() == null || entity.getFacility2() == null) {
			throw new IllegalArgumentException("Please provide both facilities.");
		}
		if (entity.getFacility1().getId() == null) {
			facilityRepository.save(entity.getFacility1());
		}
		if (entity.getFacility2().getId() == null) {
			facilityRepository.save(entity.getFacility2());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<? extends Facility_Facility> save(Iterable<? extends Facility_Facility> entities) {
		for (Facility_Facility entity : entities) {
			save(entity);
		}
		return entities;
	}

	public List<Facility_Facility> findByTheClass(Class theClass) {
		return linkFacilityFacilityCrudRepository.findByTheClass(theClass);
	}

	@Transactional
	public void delete(Facility_Facility entity) {
		linkFacilityFacilityCrudRepository.delete(entity);
	}
	
}
