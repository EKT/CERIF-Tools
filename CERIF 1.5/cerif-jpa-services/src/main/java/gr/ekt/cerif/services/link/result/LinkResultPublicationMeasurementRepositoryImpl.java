package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkResultPublicationMeasurementRepositoryImpl implements
		LinkResultPublicationMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultPublicationMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkResultPublicationMeasurementCrudRepository linkResultPublicationMeasurementCrudRepository;

	@Override
	public void delete(ResultPublication_Measurement entity) {
		linkResultPublicationMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication_Measurement> entities) {
		linkResultPublicationMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublication_Measurement> save(
			Iterable<ResultPublication_Measurement> entities) {
		return linkResultPublicationMeasurementCrudRepository.save(entities);
	}

	@Override
	public ResultPublication_Measurement save(
			ResultPublication_Measurement entity) {
		return linkResultPublicationMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublication_Measurement> findByMeasurement(
			Measurement measurement) {
		return linkResultPublicationMeasurementCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<ResultPublication_Measurement> findByResultPublication(
			ResultPublication resultPublication) {
		return linkResultPublicationMeasurementCrudRepository.findByResultPublication(resultPublication);
	}

}
