package gr.ekt.cerif.services.link.facility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Facility_Measurement;

@Component
public class LinkFacilityMeasurementRepositoryImpl implements
		LinkFacilityMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityMeasurementCrudRepository linkFacilityMeasurementCrudRepository;

	@Override
	public void delete(Facility_Measurement entity) {
		linkFacilityMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_Measurement> entities) {
		linkFacilityMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Facility_Measurement> save(
			Iterable<Facility_Measurement> entities) {
		return linkFacilityMeasurementCrudRepository.save(entities);
	}

	@Override
	public Facility_Measurement save(Facility_Measurement entity) {
		return linkFacilityMeasurementCrudRepository.save(entity);
	}

}
