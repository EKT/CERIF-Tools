package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentAbstract;

@Component
public class ResultPatentAbstractRepositoryImpl implements ResultPatentAbstractRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentAbstractRepositoryImpl.class);
	
	@Autowired
	private ResultPatentAbstractCrudRepository resultPatentAbstractCrudRepository;

	@Override
	public void delete(ResultPatentAbstract entity) {
		resultPatentAbstractCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatentAbstract> entities) {
		resultPatentAbstractCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatentAbstract> save(Iterable<ResultPatentAbstract> entities) {
		return resultPatentAbstractCrudRepository.save(entities);
	}

	@Override
	public ResultPatentAbstract save(ResultPatentAbstract entity) {
		return resultPatentAbstractCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatentAbstract> findByResultPatent(
			ResultPatent resultPatent) {
		return resultPatentAbstractCrudRepository.findByResultPatent(resultPatent);
	}

}
