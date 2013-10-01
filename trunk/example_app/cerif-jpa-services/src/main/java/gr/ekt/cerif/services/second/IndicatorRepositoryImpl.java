/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Indicator;

/**
 * @author bonisv
 *
 */
@Component
public class IndicatorRepositoryImpl implements IndicatorRepository {

	private static final Logger log = LoggerFactory.getLogger(IndicatorRepositoryImpl.class);

	@Autowired
	private IndicatorCrudRepository indicatorCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#delete(gr.ekt.cerif.entities.second.Indicator)
	 */
	@Override
	public void delete(Indicator entity) {
		indicatorCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Indicator> entities) {
		indicatorCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Indicator> save(Iterable<Indicator> entities) {
		return indicatorCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.IndicatorRepository#save(gr.ekt.cerif.entities.second.Indicator)
	 */
	@Override
	public Indicator save(Indicator entity) {
		return indicatorCrudRepository.save(entity);
	}

}
