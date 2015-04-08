/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Qualification;

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
public class QualificationRepositoryImpl implements QualificationRepository {

	private static final Logger log = LoggerFactory.getLogger(QualificationRepositoryImpl.class);

	@Autowired
	private QualificationCrudRepository qualificationCrudRepository;
	
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#delete(gr.ekt.cerif.entities.second.Qualification)
	 */
	@Override
	@Transactional
	public void delete(Qualification entity) {
		qualificationCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Qualification> entities) {
		qualificationCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Qualification> save(Iterable<Qualification> entities) {
		return qualificationCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#save(gr.ekt.cerif.entities.second.Qualification)
	 */
	@Override
	public Qualification save(Qualification entity) {
		return qualificationCrudRepository.save(entity);
	}

	@Override
	public List<Qualification> findAll() {
		return qualificationCrudRepository.findAll();
	}

	@Override
	public Page<Qualification> findAll(Pageable page) {
		return qualificationCrudRepository.findAll(page);
	}

	@Override
	public Qualification findById(Long id) {
		return qualificationCrudRepository.findById(id);
	}

	@Override
	public List<Qualification> findByUri(String uri) {
		return qualificationCrudRepository.findByUri(uri);
	}

	@Override
	public Qualification findByUuid(String uuid) {
		return qualificationCrudRepository.findByUuid(uuid);
	}

}
