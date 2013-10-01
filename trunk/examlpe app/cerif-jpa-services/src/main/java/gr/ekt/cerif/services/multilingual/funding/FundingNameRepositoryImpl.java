/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.multilingual.FundingName;

/**
 * @author bonisv
 *
 */
@Component
public class FundingNameRepositoryImpl implements FundingNameRepository {

	private static final Logger log = LoggerFactory.getLogger(FundingNameRepositoryImpl.class);
	
	@Autowired
	private FundingNameCrudRepository fundingNameCrudRepository;
	
	@Override
	public void delete(FundingName entity) {
		fundingNameCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<FundingName> entities) {
		fundingNameCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<FundingName> save(Iterable<FundingName> entities) {
		return fundingNameCrudRepository.save(entities);
	}

	@Override
	public FundingName save(FundingName entity) {
		return fundingNameCrudRepository.save(entity);
	}

	@Override
	public FundingName findByName(String title) {
		return fundingNameCrudRepository.findByName(title);
	}

}
