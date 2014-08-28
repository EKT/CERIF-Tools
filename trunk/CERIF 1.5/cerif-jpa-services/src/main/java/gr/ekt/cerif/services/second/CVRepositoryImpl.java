/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.entities.link.person.Person_Cv;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.services.link.cv.LinkCvClassRepository;
import gr.ekt.cerif.services.link.person.LinkPersonCvRepository;

/**
 * @author bonisv
 *
 */
@Component
public class CVRepositoryImpl implements CVRepository {

    private static final Logger log = LoggerFactory.getLogger(CVRepositoryImpl.class);
	
	@Autowired
	private CVCrudRepository cvCrudRepository;
	
	@Autowired
	private LinkPersonCvRepository linkPersonCvRepository;
	
	@Autowired
	private LinkCvClassRepository linkCvClassRepository;
	
	
	@Override
	public CV findById(Long id) {
		return cvCrudRepository.findById(id);
	}

	@Transactional
	public void delete(CV entity) {
		List<Person_Cv> pcv = linkPersonCvRepository.findByCv(entity);
		if (pcv != null) linkPersonCvRepository.delete(pcv);
		entity.setPersons_cvs(null);
		
		List<Cv_Class> cvcl = linkCvClassRepository.findByCv(entity);
		if (cvcl != null) linkCvClassRepository.delete(cvcl);
		entity.setCvs_classes(null);
		
		entity = cvCrudRepository.save(entity);
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
