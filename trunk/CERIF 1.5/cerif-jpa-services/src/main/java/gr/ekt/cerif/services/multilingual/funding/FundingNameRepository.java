/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingName;

/**
 * @author bonisv
 *
 */
public interface FundingNameRepository {

	public void delete(FundingName entity); 
	
	public void delete(Iterable<FundingName> entities); 

	public Iterable<FundingName> save(Iterable<FundingName> entities); 
	
	public FundingName save(FundingName entity);
	
	FundingName findByName(String title);
}
