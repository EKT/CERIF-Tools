/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.CitationDescription;

/**
 * @author bonisv
 *
 */
@Component
public class CitationDescriptionRepositoryImpl implements CitationDescriptionRepository{
	
	private static final Logger log = LoggerFactory.getLogger(CitationDescriptionRepositoryImpl.class);
	
	@Autowired
	private CitationDescriptionCrudRepository citationDescriptionCrudRepository;

	@Override
	public void delete(CitationDescription entity) {
		citationDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<CitationDescription> entities) {
		citationDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<CitationDescription> save(Iterable<CitationDescription> entities) {
		return citationDescriptionCrudRepository.save(entities);
	}

	@Override
	public CitationDescription save(CitationDescription entity) {
		return citationDescriptionCrudRepository.save(entity);
	}

}
