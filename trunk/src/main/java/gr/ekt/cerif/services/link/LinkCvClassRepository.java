package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.services.second.CVRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between cvs and classes.
 * 
 */
@Component
public class LinkCvClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private CVRepository cvRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public Cv_Class save(Cv_Class entity) {
		if (entity.getCv() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a cv and a class.");
		}
		if (entity.getCv().getId() == null) {
			cvRepository.save(entity.getCv());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<Cv_Class> save(Iterable<Cv_Class> entityList) {
		for (Cv_Class entity : entityList) {
			save(entity);
		}
		return entityList; 
	}
	
}
