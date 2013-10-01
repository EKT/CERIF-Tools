package gr.ekt.cerif.services.multilingual.qualification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.QualificationDescription;

@Component
public class QualificationDescriptionRepositoryImpl implements QualificationDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(QualificationDescriptionRepositoryImpl.class);
	
	@Autowired
	private QualificationDescriptionCrudRepository qualificationDescriptionCrudRepository;

	@Override
	public void delete(QualificationDescription entity) {
		qualificationDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<QualificationDescription> entities) {
		qualificationDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<QualificationDescription> save(Iterable<QualificationDescription> entities) {
		return qualificationDescriptionCrudRepository.save(entities);
	}

	@Override
	public QualificationDescription save(QualificationDescription entity) {
		return qualificationDescriptionCrudRepository.save(entity);
	}

}
