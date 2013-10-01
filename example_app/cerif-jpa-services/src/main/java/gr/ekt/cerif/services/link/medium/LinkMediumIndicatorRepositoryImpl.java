package gr.ekt.cerif.services.link.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Medium_Indicator;

@Component
public class LinkMediumIndicatorRepositoryImpl implements
		LinkMediumIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkMediumIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkMediumIndicatorCrudRepository linkMediumIndicatorCrudRepository;

	@Override
	public void delete(Medium_Indicator entity) {
		linkMediumIndicatorCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Medium_Indicator> entities) {
		linkMediumIndicatorCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Medium_Indicator> save(Iterable<Medium_Indicator> entities) {
		return linkMediumIndicatorCrudRepository.save(entities);
	}

	@Override
	public Medium_Indicator save(Medium_Indicator entity) {
		return linkMediumIndicatorCrudRepository.save(entity);
	}

}
