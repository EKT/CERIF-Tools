package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and classes.
 * 
 */
@Component
public class LinkResultPublicationClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(ResultPublication_Class entity) {
		if (entity.getResultPublication() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a class.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Class> entityList) {
		for (ResultPublication_Class entity : entityList) {
			save(entity);
		}
	}
	
}
