/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Citation;

/**
 * @author bonisv
 *
 */
@Component
public class CitationRepositoryImpl implements CitationRepository {

	private static final Logger log = LoggerFactory.getLogger(CitationRepositoryImpl.class);
	
	@Autowired
	private CitationCrudRepository citationCrudRepository;
	
	@Override
	public void delete(Citation entity) {
		citationCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Citation> entities) {
		citationCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Citation> save(Iterable<Citation> entities) {
		return citationCrudRepository.save(entities);
	}

	@Override
	public Citation save(Citation entity) {
		return citationCrudRepository.save(entity);
	}

}
