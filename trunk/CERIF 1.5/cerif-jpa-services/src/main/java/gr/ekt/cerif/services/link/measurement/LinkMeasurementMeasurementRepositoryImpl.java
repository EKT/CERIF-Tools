package gr.ekt.cerif.services.link.measurement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Measurement_Measurement;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkMeasurementMeasurementRepositoryImpl implements LinkMeasurementMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMeasurementMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkMeasurementMeasurementCrudRepository linkMeasurementMeasurementCrudRepository;

	@Override
	public void delete(Measurement_Measurement entity) {
		linkMeasurementMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Measurement_Measurement> entities) {
		linkMeasurementMeasurementCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Measurement_Measurement> save(
			Iterable<Measurement_Measurement> entities) {
		return linkMeasurementMeasurementCrudRepository.save(entities);
	}

	@Override
	public Measurement_Measurement save(Measurement_Measurement entity) {
		return linkMeasurementMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<Measurement_Measurement> findByMeasurement1(
			Measurement measurement) {
		return linkMeasurementMeasurementCrudRepository.findByMeasurement1(measurement);
	}

	@Override
	public List<Measurement_Measurement> findByMeasurement2(
			Measurement measurement) {
		return linkMeasurementMeasurementCrudRepository.findByMeasurement2(measurement);
	}

}
