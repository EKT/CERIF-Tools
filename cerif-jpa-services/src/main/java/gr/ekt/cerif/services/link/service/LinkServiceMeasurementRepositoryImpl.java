package gr.ekt.cerif.services.link.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Service_Measurement;

@Component
public class LinkServiceMeasurementRepositoryImpl implements
		LinkServiceMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServiceMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkServiceMeasurementCrudRepository linkServiceMeasurementCrudRepository;

	@Override
	public void delete(Service_Measurement entity) {
		linkServiceMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_Measurement> entities) {
		linkServiceMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_Measurement> save(
			Iterable<Service_Measurement> entities) {
		return linkServiceMeasurementCrudRepository.save(entities);
	}

	@Override
	public Service_Measurement save(Service_Measurement entity) {
		return linkServiceMeasurementCrudRepository.save(entity);
	}

}
