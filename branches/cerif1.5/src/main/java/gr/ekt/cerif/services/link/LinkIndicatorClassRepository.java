package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.services.second.IndicatorRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between indicators and classes.
 * 
 */
@Component
public class LinkIndicatorClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private IndicatorRepository indicatorRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Indicator_Class entity) {
		if (entity.getIndicator() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a indicator and a class.");
		}
		if (entity.getIndicator().getId() == null) {
			indicatorRepository.save(entity.getIndicator());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Indicator_Class> entityList) {
		for (Indicator_Class entity : entityList) {
			save(entity);
		}
	}
	
}
