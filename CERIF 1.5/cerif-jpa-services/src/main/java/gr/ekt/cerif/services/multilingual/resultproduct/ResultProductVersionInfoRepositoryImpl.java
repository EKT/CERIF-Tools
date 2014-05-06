package gr.ekt.cerif.services.multilingual.resultproduct;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;

@Component
public class ResultProductVersionInfoRepositoryImpl implements ResultProductVersionInfoRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultProductVersionInfoRepositoryImpl.class);
	
	@Autowired
	private ResultProductVersionInfoCrudRepository resultProductVersionInfoCrudRepository;

	@Override
	public void delete(ResultProductVersionInfo entity) {
		resultProductVersionInfoCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultProductVersionInfo> entities) {
		resultProductVersionInfoCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultProductVersionInfo> save(Iterable<ResultProductVersionInfo> entities) {
		return resultProductVersionInfoCrudRepository.save(entities);
	}

	@Override
	public ResultProductVersionInfo save(ResultProductVersionInfo entity) {
		return resultProductVersionInfoCrudRepository.save(entity);
	}

	@Override
	public List<ResultProductVersionInfo> findByResultProduct(
			ResultProduct resultProduct) {
		return resultProductVersionInfoCrudRepository.findByResultProduct(resultProduct);
	}

}
