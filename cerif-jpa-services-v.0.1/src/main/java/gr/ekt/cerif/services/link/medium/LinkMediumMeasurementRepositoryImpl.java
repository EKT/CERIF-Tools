package gr.ekt.cerif.services.link.medium;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Medium_Measurement;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;

@Component
public class LinkMediumMeasurementRepositoryImpl implements
		LinkMediumMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMediumMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkMediumMeasurementCrudRepository linkMediumMeasurementCrudRepository;

	@Override
	public void delete(Medium_Measurement entity) {
		linkMediumMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Medium_Measurement> entities) {
		linkMediumMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Medium_Measurement> save(
			Iterable<Medium_Measurement> entities) {
		return linkMediumMeasurementCrudRepository.save(entities);
	}

	@Override
	public Medium_Measurement save(Medium_Measurement entity) {
		return linkMediumMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<Medium_Measurement> findByMeasurement(Measurement measurement) {
		return linkMediumMeasurementCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<Medium_Measurement> findByMedium(Medium medium) {
		return linkMediumMeasurementCrudRepository.findByMedium(medium);
	}

}
