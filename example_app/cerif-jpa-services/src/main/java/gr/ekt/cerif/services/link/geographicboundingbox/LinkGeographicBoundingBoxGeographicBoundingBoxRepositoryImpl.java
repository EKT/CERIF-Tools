package gr.ekt.cerif.services.link.geographicboundingbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;

@Component
public class LinkGeographicBoundingBoxGeographicBoundingBoxRepositoryImpl
		implements LinkGeographicBoundingBoxGeographicBoundingBoxRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkGeographicBoundingBoxGeographicBoundingBoxRepositoryImpl.class);
	
	@Autowired
	private LinkGeographicBoundingBoxGeographicBoundingBoxCrudRepository linkGeographicBoundingBoxGeographicBoundingBoxCrudRepository;

	@Override
	public void delete(GeographicBoundingBox_GeographicBoundingBox entity) {
		linkGeographicBoundingBoxGeographicBoundingBoxCrudRepository.delete(entity);
	}

	@Override
	public void delete(
			Iterable<GeographicBoundingBox_GeographicBoundingBox> entities) {
		linkGeographicBoundingBoxGeographicBoundingBoxCrudRepository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBox_GeographicBoundingBox> save(
			Iterable<GeographicBoundingBox_GeographicBoundingBox> entities) {
		return linkGeographicBoundingBoxGeographicBoundingBoxCrudRepository.save(entities);
	}

	@Override
	public GeographicBoundingBox_GeographicBoundingBox save(
			GeographicBoundingBox_GeographicBoundingBox entity) {
		return linkGeographicBoundingBoxGeographicBoundingBoxCrudRepository.save(entity);
	}

}
