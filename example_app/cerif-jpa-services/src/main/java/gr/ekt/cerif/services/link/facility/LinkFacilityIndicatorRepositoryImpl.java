package gr.ekt.cerif.services.link.facility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Facility_Indicator;

@Component
public class LinkFacilityIndicatorRepositoryImpl implements
		LinkFacilityIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityIndicatorCrudRepository linkFacilityIndicatorCrudRepository;

	@Override
	public void delete(Facility_Indicator entity) {
		linkFacilityIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Indicator> entities) {
		linkFacilityIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Facility_Indicator> save(
			Iterable<Facility_Indicator> entities) {
		return linkFacilityIndicatorCrudRepository.save(entities);
	}

	@Override
	public Facility_Indicator save(Facility_Indicator entity) {
		return linkFacilityIndicatorCrudRepository.save(entity);
	}

}
