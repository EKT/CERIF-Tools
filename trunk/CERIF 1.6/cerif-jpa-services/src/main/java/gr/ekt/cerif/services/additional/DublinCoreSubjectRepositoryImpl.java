package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.DublinCoreSubject;

@Deprecated
@Component
public class DublinCoreSubjectRepositoryImpl implements
		DublinCoreSubjectRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DublinCoreSubjectRepositoryImpl.class);
	
	@Autowired
	private DublinCoreSubjectCrudRepository dublinCoreSubjectCrudRepository;

	@Override
	public void delete(DublinCoreSubject entity) {
		dublinCoreSubjectCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<DublinCoreSubject> entities) {
		dublinCoreSubjectCrudRepository.delete(entities);
	}

	@Override
	public Iterable<DublinCoreSubject> save(Iterable<DublinCoreSubject> entities) {
		return dublinCoreSubjectCrudRepository.save(entities);
	}

	@Override
	public DublinCoreSubject save(DublinCoreSubject entity) {
		return dublinCoreSubjectCrudRepository.save(entity);
	}

}
