/**
 * 
 */
package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.features.multilingual.FacilityDescription;

/**
 * @author bonisv
 *
 */
public interface FacilityDescriptionRepository {

	public void delete(FacilityDescription entity); 
	
	public void delete(Iterable<FacilityDescription> entities); 

	public Iterable<FacilityDescription> save(Iterable<FacilityDescription> entities); 
	
	public FacilityDescription save(FacilityDescription entity);
}
