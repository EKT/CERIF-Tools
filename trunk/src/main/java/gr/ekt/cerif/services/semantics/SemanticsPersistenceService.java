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
	public CerifSemanticFeature save(CerifSemanticFeature entity) {
		if (entity instanceof gr.ekt.cerif.features.semantics.Class) {
			entity = classRepository.save((gr.ekt.cerif.features.semantics.Class)entity);
		} else if (entity instanceof ClassScheme) {
			entity = classSchemeRepository.save((ClassScheme)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid semantic feature provided. %s", entity));
		}
		return entity;
	}

	/**
	 * Saves the provided semantic features.
	 * @param entity The semantic features.
	 */
	@SuppressWarnings("unchecked")
	public Iterable<? extends CerifSemanticFeature> save(Iterable<? extends CerifSemanticFeature> entityList) {
		
		final CerifSemanticFeature entity = (CerifSemanticFeature) entityList.iterator().next();
		
		if (entity instanceof gr.ekt.cerif.features.semantics.Class) {
			entityList = classRepository.save((List<gr.ekt.cerif.features.semantics.Class>) entityList);
		} else if (entity instanceof ClassScheme) {
			entityList = classSchemeRepository.save((List<ClassScheme>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of semantic features provided. %s", entity));
		}
		
		return entityList;
		
	}

	/**
	 * @return the classRepository
	 */
	public ClassRepository getClassRepository() {
		return classRepository;
	}

	/**
	 * @return the classSchemeRepository
	 */
	public ClassSchemeRepository getClassSchemeRepository() {
		return classSchemeRepository;
	}


	
}
