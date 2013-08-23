/**
 * 
 */
package gr.ekt.cerif.services.multilingual.geographicboundingbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.GeographicBoundingBoxKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class GeographicBoundingBoxKeywordRepositoryImpl implements GeographicBoundingBoxKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(GeographicBoundingBoxKeywordRepositoryImpl.class);
	
	@Autowired
	private GeographicBoundingBoxKeywordCrudRepository geographicBoundingBoxKeywordCrudRepository;

	@Override
	public void delete(GeographicBoundingBoxKeyword entity) {
		geographicBoundingBoxKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<GeographicBoundingBoxKeyword> entities) {
		geographicBoundingBoxKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<GeographicBoundingBoxKeyword> save(Iterable<GeographicBoundingBoxKeyword> entities) {
		return geographicBoundingBoxKeywordCrudRepository.save(entities);
	}

	@Override
	public GeographicBoundingBoxKeyword save(GeographicBoundingBoxKeyword entity) {
		return geographicBoundingBoxKeywordCrudRepository.save(entity);
	}

}
