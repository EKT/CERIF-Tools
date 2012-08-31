package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassSchemeRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A repository for class scheme translation entities.
 * 
 */
@Component
public abstract class ClassSchemeDescriptionRepositoryImpl implements ClassSchemeDescriptionRepository{

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ClassSchemeRepository classSchemeRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	public ClassSchemeDescription save(ClassSchemeDescription entity) {
		if (entity.getClassScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a class scheme, a translation and a language.");
		}
		if (entity.getClassScheme().getId() == null) {
			classSchemeRepository.save(entity.getClassScheme());
		}
		languageRepository.save(entity.getLanguage());
		return entityManager.merge(entity);
	}
	
	public void save(List<ClassSchemeDescription> entityList) {
		for (ClassSchemeDescription entity : entityList) {
			save(entity);
		}
	}

}
