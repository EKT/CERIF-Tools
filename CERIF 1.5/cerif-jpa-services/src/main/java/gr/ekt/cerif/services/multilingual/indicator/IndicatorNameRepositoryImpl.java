/**
 * 
 */
package gr.ekt.cerif.services.multilingual.indicator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.IndicatorName;

/**
 * @author bonisv
 *
 */
@Component
public class IndicatorNameRepositoryImpl implements IndicatorNameRepository {
	
	private static final Logger log = LoggerFactory.getLogger(IndicatorNameRepositoryImpl.class);
	
	@Autowired
	private IndicatorNameCrudRepository indicatorNameCrudRepository;

	@Override
	public void delete(IndicatorName entity) {
		indicatorNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<IndicatorName> entities) {
		indicatorNameCrudRepository.delete(entities);
	}

	@Override
	public Iterable<IndicatorName> save(Iterable<IndicatorName> entities) {
		return indicatorNameCrudRepository.save(entities);
	}

	@Override
	public IndicatorName save(IndicatorName entity) {
		return indicatorNameCrudRepository.save(entity);
	}

}
