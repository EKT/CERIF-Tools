package gr.ekt.cerif.services.link.measurement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Measurement_Class;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkMeasurementClassRepositoryImpl implements LinkMeasurementClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMeasurementClassRepositoryImpl.class);
	
	@Autowired
	private LinkMeasurementClassCrudRepository linkMeasurementClassCrudRepository;

	@Override
	public void delete(Measurement_Class entity) {
		linkMeasurementClassCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Measurement_Class> entities) {
		linkMeasurementClassCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Measurement_Class> save(Iterable<Measurement_Class> entities) {
		return linkMeasurementClassCrudRepository.save(entities);
	}

	@Override
	public Measurement_Class save(Measurement_Class entity) {
		return linkMeasurementClassCrudRepository.save(entity);
	}

	@Override
	public List<Measurement_Class> findByMeasurement(Measurement measurement) {
		return linkMeasurementClassCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<Measurement_Class> findBytheClass(Class theClass) {
		return linkMeasurementClassCrudRepository.findBytheClass(theClass);
	}

}
