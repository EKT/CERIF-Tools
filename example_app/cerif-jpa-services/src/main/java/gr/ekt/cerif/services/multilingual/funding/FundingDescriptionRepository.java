/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingDescription;

/**
 * @author bonisv
 *
 */
public interface FundingDescriptionRepository {
	
	FundingDescription findByDescription(String descr);
	
	public void delete(FundingDescription entity); 
	
	public void delete(Iterable<FundingDescription> entities); 

	public Iterable<FundingDescription> save(Iterable<FundingDescription> entities); 
	
	public FundingDescription save(FundingDescription entity);
}
