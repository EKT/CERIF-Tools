/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Qualification;

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

}
