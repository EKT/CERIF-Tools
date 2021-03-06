package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Indicator_Indicator;
import gr.ekt.cerif.entities.second.Indicator;

@Component
public class LinkIndicatorIndicatorRepositoryImpl implements LinkIndicatorIndicatorRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkIndicatorIndicatorRepositoryImpl.class);
	
	@Autowired
	private LinkIndicatorIndicatorCrudRepository linkIndicatorIndicatorCrudRepository;

	@Override
	public void delete(Indicator_Indicator entity) {
		linkIndicatorIndicatorCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Indicator_Indicator> entities) {
		linkIndicatorIndicatorCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Indicator_Indicator> save(
			Iterable<Indicator_Indicator> entities) {
		return linkIndicatorIndicatorCrudRepository.save(entities);
	}

	@Override
	public Indicator_Indicator save(Indicator_Indicator entity) {
		return linkIndicatorIndicatorCrudRepository.save(entity);
	}

	@Override
	public List<Indicator_Indicator> findByIndicator1(Indicator Indicator) {
		return linkIndicatorIndicatorCrudRepository.findByIndicator1(Indicator);
	}

	@Override
	public List<Indicator_Indicator> findByIndicator2(Indicator indicator) {
		return linkIndicatorIndicatorCrudRepository.findByIndicator2(indicator);
	}

}
