/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.OrganisationUnitTranslation;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for organisation unit name entities.
 * 
 * 
 */
@Component
public class OrganisationUnitTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationUnitRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(OrganisationUnitTranslation entity) {
		if (entity.getOrganisationUnit() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide an organisation unit, a translation and a language.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationUnitRepository.save(entity.getOrganisationUnit());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnitTranslation> entityList) {
		for (OrganisationUnitTranslation entity : entityList) {
			save(entity);
		}
	}
}
