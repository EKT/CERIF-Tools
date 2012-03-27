package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Language_Class;
import gr.ekt.cerif.services.second.LanguageRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between languages and classes.
 * 
 */
@Component
public class LinkLanguageClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Language_Class entity) {
		if (entity.getLanguage() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a language and a class.");
		}
		if (entity.getLanguage().getCode() == null) {
			languageRepository.save(entity.getLanguage());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Language_Class> entityList) {
		for (Language_Class entity : entityList) {
			save(entity);
		}
	}
	
}
