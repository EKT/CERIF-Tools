/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

	@Override
	public List<Measurement> findAll() {
		return measurementCrudRepository.findAll();
	}

	@Override
	public Page<Measurement> findAll(Pageable page) {
		return measurementCrudRepository.findAll(page);
	}

	@Override
	public Measurement findByUuid(String uuid) {
		return measurementCrudRepository.findByUuid(uuid);
	}
	
	@Override
	public Measurement findById(Long id) {
		return measurementCrudRepository.findById(id);
	}

	@Override
	public List<Measurement> findByUri(String uri) {
		return measurementCrudRepository.findByUri(uri);
	}

}
