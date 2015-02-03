/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class FundingKeywordRepositoryImpl implements FundingKeywordRepository {

	private static final Logger log = LoggerFactory.getLogger(FundingKeywordRepositoryImpl.class);
	
	@Autowired
	private FundingKeywordCrudRepository fundingKeywordCrudRepository;
	
	@Override
	public void delete(FundingKeyword entity) {
		fundingKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<FundingKeyword> entities) {
		fundingKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FundingKeyword> save(Iterable<FundingKeyword> entities) {
		return fundingKeywordCrudRepository.save(entities);
	}

	@Override
	public FundingKeyword save(FundingKeyword entity) {
		return fundingKeywordCrudRepository.save(entity);
	}

	@Override
	public List<FundingKeyword> findByFunding(Funding funding) {
		return fundingKeywordCrudRepository.findByFunding(funding);
	}

}
