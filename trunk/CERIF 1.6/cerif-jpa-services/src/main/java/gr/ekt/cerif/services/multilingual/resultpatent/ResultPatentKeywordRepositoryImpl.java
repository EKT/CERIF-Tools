package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentKeyword;

@Component
public class ResultPatentKeywordRepositoryImpl implements ResultPatentKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentKeywordRepositoryImpl.class);
	
	@Autowired
	private ResultPatentKeywordCrudRepository resultPatentKeywordCrudRepository;

	@Override
	public void delete(ResultPatentKeyword entity) {
		resultPatentKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatentKeyword> entities) {
		resultPatentKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatentKeyword> save(Iterable<ResultPatentKeyword> entities) {
		return resultPatentKeywordCrudRepository.save(entities);
	}

	@Override
	public ResultPatentKeyword save(ResultPatentKeyword entity) {
		return resultPatentKeywordCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatentKeyword> findByResultPatent(
			ResultPatent resultPatent) {
		return resultPatentKeywordCrudRepository.findByResultPatent(resultPatent);
	}

}
