package gr.ekt.cerif.services.multilingual.resultpatent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ResultPatentTitle;

@Component
public class ResultPatentTitleRepositoryImpl implements ResultPatentTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentTitleRepositoryImpl.class);
	
	@Autowired
	private ResultPatentTitleCrudRepository resultPatentTitleCrudRepository;

	@Override
	public void delete(ResultPatentTitle entity) {
		resultPatentTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatentTitle> entities) {
		resultPatentTitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatentTitle> save(Iterable<ResultPatentTitle> entities) {
		return resultPatentTitleCrudRepository.save(entities);
	}

	@Override
	public ResultPatentTitle save(ResultPatentTitle entity) {
		return resultPatentTitleCrudRepository.save(entity);
	}

}
