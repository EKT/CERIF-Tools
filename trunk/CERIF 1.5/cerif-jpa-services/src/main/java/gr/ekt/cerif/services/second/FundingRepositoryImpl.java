/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Funding;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


/**
 * @author bonisv
 *
 */
@Component
public class FundingRepositoryImpl implements FundingRepository {

	private static final Logger log = LoggerFactory.getLogger(FundingRepositoryImpl.class);

	@Autowired
	private FundingCrudRepository fundingCrudRepository;
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#delete(gr.ekt.cerif.entities.second.Funding)
	 */
	@Override
	public void delete(Funding entity) {
		fundingCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Funding> entities) {
		fundingCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Funding> save(Iterable<Funding> entities) {
		return fundingCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#save(gr.ekt.cerif.entities.second.Funding)
	 */
	@Override
	public Funding save(Funding entity) {
		return fundingCrudRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findByAcronym(java.lang.String)
	 */
	@Override
	public Funding findByAcronym(String acronym) {
		return fundingCrudRepository.findByAcronym(acronym);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findById(java.lang.Long)
	 */
	@Override
	public Funding findById(Long id) {
		return fundingCrudRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.FundingRepository#findAll()
	 */
	@Override
	public List<Funding> findAll() {
		return fundingCrudRepository.findAll();
	}

	@Override
	public Page<Funding> findAll(Pageable page) {
		return fundingCrudRepository.findAll(page);
	}

}
