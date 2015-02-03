/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.multilingual.MeasurementDescription;

/**
 * @author bonisv
 *
 */
@Component
public class MeasurementDescriptionRepositoryImpl implements MeasurementDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementDescriptionRepositoryImpl.class);
	
	@Autowired
	private MeasurementDescriptionCrudRepository measurementDescriptionCrudRepository;

	@Override
	public void delete(MeasurementDescription entity) {
		measurementDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MeasurementDescription> entities) {
		measurementDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MeasurementDescription> save(Iterable<MeasurementDescription> entities) {
		return measurementDescriptionCrudRepository.save(entities);
	}

	@Override
	public MeasurementDescription save(MeasurementDescription entity) {
		return measurementDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<MeasurementDescription> findByMeasurement(
			Measurement measurement) {
		return measurementDescriptionCrudRepository.findByMeasurement(measurement);
	}

}
