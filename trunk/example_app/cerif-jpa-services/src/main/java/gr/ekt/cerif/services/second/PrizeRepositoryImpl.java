/**
 * 
 */
package gr.ekt.cerif.services.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Prize;

/**
 * @author bonisv
 *
 */
@Component
public class PrizeRepositoryImpl implements PrizeRepository {

	private static final Logger log = LoggerFactory.getLogger(PrizeRepositoryImpl.class);
	
	@Autowired
	private PrizeCrudRepository prizeCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#delete(gr.ekt.cerif.entities.second.Prize)
	 */
	@Override
	public void delete(Prize entity) {
		prizeCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Prize> entities) {
		prizeCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Prize> save(Iterable<Prize> entities) {
		return prizeCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#save(gr.ekt.cerif.entities.second.Prize)
	 */
	@Override
	public Prize save(Prize entity) {
		return prizeCrudRepository.save(entity);
	}

}
