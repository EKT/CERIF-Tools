package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Class_Class;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between classs and classes.
 * 
 */
@Component
public class LinkClassClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Class_Class entity) {
		if (entity.getTheClass1() == null || entity.getTheClass2() == null) {
			throw new IllegalArgumentException("Please provide both classes.");
		}
		if (entity.getTheClass1().getId() == null) {
			classRepository.save(entity.getTheClass1());
		}
		if (entity.getTheClass2().getId() == null) {
			classRepository.save(entity.getTheClass2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Class_Class> entityList) {
		for (Class_Class entity : entityList) {
			save(entity);
		}
	}
	
}
