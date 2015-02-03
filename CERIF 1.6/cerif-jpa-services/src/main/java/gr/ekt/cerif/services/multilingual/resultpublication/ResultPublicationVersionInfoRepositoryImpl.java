/**
 * 
 */
package gr.ekt.cerif.services.multilingual.resultpublication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationVersionInfo;


/**
 * @author bonisv
 *
 */
@Component
public class ResultPublicationVersionInfoRepositoryImpl implements ResultPublicationVersionInfoRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ResultPublicationVersionInfoRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationVersionInfoCrudRepository resultPublicationVersionInfoCrudRepository;

	@Override
	public void delete(ResultPublicationVersionInfo entity) {
		resultPublicationVersionInfoCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ResultPublicationVersionInfo> entities) {
		resultPublicationVersionInfoCrudRepository.delete(entities);
	}

	@Override
	public Iterable<ResultPublicationVersionInfo> save(Iterable<ResultPublicationVersionInfo> entities) {
		return resultPublicationVersionInfoCrudRepository.save(entities);
	}

	@Override
	public ResultPublicationVersionInfo save(ResultPublicationVersionInfo entity) {
		return resultPublicationVersionInfoCrudRepository.save(entity);
	}

	@Override
	public List<ResultPublicationVersionInfo> findByResultPublication(
			ResultPublication resultPublication) {
		return resultPublicationVersionInfoCrudRepository.findByResultPublication(resultPublication);
	}

}
