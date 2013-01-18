package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.LanguageRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FacilityNameRepositoryImpl implements FacilityNameRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	FacilityRepository facilityRepository;

	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	FacilityNameCrudRepository facilityNameCrudRepository;
	
	@Transactional
	public FacilityName save(FacilityName entity) {
		if (entity.getFacility() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a facility, a translation and a language.");
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		languageRepository.save(entity.getLanguage());
		return facilityNameCrudRepository.save(entity);
	}

	@Transactional
	public Iterable<? extends FacilityName> save(Iterable<? extends FacilityName> entities) {
		for (FacilityName entity : entities) {
			save(entity);
		}
		return entities;
	}

	@Transactional
	public void delete(FacilityName entity) {
		facilityNameCrudRepository.delete(entity);
	}
	
}
