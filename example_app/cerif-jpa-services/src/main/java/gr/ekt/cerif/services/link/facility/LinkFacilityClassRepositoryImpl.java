package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityClassRepositoryImpl implements LinkFacilityClassRepository {

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
	public Iterable<? extends Facility_Class> save(Iterable<? extends Facility_Class> entities) {
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

}
