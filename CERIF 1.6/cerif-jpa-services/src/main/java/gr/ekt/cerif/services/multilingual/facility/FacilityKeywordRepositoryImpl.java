/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.multilingual.FacilityKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class FacilityKeywordRepositoryImpl implements FacilityKeywordRepository{

	private static final Logger log = LoggerFactory.getLogger(FacilityKeywordRepositoryImpl.class);
	
	@Autowired
	private FacilityKeywordCrudRepository facilityKeywordCrudRepository;
	
	@Override
	public void delete(FacilityKeyword entity) {
		facilityKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<FacilityKeyword> entities) {
		facilityKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FacilityKeyword> save(Iterable<FacilityKeyword> entities) {
		return facilityKeywordCrudRepository.save(entities);
	}

	@Override
	public FacilityKeyword save(FacilityKeyword entity) {
		return facilityKeywordCrudRepository.save(entity);
	}

	@Override
	public List<FacilityKeyword> findByFacility(Facility facility) {
		return facilityKeywordCrudRepository.findByFacility(facility);
	}

}
