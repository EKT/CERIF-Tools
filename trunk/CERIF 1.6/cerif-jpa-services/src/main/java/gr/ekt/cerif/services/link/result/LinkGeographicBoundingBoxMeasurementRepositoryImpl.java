package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Measurement;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Measurement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkGeographicBoundingBoxMeasurementRepositoryImpl implements LinkGeographicBoundingBoxMeasurementRepository {
	
	@Autowired
	private LinkGeographicBoundingBoxMeasurementCrudRepository repository;

	@Override
	public void delete(GeographicBoundingBox_Measurement entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<GeographicBoundingBox_Measurement> entities) {
		repository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBox_Measurement> save(
			Iterable<GeographicBoundingBox_Measurement> entities) {
		return repository.save(entities);
	}

	@Override
	public GeographicBoundingBox_Measurement save(GeographicBoundingBox_Measurement entity) {
		return repository.save(entity);
	}

	@Override
	public List<GeographicBoundingBox_Measurement> findByMeasurement(Measurement measurement) {
		return repository.findByMeasurement(measurement);
	}

	@Override
	public List<GeographicBoundingBox_Measurement> findByGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox) {
		return repository.findByGeographicBoundingBox(geographicBoundingBox);
	}

}
