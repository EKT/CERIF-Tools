package gr.ekt.cerif.services.link.facility;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

/**
 * A repository for links between facilities and classes.
 * 
 */

public interface LinkFacilityClassRepository {

	List<Facility_Class> findByTheClass(Class theClass);
	
	List<Facility_Class> findByFacility(Facility facility);
	
	public Facility_Class save(Facility_Class entity);
	
	public Iterable<? extends Facility_Class> save(Iterable<? extends Facility_Class> entities);
	
	public void delete(Facility_Class entity);
	
	public void delete(Iterable<Facility_Class> entities);
	
	
}
