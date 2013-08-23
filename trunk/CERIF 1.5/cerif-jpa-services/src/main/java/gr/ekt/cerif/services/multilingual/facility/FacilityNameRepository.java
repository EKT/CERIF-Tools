
package gr.ekt.cerif.services.multilingual.facility;

import gr.ekt.cerif.features.multilingual.FacilityName;


/**
 * A repository for FacilityName.
 * 
 */
public interface FacilityNameRepository {
	
	public void delete(FacilityName entity); 
	
	public void delete(Iterable<FacilityName> entities); 

	public Iterable<FacilityName> save(Iterable<FacilityName> entities); 
	
	public FacilityName save(FacilityName entity);
		
}
