/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.services.base.ProjectRepositoryImpl;

/**
 * @author bonisv
 *
 */
@Component
public class CVRepositoryImpl implements CVRepository {

    private static final Logger log = LoggerFactory.getLogger(CVRepositoryImpl.class);
	
	@Autowired
	private CVCrudRepository cvCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.CVRepository#findById(java.lang.Long)
	 */
	@Override
	public CV findById(Long id) {
		return cvCrudRepository.findById(id);
	}

	@Transactional
	public void delete(CV entity) {
		cvCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<CV> entities) {
		cvCrudRepository.save(entities);
	}

	@Transactional
	public Iterable<CV> save(Iterable<CV> entities) {
		return cvCrudRepository.save(entities);
	}

	@Transactional
	public CV save(CV entity) {
		return cvCrudRepository.save(entity);
	}


}
