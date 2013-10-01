package gr.ekt.cerif.services.multilingual.qualification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.QualificationKeyword;

@Component
public class QualificationKeywordRepositoryImpl implements QualificationKeywordRepository {
	
	private static final Logger log = LoggerFactory.getLogger(QualificationKeywordRepositoryImpl.class);
	
	@Autowired
	private QualificationKeywordCrudRepository qualificationKeywordCrudRepository;

	@Override
	public void delete(QualificationKeyword entity) {
		qualificationKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<QualificationKeyword> entities) {
		qualificationKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<QualificationKeyword> save(Iterable<QualificationKeyword> entities) {
		return qualificationKeywordCrudRepository.save(entities);
	}

	@Override
	public QualificationKeyword save(QualificationKeyword entity) {
		return qualificationKeywordCrudRepository.save(entity);
	}

}
