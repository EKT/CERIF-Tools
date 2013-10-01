/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxDescription;

/**
 * @author bonisv
 *
 */
@Component
public class GeographicBoundingBoxDescriptionRepositoryImpl implements GeographicBoundingBoxDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(GeographicBoundingBoxDescriptionRepositoryImpl.class);
	
	@Autowired
	private GeographicBoundingBoxDescriptionCrudRepository geographicBoundingBoxDescriptionCrudRepository;

	@Override
	public void delete(GeographicBoundingBoxDescription entity) {
		geographicBoundingBoxDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<GeographicBoundingBoxDescription> entities) {
		geographicBoundingBoxDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBoxDescription> save(Iterable<GeographicBoundingBoxDescription> entities) {
		return geographicBoundingBoxDescriptionCrudRepository.save(entities);
	}

	@Override
	public GeographicBoundingBoxDescription save(GeographicBoundingBoxDescription entity) {
		return geographicBoundingBoxDescriptionCrudRepository.save(entity);
	}

}
