package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityFacilityRepositoryImpl implements LinkFacilityFacilityRepository {

	@Autowired
	private LinkFacilityFacilityCrudRepository linkFacilityFacilityCrudRepository;

	@Transactional
	public Facility_Facility save(Facility_Facility entity) {
		return linkFacilityFacilityCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<? extends Facility_Facility> save(Iterable<? extends Facility_Facility> entities) {
		return linkFacilityFacilityCrudRepository.save(entities);
	}

	public List<Facility_Facility> findByTheClass(Class theClass) {
		return linkFacilityFacilityCrudRepository.findByTheClass(theClass);
	}

	@Transactional
	public void delete(Facility_Facility entity) {
		linkFacilityFacilityCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Facility> entities) {
		linkFacilityFacilityCrudRepository.delete(entities);		
	}
	
}
