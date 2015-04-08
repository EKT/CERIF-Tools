package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Medium;

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
public class MediumRepositoryImpl implements MediumRepository {
	
	private static final Logger log = LoggerFactory.getLogger(MediumRepositoryImpl.class);

	@Autowired
	private MediumCrudRepository mediumCrudRepository;

	

	@Override
	public Medium findByUri(String uri) {
		return mediumCrudRepository.findByUri(uri);
	}

	@Override
	@Transactional
	public void delete(Medium entity) {
		mediumCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Medium> entityList) {
		mediumCrudRepository.delete(entityList);
	}

	@Override
	public Iterable<Medium> save(Iterable<Medium> entities) {
		return mediumCrudRepository.save(entities);
	}

	@Override
	public Medium save(Medium entity) {
		return mediumCrudRepository.save(entity);
	}

	@Override
	public Medium findById(Long id) {
		return mediumCrudRepository.findById(id);
	}

	@Override
	public Medium findMediumByProjectIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByProjectIdAndClassUUID(id, uuid);
	}

	@Override
	public Medium findMediumByOrgIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByOrgIdAndClassUUID(id, uuid);
	}

	@Override
	public Medium findMediumByPersonIdAndClassUUID(Long id, String uuid) {
		return mediumCrudRepository.findMediumByPersonIdAndClassUUID(id, uuid);
	}

	@Override
	public List<Medium> findAll() {
		return mediumCrudRepository.findAll();
	}

	@Override
	public Page<Medium> findAll(Pageable page) {
		return mediumCrudRepository.findAll(page);
	}

	@Override
	public Medium findByUuid(String uuid) {
		return mediumCrudRepository.findByUuid(uuid);
	}


}
