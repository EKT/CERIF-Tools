package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkIndicatorClassRepositoryImpl implements
		LinkIndicatorClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkIndicatorClassRepositoryImpl.class);
	
	@Autowired
	private LinkIndicatorClassCrudRepository linkIndicatorClassCrudRepository;

	@Override
	public void delete(Indicator_Class entity) {
		linkIndicatorClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Indicator_Class> entities) {
		linkIndicatorClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Indicator_Class> save(Iterable<Indicator_Class> entities) {
		return linkIndicatorClassCrudRepository.save(entities);
	}

	@Override
	public Indicator_Class save(Indicator_Class entity) {
		return linkIndicatorClassCrudRepository.save(entity);
	}

	@Override
	public List<Indicator_Class> findByTheClass(Class theClass) {
		return linkIndicatorClassCrudRepository.findByTheClass(theClass);
	}

	@Override
	public List<Indicator_Class> findByIndicator(Indicator indicator) {
		return linkIndicatorClassCrudRepository.findByIndicator(indicator);
	}

}
