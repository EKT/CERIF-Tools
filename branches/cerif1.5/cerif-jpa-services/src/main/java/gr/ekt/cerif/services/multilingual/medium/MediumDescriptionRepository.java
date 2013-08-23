/**
 * 
 */
package gr.ekt.cerif.services.multilingual.medium;

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

}
