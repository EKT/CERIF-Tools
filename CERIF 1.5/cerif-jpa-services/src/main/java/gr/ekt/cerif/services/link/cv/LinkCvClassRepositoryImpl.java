package gr.ekt.cerif.services.link.cv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Cv_Class;

@Component
public class LinkCvClassRepositoryImpl implements LinkCvClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkCvClassRepositoryImpl.class);
	
	@Autowired
	private LinkCvClassCrudRepository linkCvClassCrudRepository;

	@Override
	public void delete(Cv_Class entity) {
		linkCvClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Cv_Class> entities) {
		linkCvClassCrudRepository.save(entities);
	}

	@Override
	public Iterable<Cv_Class> save(Iterable<Cv_Class> entities) {
		return linkCvClassCrudRepository.save(entities);
	}

	@Override
	public Cv_Class save(Cv_Class entity) {
		return linkCvClassCrudRepository.save(entity);
	}

}
