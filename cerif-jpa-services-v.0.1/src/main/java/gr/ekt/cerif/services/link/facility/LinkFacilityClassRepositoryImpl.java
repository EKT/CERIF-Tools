package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityClassRepositoryImpl implements LinkFacilityClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityClassRepositoryImpl.class);

	@Autowired
	private LinkFacilityClassCrudRepository linkFacilityClassCrudRepository; 
	
	public List<Facility_Class> findByTheClass(Class theClass) {
		return linkFacilityClassCrudRepository.findByTheClass(theClass);
	}
	
	@Transactional
	public Facility_Class save(Facility_Class entity) {
		return linkFacilityClassCrudRepository.save(entity);		
	}

	@Transactional
	public Iterable<Facility_Class> save(Iterable<Facility_Class> entities) {
		return linkFacilityClassCrudRepository.save(entities);
	}

	@Transactional
	public void delete(Facility_Class entity) {
		linkFacilityClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Class> entities) {
		linkFacilityClassCrudRepository.delete(entities);		
	}

	@Override
	public List<Facility_Class> findByFacility(Facility facility) {
		return linkFacilityClassCrudRepository.findByFacility(facility);
	}

}
