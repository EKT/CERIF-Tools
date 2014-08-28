package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Indicator_Measurement;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkIndicatorMeasurementRepositoryImpl implements LinkIndicatorMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkIndicatorMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkIndicatorMeasurementCrudRepository linkIndicatorMeasurementCrudRepository;

	@Override
	public void delete(Indicator_Measurement entity) {
		linkIndicatorMeasurementCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Indicator_Measurement> entities) {
		linkIndicatorMeasurementCrudRepository.save(entities);		
	}

	@Override
	public Iterable<Indicator_Measurement> save(
			Iterable<Indicator_Measurement> entities) {
		return linkIndicatorMeasurementCrudRepository.save(entities);
	}

	@Override
	public Indicator_Measurement save(Indicator_Measurement entity) {
		return linkIndicatorMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<Indicator_Measurement> findByMeasurement(Measurement measurement) {
		return linkIndicatorMeasurementCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<Indicator_Measurement> findByIndicator(Indicator indicator) {
		return linkIndicatorMeasurementCrudRepository.findByIndicator(indicator);
	}

}
