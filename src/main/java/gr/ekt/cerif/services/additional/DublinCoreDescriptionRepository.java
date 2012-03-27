package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreDescription;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for dublin core contributor.
 * 
 */
@Component
public class DublinCoreDescriptionRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(DublinCoreDescription entity) {
		if (entity.getId() == null || entity.getScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a dc, a translation and a language.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<DublinCoreDescription> entityList) {
		for (DublinCoreDescription entity : entityList) {
			save(entity);
		}
	}
}

