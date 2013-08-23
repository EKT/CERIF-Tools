/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.MediumTitle;

/**
 * @author bonisv
 *
 */
@Component
public class MediumTitleRepositoryImpl implements MediumTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MediumTitleRepositoryImpl.class);
	
	@Autowired
	private MediumTitleCrudRepository mediumTitleCrudRepository;

	@Override
	public void delete(MediumTitle entity) {
		mediumTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<MediumTitle> entities) {
		mediumTitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<MediumTitle> save(Iterable<MediumTitle> entities) {
		return mediumTitleCrudRepository.save(entities);
	}

	@Override
	public MediumTitle save(MediumTitle entity) {
		return mediumTitleCrudRepository.save(entity);
	}

}
