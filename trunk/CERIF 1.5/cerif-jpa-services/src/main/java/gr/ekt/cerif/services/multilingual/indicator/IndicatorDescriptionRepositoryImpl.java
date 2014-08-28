/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.multilingual.IndicatorDescription;

/**
 * @author bonisv
 *
 */
@Component
public class IndicatorDescriptionRepositoryImpl implements IndicatorDescriptionRepository {
	
	private static final Logger log = LoggerFactory.getLogger(IndicatorDescriptionRepositoryImpl.class);
	
	@Autowired
	private IndicatorDescriptionCrudRepository indicatorDescriptionCrudRepository;

	@Override
	public void delete(IndicatorDescription entity) {
		indicatorDescriptionCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<IndicatorDescription> entities) {
		indicatorDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<IndicatorDescription> save(Iterable<IndicatorDescription> entities) {
		return indicatorDescriptionCrudRepository.save(entities);
	}

	@Override
	public IndicatorDescription save(IndicatorDescription entity) {
		return indicatorDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<IndicatorDescription> findByIndicator(Indicator indicator) {
		return indicatorDescriptionCrudRepository.findByIndicator(indicator);
	}

}
