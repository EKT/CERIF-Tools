package gr.ekt.cerif.services.link.result;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkResultProductMeasurementRepositoryImpl implements
		LinkResultProductMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductMeasurementCrudRepository linkResultProductMeasurementCrudRepository;

	@Override
	public void delete(ResultProduct_Measurement entity) {
		linkResultProductMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_Measurement> entities) {
		linkResultProductMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_Measurement> save(
			Iterable<ResultProduct_Measurement> entities) {
		return linkResultProductMeasurementCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_Measurement save(ResultProduct_Measurement entity) {
		return linkResultProductMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<ResultProduct_Measurement> findByMeasurement(
			Measurement measurement) {
		return linkResultProductMeasurementCrudRepository.findByMeasurement(measurement);
	}

	@Override
	public List<ResultProduct_Measurement> findByResultProduct(
			ResultProduct resultProduct) {
		return linkResultProductMeasurementCrudRepository.findByResultProduct(resultProduct);
	}

}
