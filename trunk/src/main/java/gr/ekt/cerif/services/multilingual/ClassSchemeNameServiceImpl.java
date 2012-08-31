/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ClassSchemeName;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeService;

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
public class ClassSchemeNameServiceImpl implements ClassSchemeNameService{

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ClassSchemeService classSchemeService;
	
	@Autowired
	LanguageRepository languageRepository;

	@Override
	@Transactional
	public void save(ClassSchemeName entity) {
		if (entity.getClassScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a class scheme, a translation and a language.");
		}
		if (entity.getClassScheme().getId() == null) {
			classSchemeService.save(entity.getClassScheme());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public void save(List<? extends ClassSchemeName> entities) {
		for (ClassSchemeName entity : entities) {
			save(entity);
		}
	}

}


