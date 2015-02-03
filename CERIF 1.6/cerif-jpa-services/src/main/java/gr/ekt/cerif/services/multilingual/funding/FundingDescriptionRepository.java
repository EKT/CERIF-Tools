/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import java.util.List;

import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.features.multilingual.FundingDescription;

/**
 * @author bonisv
 *
 */
public interface FundingDescriptionRepository {
	
	FundingDescription findByDescription(String descr);
	
	List<FundingDescription> findByFunding(Funding funding);
	
	public void delete(FundingDescription entity); 
	
	public void delete(Iterable<FundingDescription> entities); 

	public Iterable<FundingDescription> save(Iterable<FundingDescription> entities); 
	
	public FundingDescription save(FundingDescription entity);

}
