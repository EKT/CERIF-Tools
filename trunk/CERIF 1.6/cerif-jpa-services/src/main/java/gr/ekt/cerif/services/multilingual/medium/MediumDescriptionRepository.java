/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

import java.util.List;

import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.features.multilingual.MediumDescription;

/**
 * @author bonisv
 *
 */
public interface MediumDescriptionRepository {
	
	public void delete(MediumDescription entity); 
	
	public void delete(Iterable<MediumDescription> entities); 

	public Iterable<MediumDescription> save(Iterable<MediumDescription> entities); 
	
	public MediumDescription save(MediumDescription entity);
	
	List<MediumDescription> findByMedium(Medium medium);

}
