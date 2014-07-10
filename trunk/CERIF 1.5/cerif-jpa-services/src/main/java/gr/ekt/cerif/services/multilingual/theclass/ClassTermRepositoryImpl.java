package gr.ekt.cerif.services.multilingual.theclass;

import java.util.List;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ClassTerm;
import gr.ekt.cerif.features.multilingual.Translation;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.base.ProjectRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassTermRepositoryImpl implements ClassTermRepository {

	private static final Logger log = LoggerFactory.getLogger(ClassTermRepositoryImpl.class);
	
	@Autowired
	private ClassTermCrudRepository classTermCrudRepository;
	
	@Override
	public ClassTerm findByTerm(String term) {
		return classTermCrudRepository.findByTerm(term);
	}

	@Override
	public void delete(ClassTerm entity) {
		classTermCrudRepository.delete(entity);		
	}

	@Override
	public Iterable<ClassTerm> save(Iterable<ClassTerm> entityList) {
		return classTermCrudRepository.save(entityList);
	}

	@Override
	public ClassTerm save(ClassTerm entity) {
		return classTermCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ClassTerm> entities) {
		classTermCrudRepository.delete(entities);		
	}

	@Override
	public List<ClassTerm> findByTheClass(Class theClass) {
		return classTermCrudRepository.findByTheClass(theClass);
	}

	@Override
	public ClassTerm findByTheClassAndClassSchemeAndLanguageAndTranslation(
			Class theClass, ClassScheme classScheme, Language language,
			Translation translation) {
		return classTermCrudRepository.findByTheClassAndClassSchemeAndLanguageAndTranslation(theClass, classScheme, language, translation);
	}

	@Override
	public List<ClassTerm> findByTermAndClassSchemeAndTranslationAndLanguage(
			String term, ClassScheme scheme, Translation tra, Language lan) {
		return classTermCrudRepository.findByTermAndClassSchemeAndTranslationAndLanguage(term, scheme, tra, lan);
	}

}
