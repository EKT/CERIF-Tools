package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for dublin core relation.
 * 
 */
@Component
public class DublinCoreRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(DublinCore entity) {
		if (entity.getId() == null || entity.getScheme() == null) {
			throw new IllegalArgumentException("Please provide a dc.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<DublinCore> entityList) {
		for (DublinCore entity : entityList) {
			save(entity);
		}
	}
}

