/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ProjectTranslation;
import gr.ekt.cerif.services.base.ProjectRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for project translation entities.
 * 
 */
@Component
public class ProjectTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ProjectTranslation entity) {
		if (entity.getProject() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a project, a translation and a language.");
		}
		if (entity.getProject().getId() == null) {
			projectRepository.save(entity.getProject());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ProjectTranslation> entityList) {
		for (ProjectTranslation entity : entityList) {
			save(entity);
		}
	}
}

