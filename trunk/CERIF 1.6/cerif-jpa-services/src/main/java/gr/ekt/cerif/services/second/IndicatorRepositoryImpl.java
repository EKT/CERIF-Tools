/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Indicator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

	@Override
	public List<Indicator> findAll() {
		return indicatorCrudRepository.findAll();
	}

	@Override
	public Page<Indicator> findAll(Pageable page) {
		return indicatorCrudRepository.findAll(page);
	}

	@Override
	public Indicator findByUuid(String uuid) {
		return indicatorCrudRepository.findByUuid(uuid);
	}

	@Override
	public Indicator findById(Long id) {
		return indicatorCrudRepository.findById(id);
	}

	@Override
	public List<Indicator> findByUri(String uri) {
		return indicatorCrudRepository.findByUri(uri);
	}

}
