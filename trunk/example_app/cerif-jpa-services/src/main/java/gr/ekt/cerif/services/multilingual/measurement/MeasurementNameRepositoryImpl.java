/**
 * 
 */
package gr.ekt.cerif.services.multilingual.measurement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.MeasurementName;

/**
 * @author bonisv
 *
 */
@Component
public class MeasurementNameRepositoryImpl implements MeasurementNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementNameRepositoryImpl.class);
	
	@Autowired
	private MeasurementNameCrudRepository measurementNameCrudRepository;

	@Override
	public void delete(MeasurementName entity) {
		measurementNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MeasurementName> entities) {
		measurementNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MeasurementName> save(Iterable<MeasurementName> entities) {
		return measurementNameCrudRepository.save(entities);
	}

	@Override
	public MeasurementName save(MeasurementName entity) {
		return measurementNameCrudRepository.save(entity);
	}

}
