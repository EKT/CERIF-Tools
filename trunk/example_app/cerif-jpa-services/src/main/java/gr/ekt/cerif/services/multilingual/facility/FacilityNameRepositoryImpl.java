package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.features.multilingual.FacilityName;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;
import gr.ekt.cerif.services.second.LanguageCrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FacilityNameRepositoryImpl implements FacilityNameRepository {

	@Autowired
	FacilityNameCrudRepository facilityNameCrudRepository;
	
	@Transactional
	public FacilityName save(FacilityName entity) {
		return facilityNameCrudRepository.save(entity);
	}

	@Transactional
	public void delete(FacilityName entity) {
		facilityNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<FacilityName> entities) {
		facilityNameCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<FacilityName> save(Iterable<FacilityName> entities) {
		return facilityNameCrudRepository.save(entities);
	}
	
}
