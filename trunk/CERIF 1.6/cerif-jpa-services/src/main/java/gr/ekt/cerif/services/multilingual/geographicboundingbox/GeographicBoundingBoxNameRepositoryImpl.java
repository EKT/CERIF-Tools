/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxName;

/**
 * @author bonisv
 *
 */
@Component
public class GeographicBoundingBoxNameRepositoryImpl implements GeographicBoundingBoxNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(GeographicBoundingBoxNameRepositoryImpl.class);
	
	@Autowired
	private GeographicBoundingBoxNameCrudRepository geographicBoundingBoxNameCrudRepository;

	@Override
	public void delete(GeographicBoundingBoxName entity) {
		geographicBoundingBoxNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<GeographicBoundingBoxName> entities) {
		geographicBoundingBoxNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBoxName> save(Iterable<GeographicBoundingBoxName> entities) {
		return geographicBoundingBoxNameCrudRepository.save(entities);
	}

	@Override
	public GeographicBoundingBoxName save(GeographicBoundingBoxName entity) {
		return geographicBoundingBoxNameCrudRepository.save(entity);
	}

	@Override
	public List<GeographicBoundingBoxName> findByGeographicBoundingBox(
			GeographicBoundingBox geographicBoundingBox) {
		return geographicBoundingBoxNameCrudRepository.findByGeographicBoundingBox(geographicBoundingBox);
	}

}
