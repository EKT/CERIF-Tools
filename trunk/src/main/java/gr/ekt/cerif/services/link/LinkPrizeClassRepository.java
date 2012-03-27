package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.services.second.PrizeRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between facilities and classes.
 * 
 */
@Component
public class LinkPrizeClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PrizeRepository prizeRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Prize_Class entity) {
		if (entity.getPrize() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a prize and a class.");
		}
		if (entity.getPrize().getId() == null) {
			prizeRepository.save(entity.getPrize());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Prize_Class> entityList) {
		for (Prize_Class entity : entityList) {
			save(entity);
		}
	}
	
}
