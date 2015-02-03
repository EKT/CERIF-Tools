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
import gr.ekt.cerif.features.multilingual.FundingDescription;
import gr.ekt.cerif.services.base.ProjectRepositoryImpl;

/**
 * @author bonisv
 *
 */
@Component
public class FundingDescriptionRepositoryImpl implements FundingDescriptionRepository {

	private static final Logger log = LoggerFactory.getLogger(FundingDescriptionRepositoryImpl.class);
	
	@Autowired
	private FundingDescriptionCrudRepository fundingDescriptionCrudRepository;
	
	@Override
	public FundingDescription findByDescription(String descr) {
		return fundingDescriptionCrudRepository.findByDescription(descr);
	}

	@Override
	public void delete(FundingDescription entity) {
		fundingDescriptionCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<FundingDescription> entities) {
		fundingDescriptionCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FundingDescription> save(Iterable<FundingDescription> entities) {
		return fundingDescriptionCrudRepository.save(entities);
	}

	@Override
	public FundingDescription save(FundingDescription entity) {
		return fundingDescriptionCrudRepository.save(entity);
	}

	@Override
	public List<FundingDescription> findByFunding(Funding funding) {
		return fundingDescriptionCrudRepository.findByFunding(funding);
	}

}
