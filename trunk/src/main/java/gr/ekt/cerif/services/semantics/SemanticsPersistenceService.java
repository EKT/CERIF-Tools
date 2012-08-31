/**
 * 
 */
package gr.ekt.cerif.services.semantics;

import gr.ekt.cerif.features.semantics.CerifSemanticFeature;
import gr.ekt.cerif.features.semantics.ClassScheme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF Semantic Features.
 * 
 */
@Component
public class SemanticsPersistenceService {
	
	/**
	 * The repository for classification classes.
	 */
	@Autowired
	private ClassRepository classRepository;
	
	/**
	 * The repository for classification schemes.
	 */
	@Autowired
	private ClassSchemeService classSchemeService;

	@Autowired
	private ClassSchemeRepository classSchemeRepository;

	/**
	 * Deletes the provided semantic feature.
	 * @param feature The semantic feature.
	 */
	public void delete(CerifSemanticFeature feature) {
		if (feature instanceof gr.ekt.cerif.features.semantics.Class) {
			classRepository.delete((gr.ekt.cerif.features.semantics.Class)feature);
		} else if (feature instanceof ClassScheme) {
			classSchemeRepository.delete((ClassScheme)feature);
		} else {
			throw new IllegalArgumentException(String.format("Invalid semantic feature provided. %s", feature));
		}
	}
	
	/**
	 * Saves the provided semantic feature.
	 * @param feature The semantic feature.
	 */
	public void save(CerifSemanticFeature feature) {
		if (feature instanceof gr.ekt.cerif.features.semantics.Class) {
			classRepository.save((gr.ekt.cerif.features.semantics.Class)feature);
		} else if (feature instanceof ClassScheme) {
			classSchemeService.save((ClassScheme)feature);
		} else {
			throw new IllegalArgumentException(String.format("Invalid semantic feature provided. %s", feature));
		}
	}

	/**
	 * Saves the provided semantic features.
	 * @param entity The semantic features.
	 */
	@SuppressWarnings("unchecked")
	public void save(List<? extends CerifSemanticFeature> featureList) {
		
		final CerifSemanticFeature entity = (CerifSemanticFeature)featureList.get(0);
		
		if (entity instanceof gr.ekt.cerif.features.semantics.Class) {
			classRepository.save((List<gr.ekt.cerif.features.semantics.Class>)featureList);
		} else if (entity instanceof ClassScheme) {
			classSchemeService.save((List<ClassScheme>)featureList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of semantic features provided. %s", entity));
		}
		
	}	

	/**
	 * @return the classRepository
	 */
	public ClassRepository getClassRepository() {
		return classRepository;
	}

	/**
	 * @return the classSchemeService
	 */
	public ClassSchemeService getClassSchemeService() {
		return classSchemeService;
	}

	/**
	 * @return the classSchemeRepository
	 */
	public ClassSchemeRepository getClassSchemeRepository() {
		return classSchemeRepository;
	}


	
}
