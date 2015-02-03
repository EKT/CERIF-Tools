package gr.ekt.cerif.services.multilingual.resultpatent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.multilingual.ResultPatentVersionInfo;

@Component
public class ResultPatentVersionInfoRepositoryImpl implements ResultPatentVersionInfoRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPatentVersionInfoRepositoryImpl.class);
	
	@Autowired
	private ResultPatentVersionInfoCrudRepository resultPatentVersionInfoCrudRepository;

	@Override
	public void delete(ResultPatentVersionInfo entity) {
		resultPatentVersionInfoCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPatentVersionInfo> entities) {
		resultPatentVersionInfoCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPatentVersionInfo> save(Iterable<ResultPatentVersionInfo> entities) {
		return resultPatentVersionInfoCrudRepository.save(entities);
	}

	@Override
	public ResultPatentVersionInfo save(ResultPatentVersionInfo entity) {
		return resultPatentVersionInfoCrudRepository.save(entity);
	}

	@Override
	public List<ResultPatentVersionInfo> findByResultPatent(
			ResultPatent resultPatent) {
		return resultPatentVersionInfoCrudRepository.findByResultPatent(resultPatent);
	}

}
