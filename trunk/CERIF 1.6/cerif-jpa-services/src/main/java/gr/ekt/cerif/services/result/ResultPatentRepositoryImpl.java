package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPatent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class ResultPatentRepositoryImpl implements ResultPatentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentRepositoryImpl.class);

	@Autowired
	private ResultPatentCrudRepository resultPatentCrudRepository;
	
	
	@Override
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

	@Override
	public List<ResultPatent> findAll() {
		return resultPatentCrudRepository.findAll();
	}

	@Override
	public Page<ResultPatent> findAll(Pageable page) {
		return resultPatentCrudRepository.findAll(page);
	}

	@Override
	public ResultPatent findById(Long id) {
		return resultPatentCrudRepository.findById(id);
	}

	@Override
	public List<ResultPatent> findByUri(String uri) {
		return resultPatentCrudRepository.findByUri(uri);
	}

	@Override
	public ResultPatent findByUuid(String uuid) {
		return resultPatentCrudRepository.findByUuid(uuid);
	}
	

}
