package gr.ekt.cerif.services.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.result.ResultPatent;

@Component
public class ResultPatentRepositoryImpl implements ResultPatentRepository {

	@Autowired
	private ResultPatentCrudRepository resultPatentCrudRepository;
	
	@Transactional
	public void delete(ResultPatent entity) {
		resultPatentCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<ResultPatent> save(Iterable<ResultPatent> entities) {
		return resultPatentCrudRepository.save(entities);
	}

	@Transactional
	public ResultPatent save(ResultPatent entity) {
		return resultPatentCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ResultPatent> entities) {
		resultPatentCrudRepository.delete(entities);		
	}
	

}
