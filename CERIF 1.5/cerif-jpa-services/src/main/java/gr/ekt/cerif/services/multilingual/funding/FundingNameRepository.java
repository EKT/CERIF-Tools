/**
 * 
 */
package gr.ekt.cerif.services.multilingual.funding;

import java.util.List;

import gr.ekt.cerif.entities.second.Funding;
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
	
	List<FundingName> findByFunding(Funding funding);
}
