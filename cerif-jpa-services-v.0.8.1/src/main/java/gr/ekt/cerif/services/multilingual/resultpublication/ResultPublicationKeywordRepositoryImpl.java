package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationKeyword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultPublicationKeywordRepositoryImpl implements ResultPublicationKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationKeywordRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationKeywordCrudRepository resultPublicationKeywordCrudRepository;

	@Override
	public void delete(ResultPublicationKeyword entity) {
		resultPublicationKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublicationKeyword> entityList) {
		resultPublicationKeywordCrudRepository.delete(entityList);
	}

	@Override
	public Iterable<ResultPublicationKeyword> save(Iterable<ResultPublicationKeyword> entityList) {
		return resultPublicationKeywordCrudRepository.save(entityList);
	}

	@Override
	public ResultPublicationKeyword save(ResultPublicationKeyword entity) {
		return resultPublicationKeywordCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublicationKeyword> findByResultPublication(
			ResultPublication resultPublication) {
		return resultPublicationKeywordCrudRepository.findByResultPublication(resultPublication);
	}

}
