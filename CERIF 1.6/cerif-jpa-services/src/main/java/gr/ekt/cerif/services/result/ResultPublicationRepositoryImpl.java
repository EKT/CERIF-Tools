package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ResultPublicationRepositoryImpl implements ResultPublicationRepository {

	private static final Logger log = LoggerFactory.getLogger(ResultPublicationRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationCrudRepository resultPublicationCrudRepository;
	
	
	@Override
	public ResultPublication findByUri(String uri) {
		return resultPublicationCrudRepository.findByUri(uri);
	}

	@Override
	public ResultPublication findById(Long id) {
		return resultPublicationCrudRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void delete(ResultPublication entity) {
		resultPublicationCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<ResultPublication> save(Iterable<ResultPublication> entities) {
		return resultPublicationCrudRepository.save(entities);
	}

	@Transactional
	public ResultPublication save(ResultPublication entity) {
		return resultPublicationCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication> entities) {
		resultPublicationCrudRepository.delete(entities);		
	}

	@Override
	public List<ResultPublication> findAll() {
		return resultPublicationCrudRepository.findAll();
	}

	@Override
	public Page<ResultPublication> findAll(Pageable page) {
		return resultPublicationCrudRepository.findAll(page);
	}

	@Override
	public ResultPublication findByUuid(String uuid) {
		return resultPublicationCrudRepository.findByUuid(uuid);
	}

}
