package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityClassRepositoryImpl implements LinkFacilityClassRepository {

	@Autowired
	private LinkFacilityClassCrudRepository linkFacilityClassCrudRepository; 
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	public List<Facility_Class> findByTheClass(Class theClass) {
		return linkFacilityClassCrudRepository.findByTheClass(theClass);
	}
	
	@Transactional
	public Facility_Class save(Facility_Class entity) {
		if (entity.getFacility() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a class.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		return entityManager.merge(entity);
		
	}

	@Transactional
	public Iterable<? extends Facility_Class> save(Iterable<? extends Facility_Class> entities) {
		for (Facility_Class entity : entities) {
			save(entity);
		}
		return entities;
	}

	@Transactional
	public void delete(Facility_Class entity) {
		linkFacilityClassCrudRepository.delete(entity);
	}

}
