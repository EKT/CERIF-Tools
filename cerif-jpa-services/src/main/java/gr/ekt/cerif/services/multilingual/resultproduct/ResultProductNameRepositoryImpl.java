package gr.ekt.cerif.services.multilingual.resultproduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.ResultProductName;

@Component
public class ResultProductNameRepositoryImpl implements ResultProductNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultProductNameRepositoryImpl.class);
	
	@Autowired
	private ResultProductNameCrudRepository resultProductNameCrudRepository;

	@Override
	public void delete(ResultProductName entity) {
		resultProductNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProductName> entities) {
		resultProductNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProductName> save(Iterable<ResultProductName> entities) {
		return resultProductNameCrudRepository.save(entities);
	}

	@Override
	public ResultProductName save(ResultProductName entity) {
		return resultProductNameCrudRepository.save(entity);
	}

}
