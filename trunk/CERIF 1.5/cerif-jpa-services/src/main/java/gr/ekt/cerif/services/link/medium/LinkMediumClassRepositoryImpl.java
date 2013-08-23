package gr.ekt.cerif.services.link.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Medium_Class;

@Component
public class LinkMediumClassRepositoryImpl implements LinkMediumClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMediumClassRepositoryImpl.class);
	
	@Autowired
	private LinkMediumClassCrudRepository linkMediumClassCrudRepository;

	@Override
	public void delete(Medium_Class entity) {
		linkMediumClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Medium_Class> entities) {
		linkMediumClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Medium_Class> save(Iterable<Medium_Class> entities) {
		return linkMediumClassCrudRepository.save(entities);
	}

	@Override
	public Medium_Class save(Medium_Class entity) {
		return linkMediumClassCrudRepository.save(entity);
	}

}
