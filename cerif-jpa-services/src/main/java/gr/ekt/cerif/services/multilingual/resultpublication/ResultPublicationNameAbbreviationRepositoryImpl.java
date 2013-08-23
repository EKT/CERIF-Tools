/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ResultPublicationNameAbbreviation;


/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationNameAbbreviationRepositoryImpl implements ResultPublicationNameAbbreviationRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationNameAbbreviationRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationNameAbbreviationCrudRepository resultPublicationNameAbbreviationCrudRepository;

	@Override
	public void delete(ResultPublicationNameAbbreviation entity) {
		resultPublicationNameAbbreviationCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublicationNameAbbreviation> entities) {
		resultPublicationNameAbbreviationCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublicationNameAbbreviation> save(Iterable<ResultPublicationNameAbbreviation> entities) {
		return resultPublicationNameAbbreviationCrudRepository.save(entities);
	}

	@Override
	public ResultPublicationNameAbbreviation save(ResultPublicationNameAbbreviation entity) {
		return resultPublicationNameAbbreviationCrudRepository.save(entity);
	}

}
