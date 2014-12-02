package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkFacilityFacilityRepositoryImpl implements LinkFacilityFacilityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityFacilityRepositoryImpl.class);

	@Autowired
	private LinkFacilityFacilityCrudRepository linkFacilityFacilityCrudRepository;

	@Transactional
	public Facility_Facility save(Facility_Facility entity) {
		return linkFacilityFacilityCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Facility_Facility> save(Iterable<Facility_Facility> entities) {
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

	@Override
	public List<Facility_Facility> findByFacility1(Facility facility) {
		return linkFacilityFacilityCrudRepository.findByFacility1(facility);
	}

	@Override
	public List<Facility_Facility> findByFacility2(Facility facility) {
		return linkFacilityFacilityCrudRepository.findByFacility2(facility);
	}
	
}
