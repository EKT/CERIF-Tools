package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreRelation;

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
public class DublinCoreRelationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(DublinCoreRelation entity) {
		if (entity.getId1() == null || entity.getScheme1() == null || entity.getId2() == null || entity.getScheme2() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a dc, a translation and a language.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<DublinCoreRelation> entityList) {
		for (DublinCoreRelation entity : entityList) {
			save(entity);
		}
	}
}

