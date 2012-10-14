package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Medium_Class;
import gr.ekt.cerif.services.second.MediumRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between mediums and classes.
 * 
 */
@Component
public class LinkMediumClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Medium_Class entity) {
		if (entity.getMedium() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a medium and a class.");
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Medium_Class> entityList) {
		for (Medium_Class entity : entityList) {
			save(entity);
		}
	}
	
}
