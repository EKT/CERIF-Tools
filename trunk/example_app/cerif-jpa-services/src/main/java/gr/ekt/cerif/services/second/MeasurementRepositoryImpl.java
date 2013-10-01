/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Measurement;

/**
 * @author bonisv
 *
 */
@Component
public class MeasurementRepositoryImpl implements MeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MeasurementRepositoryImpl.class);

	@Autowired
	private MeasurementCrudRepository measurementCrudRepository;

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#delete(gr.ekt.cerif.entities.second.Measurement)
	 */
	@Override
	public void delete(Measurement entity) {
		measurementCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Measurement> entities) {
		measurementCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Measurement> save(Iterable<Measurement> entities) {
		return measurementCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.MeasurementRepository#save(gr.ekt.cerif.entities.second.Measurement)
	 */
	@Override
	public Measurement save(Measurement entity) {
		return measurementCrudRepository.save(entity);
	}

}
