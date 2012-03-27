package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and classes.
 * 
 */
@Component
public class LinkFacilityClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Facility_Class entity) {
		if (entity.getFacility() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a facility and a class.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Facility_Class> entityList) {
		for (Facility_Class entity : entityList) {
			save(entity);
		}
	}
	
}
