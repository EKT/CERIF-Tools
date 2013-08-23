package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between facilities and facilities.
 * 
 */
public interface LinkFacilityFacilityRepository {
	
	List<Facility_Facility> findByTheClass(Class theClass);
	
	public Facility_Facility save(Facility_Facility entity);
	
	public Iterable<? extends Facility_Facility> save(Iterable<? extends Facility_Facility> entities);
	
	public void delete(Facility_Facility entity);
	
	public void delete(Iterable<Facility_Facility> entities);
	
}
