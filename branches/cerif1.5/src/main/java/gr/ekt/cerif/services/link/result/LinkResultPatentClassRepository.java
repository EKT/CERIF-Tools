package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and classes.
 * 
 */
@Component
public class LinkResultPatentClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(ResultPatent_Class entity) {
		if (entity.getResultPatent() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a class.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Class> entityList) {
		for (ResultPatent_Class entity : entityList) {
			save(entity);
		}
	}
	
}
