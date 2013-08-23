package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;

@Component
public class LinkProductGeographicBoundingBoxRepositoryImpl implements
		LinkProductGeographicBoundingBoxRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkProductGeographicBoundingBoxRepositoryImpl.class);
	
	@Autowired
	private LinkProductGeographicBoundingBoxCrudRepository linkProductGeographicBoundingBoxCrudRepository;

	@Override
	public void delete(ResultProduct_GeographicBoundingBox entity) {
		linkProductGeographicBoundingBoxCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_GeographicBoundingBox> entities) {
		linkProductGeographicBoundingBoxCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_GeographicBoundingBox> save(
			Iterable<ResultProduct_GeographicBoundingBox> entities) {
		return linkProductGeographicBoundingBoxCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_GeographicBoundingBox save(
			ResultProduct_GeographicBoundingBox entity) {
		return linkProductGeographicBoundingBoxCrudRepository.save(entity);
	}

}
