/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.FacilityDescription;

/**
 * @author bonisv
 *
 */
@Component
public class FacilityDescriptionRepositoryImpl implements FacilityDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(FacilityDescriptionRepositoryImpl.class);
	
	@Autowired
	private FacilityDescriptionCrudRepository facilityDescriptionCrudRepository;
	
	@Override
	public void delete(FacilityDescription entity) {
		facilityDescriptionCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<FacilityDescription> entities) {
		facilityDescriptionCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<FacilityDescription> save(Iterable<FacilityDescription> entities) {
		return facilityDescriptionCrudRepository.save(entities);
	}

	@Override
	public FacilityDescription save(FacilityDescription entity) {
		return facilityDescriptionCrudRepository.save(entity);
	}

}
