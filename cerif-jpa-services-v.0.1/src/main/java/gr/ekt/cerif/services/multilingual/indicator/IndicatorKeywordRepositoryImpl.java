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
import gr.ekt.cerif.features.multilingual.IndicatorKeyword;

/**
 * @author bonisv
 *
 */
@Component
public class IndicatorKeywordRepositoryImpl implements IndicatorKeywordRepository {

	private static final Logger log = LoggerFactory.getLogger(IndicatorKeywordRepositoryImpl.class);
	
	@Autowired
	private IndicatorKeywordCrudRepository indicatorKeywordCrudRepository;
	
	@Override
	public void delete(IndicatorKeyword entity) {
		indicatorKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<IndicatorKeyword> entities) {
		indicatorKeywordCrudRepository.save(entities);
	}

	@Override
	public Iterable<IndicatorKeyword> save(Iterable<IndicatorKeyword> entities) {
		return indicatorKeywordCrudRepository.save(entities);
	}

	@Override
	public IndicatorKeyword save(IndicatorKeyword entity) {
		return indicatorKeywordCrudRepository.save(entity);
	}

	@Override
	public List<IndicatorKeyword> findByIndicator(Indicator indicator) {
		return indicatorKeywordCrudRepository.findByIndicator(indicator);
	}

}
