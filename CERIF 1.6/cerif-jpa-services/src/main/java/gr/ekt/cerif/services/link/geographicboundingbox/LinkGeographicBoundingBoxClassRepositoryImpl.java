package gr.ekt.cerif.services.link.geographicboundingbox;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkGeographicBoundingBoxClassRepositoryImpl implements
		LinkGeographicBoundingBoxClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkGeographicBoundingBoxClassRepositoryImpl.class);
	
	@Autowired
	private LinkGeographicBoundingBoxClassCrudRepository linkGeographicBoundingBoxClassCrudRepository;

	@Override
	public void delete(GeographicBoundingBox_Class entity) {
		linkGeographicBoundingBoxClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<GeographicBoundingBox_Class> entities) {
		linkGeographicBoundingBoxClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBox_Class> save(
			Iterable<GeographicBoundingBox_Class> entities) {
		return linkGeographicBoundingBoxClassCrudRepository.save(entities);
	}

	@Override
	public GeographicBoundingBox_Class save(GeographicBoundingBox_Class entity) {
		return linkGeographicBoundingBoxClassCrudRepository.save(entity);
	}

	@Override
	public List<GeographicBoundingBox_Class> findByGeographicBoundingBox(
			GeographicBoundingBox geographicBoundingBox) {
		return linkGeographicBoundingBoxClassCrudRepository.findByGeographicBoundingBox(geographicBoundingBox);
	}

	@Override
	public List<GeographicBoundingBox_Class> findByTheClass(Class theClass) {
		return linkGeographicBoundingBoxClassCrudRepository.findByTheClass(theClass);
	}

}
