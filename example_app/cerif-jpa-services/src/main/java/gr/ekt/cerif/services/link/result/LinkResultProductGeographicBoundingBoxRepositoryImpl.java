package gr.ekt.cerif.services.link.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;

@Component
public class LinkResultProductGeographicBoundingBoxRepositoryImpl implements
		LinkResultProductGeographicBoundingBoxRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkResultProductGeographicBoundingBoxRepositoryImpl.class);
	
	@Autowired
	private LinkResultProductGeographicBoundingBoxCrudRepository linkResultProductGeographicBoundingBoxCrudRepository;

	@Override
	public void delete(ResultProduct_GeographicBoundingBox entity) {
		linkResultProductGeographicBoundingBoxCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProduct_GeographicBoundingBox> entities) {
		linkResultProductGeographicBoundingBoxCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProduct_GeographicBoundingBox> save(
			Iterable<ResultProduct_GeographicBoundingBox> entities) {
		return linkResultProductGeographicBoundingBoxCrudRepository.save(entities);
	}

	@Override
	public ResultProduct_GeographicBoundingBox save(
			ResultProduct_GeographicBoundingBox entity) {
		return linkResultProductGeographicBoundingBoxCrudRepository.save(entity);
	}

}
