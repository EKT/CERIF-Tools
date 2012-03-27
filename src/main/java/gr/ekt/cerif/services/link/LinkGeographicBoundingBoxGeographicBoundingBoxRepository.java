package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_GeographicBoundingBox;
import gr.ekt.cerif.services.second.GeographicBoundingBoxRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between geographic bounding boxes.
 * 
 */
@Component
public class LinkGeographicBoundingBoxGeographicBoundingBoxRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	@Transactional
	public void save(GeographicBoundingBox_GeographicBoundingBox entity) {
		if (entity.getGeographicBoundingBox1() == null || entity.getGeographicBoundingBox2() == null) {
			throw new IllegalArgumentException("Please provide both geographicBoundingBoxes.");
		}
		if (entity.getGeographicBoundingBox1().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox1());
		}
		if (entity.getGeographicBoundingBox2().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<GeographicBoundingBox_GeographicBoundingBox> entityList) {
		for (GeographicBoundingBox_GeographicBoundingBox entity : entityList) {
			save(entity);
		}
	}
	
}
