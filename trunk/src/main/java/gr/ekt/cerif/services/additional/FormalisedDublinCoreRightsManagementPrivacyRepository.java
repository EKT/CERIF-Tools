package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPrivacy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for FormalisedDublinCoreRightsManagementPrivacy.
 * 
 */
@Component
public class FormalisedDublinCoreRightsManagementPrivacyRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(FormalisedDublinCoreRightsManagementPrivacy entity) {
		if (entity.getId() == null || entity.getScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a dc, a translation and a language.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<FormalisedDublinCoreRightsManagementPrivacy> entityList) {
		for (FormalisedDublinCoreRightsManagementPrivacy entity : entityList) {
			save(entity);
		}
	}
}

