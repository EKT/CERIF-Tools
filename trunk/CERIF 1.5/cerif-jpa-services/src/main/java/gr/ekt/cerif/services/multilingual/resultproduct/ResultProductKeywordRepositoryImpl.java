package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;

@Component
public class ResultProductKeywordRepositoryImpl implements ResultProductKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultProductKeywordRepositoryImpl.class);
	
	@Autowired
	private ResultProductKeywordCrudRepository resultProductKeywordCrudRepository;

	@Override
	public void delete(ResultProductKeyword entity) {
		resultProductKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProductKeyword> entities) {
		resultProductKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProductKeyword> save(Iterable<ResultProductKeyword> entities) {
		return resultProductKeywordCrudRepository.save(entities);
	}

	@Override
	public ResultProductKeyword save(ResultProductKeyword entity) {
		return resultProductKeywordCrudRepository.save(entity);
	}

	@Override
	public List<ResultProductKeyword> findByResultProduct(
			ResultProduct resultProduct) {
		return resultProductKeywordCrudRepository.findByResultProduct(resultProduct);
	}

}
