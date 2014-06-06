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
import gr.ekt.cerif.features.multilingual.MeasurementKeyword;

/**
 * @author bonisv
 *
 */
@Component
public class MeasurementKeywordRepositoryImpl implements MeasurementKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementKeywordRepositoryImpl.class);
	
	@Autowired
	private MeasurementKeywordCrudRepository measurementKeywordCrudRepository;

	@Override
	public void delete(MeasurementKeyword entity) {
		measurementKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MeasurementKeyword> entities) {
		measurementKeywordCrudRepository.save(entities);
	}

	@Override
	public Iterable<MeasurementKeyword> save(Iterable<MeasurementKeyword> entities) {
		return measurementKeywordCrudRepository.save(entities);
	}

	@Override
	public MeasurementKeyword save(MeasurementKeyword entity) {
		return measurementKeywordCrudRepository.save(entity);
	}

	@Override
	public List<MeasurementKeyword> findByMeasurement(Measurement measurement) {
		return measurementKeywordCrudRepository.findByMeasurement(measurement);
	}

}
