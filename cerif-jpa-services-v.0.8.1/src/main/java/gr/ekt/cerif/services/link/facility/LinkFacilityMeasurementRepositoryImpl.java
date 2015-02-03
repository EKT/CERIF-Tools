package gr.ekt.cerif.services.link.facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

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

	@Override
	public List<Facility_Measurement> findByMeasurement(Measurement measurement) {
		return linkFacilityMeasurementCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<Facility_Measurement> findByFacility(Facility facility) {
		return linkFacilityMeasurementCrudRepository.findByFacility(facility);
	}

}
