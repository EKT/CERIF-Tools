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
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

/**
 * @author bonisv
 *
 */
@Component
public class ClassExRepositoryImpl implements ClassExRepository {

	private static final Logger log = LoggerFactory.getLogger(ClassExRepositoryImpl.class);
	
	@Autowired
	private ClassExCrudRepository classExCrudRepository;
	
	@Override
	public void delete(ClassEx entity) {
		classExCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ClassEx> entities) {
		classExCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ClassEx> save(Iterable<ClassEx> entities) {
		return classExCrudRepository.save(entities);
	}

	@Override
	public ClassEx save(ClassEx entity) {
		return classExCrudRepository.save(entity);
	}

	@Override
	public List<ClassEx> findByTheClass(Class theClass) {
		return classExCrudRepository.findByTheClass(theClass);
	}

	@Override
	public List<ClassEx> findByExAndClassSchemeAndTranslationAndLanguage(
			String example, ClassScheme scheme, Translation tra, Language lan) {
		return classExCrudRepository.findByExAndClassSchemeAndTranslationAndLanguage(example, scheme, tra, lan);
	}

	@Override
	public List<ClassEx> findByTheClassAndExAndClassSchemeAndTranslationAndLanguage(
			Class theClass, String example, ClassScheme scheme,
			Translation tra, Language lan) {
		return classExCrudRepository.findByTheClassAndExAndClassSchemeAndTranslationAndLanguage(theClass, example, scheme, tra, lan);
	}

}
