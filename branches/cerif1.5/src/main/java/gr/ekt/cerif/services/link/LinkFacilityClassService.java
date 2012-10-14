package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.services.CommonPersistenceService;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkFacilityClassService implements CommonPersistenceService<Facility_Class> {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Override
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

	@Override
	public void save(List<? extends Facility_Class> entities) {
		for (Facility_Class entity : entities) {
			save(entity);
		}		
	}

}
