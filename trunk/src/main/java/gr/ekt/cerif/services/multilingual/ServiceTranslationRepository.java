/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.ServiceTranslation;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for service translation entities.
 * 
 */
@Component
public class ServiceTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(ServiceTranslation entity) {
		if (entity.getService() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a service, a translation and a language.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ServiceTranslation> entityList) {
		for (ServiceTranslation entity : entityList) {
			save(entity);
		}
	}
}

