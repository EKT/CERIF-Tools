package gr.ekt.cerif.services.link.facility;

import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Medium;
import gr.ekt.cerif.entities.second.Medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkFacilityMediumRepositoryImpl implements LinkFacilityMediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityMediumRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityMediumCrudRepository linkFacilityMediumCrudRepository;

	@Override
	public void delete(Facility_Medium entity) {
		linkFacilityMediumCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Facility_Medium> entities) {
		linkFacilityMediumCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Facility_Medium> save(Iterable<Facility_Medium> entities) {
		return linkFacilityMediumCrudRepository.save(entities);
	}

	@Override
	public Facility_Medium save(Facility_Medium entity) {
		return linkFacilityMediumCrudRepository.save(entity);
	}

	@Override
	public List<Facility_Medium> findByMedium(Medium medium) {
		return linkFacilityMediumCrudRepository.findByMedium(medium);
	}

	@Override
	public List<Facility_Medium> findByFacility(Facility facility) {
		return linkFacilityMediumCrudRepository.findByFacility(facility);
	}

}
