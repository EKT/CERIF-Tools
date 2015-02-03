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
import gr.ekt.cerif.features.multilingual.MediumDescription;

/**
 * @author bonisv
 *
 */
@Component
public class MediumDescriptionRepositoryImpl implements MediumDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MediumDescriptionRepositoryImpl.class);
	
	@Autowired
	private MediumDescriptionCrudRepository mediumDescriptionCrudRepository;

	@Override
	public void delete(MediumDescription entity) {
		mediumDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MediumDescription> entities) {
		mediumDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MediumDescription> save(Iterable<MediumDescription> entities) {
		return mediumDescriptionCrudRepository.save(entities);
	}

	@Override
	public MediumDescription save(MediumDescription entity) {
		return mediumDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<MediumDescription> findByMedium(Medium medium) {
		return mediumDescriptionCrudRepository.findByMedium(medium);
	}

}
