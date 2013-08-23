/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import gr.ekt.cerif.features.multilingual.FundingKeyword;

/**
 * @author bonisv
 *
 */
public interface FundingKeywordRepository {

	public void delete(FundingKeyword entity); 
	
	public void delete(Iterable<FundingKeyword> entities); 

	public Iterable<FundingKeyword> save(Iterable<FundingKeyword> entities); 
	
	public FundingKeyword save(FundingKeyword entity);
}
