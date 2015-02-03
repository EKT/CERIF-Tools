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
import gr.ekt.cerif.features.multilingual.ResultPublicationSubtitle;


/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationSubtitleRepositoryImpl implements ResultPublicationSubtitleRepository{
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationSubtitleRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationSubtitleCrudRepository resultPublicationSubtitleCrudRepository;

	@Override
	public void delete(ResultPublicationSubtitle entity) {
		resultPublicationSubtitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublicationSubtitle> entities) {
		resultPublicationSubtitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublicationSubtitle> save(Iterable<ResultPublicationSubtitle> entities) {
		return resultPublicationSubtitleCrudRepository.save(entities);
	}

	@Override
	public ResultPublicationSubtitle save(ResultPublicationSubtitle entity) {
		return resultPublicationSubtitleCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublicationSubtitle> findByResultPublication(
			ResultPublication resultPublication) {
		return resultPublicationSubtitleCrudRepository.findByResultPublication(resultPublication);
	}

}
