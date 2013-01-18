package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between classSchemes.
 * 
 */
@Component
public class LinkClassSchemeClassSchemeRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ClassSchemeRepository classSchemeRepository;
	
	@Transactional
	public ClassScheme_ClassScheme save(ClassScheme_ClassScheme entity) {
		if (entity.getClassScheme1() == null || entity.getClassScheme2() == null) {
			throw new IllegalArgumentException("Please provide both classSchemes.");
		}
		if (entity.getClassScheme1().getId() == null) {
			classSchemeRepository.save(entity.getClassScheme1());
		}
		if (entity.getClassScheme2().getId() == null) {
			classSchemeRepository.save(entity.getClassScheme2());
		}
		return entityManager.merge(entity);
	}
	
	@Transactional
	public Iterable<ClassScheme_ClassScheme> save(Iterable<ClassScheme_ClassScheme> entityList) {
		for (ClassScheme_ClassScheme entity : entityList) {
			save(entity);
		}
		return entityList;
	}
	
}
