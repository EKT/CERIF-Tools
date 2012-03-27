/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.EquipmentTranslation;
import gr.ekt.cerif.services.infrastructure.EquipmentRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for equipment translation entities.
 * 
 */
@Component
public class EquipmentTranslationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	EquipmentRepository equipmentRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Transactional
	public void save(EquipmentTranslation entity) {
		if (entity.getEquipment() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a equipment, a translation and a language.");
		}
		if (entity.getEquipment().getId() == null) {
			equipmentRepository.save(entity.getEquipment());
		}
		languageRepository.save(entity.getLanguage());
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<EquipmentTranslation> entityList) {
		for (EquipmentTranslation entity : entityList) {
			save(entity);
		}
	}
}

