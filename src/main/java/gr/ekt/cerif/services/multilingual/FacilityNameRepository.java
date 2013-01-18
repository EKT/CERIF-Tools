
package gr.ekt.cerif.services.multilingual;

import gr.ekt.cerif.features.multilingual.FacilityName;


/**
 * A repository for FacilityName.
 * 
 */
public interface FacilityNameRepository {
	
	public FacilityName save(FacilityName entity);
	
	public Iterable<? extends FacilityName> save(Iterable<? extends FacilityName> entities);
	
	public void delete(FacilityName entity);
		
}
