/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;

/**
 * @author bonisv
 *
 */
@Component
public class GeographicBoundingBoxRepositoryImpl implements GeographicBoundingBoxRepository {

	private static final Logger log = LoggerFactory.getLogger(GeographicBoundingBoxRepositoryImpl.class);
	
	@Autowired
	private GeographicBoundingBoxCrudRepository geographicBoundingBoxCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.GeographicBoundingBoxRepository#delete(gr.ekt.cerif.entities.second.GeographicBoundingBox)
	 */
	@Override
	public void delete(GeographicBoundingBox entity) {
		geographicBoundingBoxCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.GeographicBoundingBoxRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<GeographicBoundingBox> entities) {
		geographicBoundingBoxCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.GeographicBoundingBoxRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<GeographicBoundingBox> save(Iterable<GeographicBoundingBox> entities) {
		return geographicBoundingBoxCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.GeographicBoundingBoxRepository#save(gr.ekt.cerif.entities.second.GeographicBoundingBox)
	 */
	@Override
	public GeographicBoundingBox save(GeographicBoundingBox entity) {
		return geographicBoundingBoxCrudRepository.save(entity);
	}

	@Override
	public List<GeographicBoundingBox> findAll() {
		return geographicBoundingBoxCrudRepository.findAll();
	}

	@Override
	public Page<GeographicBoundingBox> findAll(Pageable page) {
		return geographicBoundingBoxCrudRepository.findAll(page);
	}

	@Override
	public GeographicBoundingBox findById(Long id) {
		return geographicBoundingBoxCrudRepository.findById(id);
	}

	@Override
	public List<GeographicBoundingBox> findByUri(String uri) {
		return geographicBoundingBoxCrudRepository.findByUri(uri);
	}

	@Override
	public GeographicBoundingBox findByUuid(String uuid) {
		return geographicBoundingBoxCrudRepository.findByUuid(uuid);
	}

}
