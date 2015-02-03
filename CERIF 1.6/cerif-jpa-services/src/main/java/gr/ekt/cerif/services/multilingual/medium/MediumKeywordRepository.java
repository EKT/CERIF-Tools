/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumKeyword;

/**
 * @author bonisv
 *
 */
public interface MediumKeywordRepository {
	
	public void delete(MediumKeyword entity); 
	
	public void delete(Iterable<MediumKeyword> entities); 

	public Iterable<MediumKeyword> save(Iterable<MediumKeyword> entities); 
	
	public MediumKeyword save(MediumKeyword entity);
	
	List<MediumKeyword> findByMedium(Medium medium);

}
