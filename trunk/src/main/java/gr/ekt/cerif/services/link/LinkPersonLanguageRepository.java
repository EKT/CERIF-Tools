package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.person.Person_Language;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between persons and languages.
 * 
 */
@Component
public class LinkPersonLanguageRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Transactional
	public void save(Person_Language entity) {
		if (entity.getPerson() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide both a person and a language.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getLanguage().getCode() == null) {
			languageRepository.save(entity.getLanguage());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Person_Language> entityList) {
		for (Person_Language entity : entityList) {
			save(entity);
		}
	}
	
}
