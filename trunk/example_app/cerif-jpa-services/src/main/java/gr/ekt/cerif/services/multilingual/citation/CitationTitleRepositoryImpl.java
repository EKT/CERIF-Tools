/**
 * 
 */
package gr.ekt.cerif.services.multilingual.citation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.CitationTitle;

/**
 * @author bonisv
 *
 */
@Component
public class CitationTitleRepositoryImpl implements CitationTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(CitationTitleRepositoryImpl.class);
	
	@Autowired
	private CitationTitleCrudRepository citationTitleCrudRepository;

	@Override
	public void delete(CitationTitle entity) {
		citationTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<CitationTitle> entities) {
		citationTitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<CitationTitle> save(Iterable<CitationTitle> entities) {
		return citationTitleCrudRepository.save(entities);
	}

	@Override
	public CitationTitle save(CitationTitle entity) {
		return citationTitleCrudRepository.save(entity);
	}

}
