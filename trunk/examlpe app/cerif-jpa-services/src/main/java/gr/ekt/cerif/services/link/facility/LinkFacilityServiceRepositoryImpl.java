package gr.ekt.cerif.services.link.facility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Facility_Service;

@Component
public class LinkFacilityServiceRepositoryImpl implements
		LinkFacilityServiceRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityServiceRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityServiceCrudRepository linkFacilityServiceCrudRepository;

	@Override
	public void delete(Facility_Service entity) {
		linkFacilityServiceCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Service> entities) {
		linkFacilityServiceCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Facility_Service> save(Iterable<Facility_Service> entities) {
		return linkFacilityServiceCrudRepository.save(entities);
	}

	@Override
	public Facility_Service save(Facility_Service entity) {
		return linkFacilityServiceCrudRepository.save(entity);
	}

}
