package gr.ekt.cerif.services.link.indicator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Indicator_Measurement;

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

}
