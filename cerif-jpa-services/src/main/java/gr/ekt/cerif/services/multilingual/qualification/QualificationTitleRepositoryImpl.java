package gr.ekt.cerif.services.multilingual.qualification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.QualificationTitle;

@Component
public class QualificationTitleRepositoryImpl implements QualificationTitleRepository {
	
	private static final Logger log = LoggerFactory.getLogger(QualificationTitleRepositoryImpl.class);
	
	@Autowired
	private QualificationTitleCrudRepository qualificationTitleCrudRepository;

	@Override
	public void delete(QualificationTitle entity) {
		qualificationTitleCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<QualificationTitle> entities) {
		qualificationTitleCrudRepository.delete(entities);
	}

	@Override
	public Iterable<QualificationTitle> save(Iterable<QualificationTitle> entities) {
		return qualificationTitleCrudRepository.save(entities);
	}

	@Override
	public QualificationTitle save(QualificationTitle entity) {
		return qualificationTitleCrudRepository.save(entity);
	}

}
