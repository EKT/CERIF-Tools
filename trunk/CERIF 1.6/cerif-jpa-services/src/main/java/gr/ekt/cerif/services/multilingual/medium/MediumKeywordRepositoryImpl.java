/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumKeyword;

/**
 * @author bonisv
 *
 */
@Component
public class MediumKeywordRepositoryImpl implements MediumKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MediumKeywordRepositoryImpl.class);
	
	@Autowired
	private MediumKeywordCrudRepository mediumKeywordCrudRepository;

	@Override
	public void delete(MediumKeyword entity) {
		mediumKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MediumKeyword> entities) {
		mediumKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MediumKeyword> save(Iterable<MediumKeyword> entities) {
		return mediumKeywordCrudRepository.save(entities);
	}

	@Override
	public MediumKeyword save(MediumKeyword entity) {
		return mediumKeywordCrudRepository.save(entity);
	}

	@Override
	public List<MediumKeyword> findByMedium(Medium medium) {
		return mediumKeywordCrudRepository.findByMedium(medium);
	}

}
