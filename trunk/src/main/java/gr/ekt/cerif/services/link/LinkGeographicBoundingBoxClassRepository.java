package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.GeographicBoundingBox_Class;
import gr.ekt.cerif.services.second.GeographicBoundingBoxRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between geographic bounding boxes and classes.
 * 
 */
@Component
public class LinkGeographicBoundingBoxClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private GeographicBoundingBoxRepository geographicBoundingBoxRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(GeographicBoundingBox_Class entity) {
		if (entity.getGeographicBoundingBox() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a geographicBoundingBox and a class.");
		}
		if (entity.getGeographicBoundingBox().getId() == null) {
			geographicBoundingBoxRepository.save(entity.getGeographicBoundingBox());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<GeographicBoundingBox_Class> entityList) {
		for (GeographicBoundingBox_Class entity : entityList) {
			save(entity);
		}
	}
	
}
