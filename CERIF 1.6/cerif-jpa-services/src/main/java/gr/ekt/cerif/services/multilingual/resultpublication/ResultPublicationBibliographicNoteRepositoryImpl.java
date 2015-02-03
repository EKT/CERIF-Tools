/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationBibliographicNote;

/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationBibliographicNoteRepositoryImpl implements ResultPublicationBibliographicNoteRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationBibliographicNoteRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationBibliographicNoteCrudRepository resultPublicationBibliographicNoteCrudRepository;

	@Override
	public void delete(ResultPublicationBibliographicNote entity) {
		resultPublicationBibliographicNoteCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublicationBibliographicNote> entities) {
		resultPublicationBibliographicNoteCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublicationBibliographicNote> save(Iterable<ResultPublicationBibliographicNote> entities) {
		return resultPublicationBibliographicNoteCrudRepository.save(entities);
	}

	@Override
	public ResultPublicationBibliographicNote save(ResultPublicationBibliographicNote entity) {
		return resultPublicationBibliographicNoteCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublicationBibliographicNote> findByResultPublication(
			ResultPublication resultPublication) {
		return resultPublicationBibliographicNoteCrudRepository.findByResultPublication(resultPublication);
	}

}
