/**
 * 
 */
package gr.ekt.cerif.services.multilingual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for facility translation entities.
 * 
 */
@Component
public class FacilityNameServiceImpl implements FacilityNameService{

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	FacilityNameRepository facilityNameRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Override
	@Transactional
	public void save(FacilityName entity) {
		if (entity.getFacility() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a facility, a translation and a language.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		languageRepository.save(entity.getLanguage());
		facilityNameRepository.save(entity);
	}


	@Override
	@Transactional
	public void save(List<? extends FacilityName> entities) {
		for (FacilityName entity : entities) {
			save(entity);
		}
	}
}

