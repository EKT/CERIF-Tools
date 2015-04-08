/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.CurriculumVitae;

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
public class CurriculumVitaeRepositoryImpl implements CurriculumVitaeRepository {

    private static final Logger log = LoggerFactory.getLogger(CurriculumVitaeRepositoryImpl.class);
	
	@Autowired
	private CurriculumVitaeCrudRepository curriculumVitaeCrudRepository;
	
	
	@Override
	public CurriculumVitae findById(Long id) {
		return curriculumVitaeCrudRepository.findById(id);
	}

	@Transactional
	public void delete(CurriculumVitae entity) {
		curriculumVitaeCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<CurriculumVitae> entities) {
		curriculumVitaeCrudRepository.save(entities);
	}

	@Transactional
	public Iterable<CurriculumVitae> save(Iterable<CurriculumVitae> entities) {
		return curriculumVitaeCrudRepository.save(entities);
	}

	@Transactional
	public CurriculumVitae save(CurriculumVitae entity) {
		return curriculumVitaeCrudRepository.save(entity);
	}

	@Override
	public List<CurriculumVitae> findAll() {
		return curriculumVitaeCrudRepository.findAll();
	}

	@Override
	public Page<CurriculumVitae> findAll(Pageable page) {
		return curriculumVitaeCrudRepository.findAll(page);
	}

	@Override
	public List<CurriculumVitae> findByUri(String uri) {
		return curriculumVitaeCrudRepository.findByUri(uri);
	}

	@Override
	public CurriculumVitae findByUuid(String uuid) {
		return curriculumVitaeCrudRepository.findByUuid(uuid);
	}


}
