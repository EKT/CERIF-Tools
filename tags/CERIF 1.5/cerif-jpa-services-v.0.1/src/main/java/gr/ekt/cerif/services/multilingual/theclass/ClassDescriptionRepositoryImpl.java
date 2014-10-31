/**
 * 
 */
package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * @author bonisv
 *
 */
@Component
public class ClassDescriptionRepositoryImpl implements ClassDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(ClassDescriptionRepositoryImpl.class);
	
	@Autowired
	private ClassDescriptionCrudRepository classDescriptionCrudRepository;
	
	@Override
	public void delete(ClassDescription entity) {
		classDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ClassDescription> entities) {
		classDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ClassDescription> save(Iterable<ClassDescription> entities) {
		return classDescriptionCrudRepository.save(entities);
	}

	@Override
	public ClassDescription save(ClassDescription entity) {
		return classDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<ClassDescription> findByTheClass(Class theClass) {
		return classDescriptionCrudRepository.findByTheClass(theClass);
	}

	@Override
	public List<ClassDescription> findByDescriptionAndClassSchemeAndTranslationAndLanguage(
			String description, ClassScheme scheme, Translation tra,
			Language lan) {
		return classDescriptionCrudRepository.findByDescriptionAndClassSchemeAndTranslationAndLanguage(description, scheme, tra, lan);
	}

	@Override
	public List<ClassDescription> findByTheClassAndDescriptionAndClassSchemeAndTranslationAndLanguage(
			Class theClass, String description, ClassScheme scheme,
			Translation tra, Language lan) {
		return classDescriptionCrudRepository.findByTheClassAndDescriptionAndClassSchemeAndTranslationAndLanguage(theClass, description, scheme, tra, lan);
	}

}
