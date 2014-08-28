package gr.ekt.cerif.services.link.qualification;

import java.util.List;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between qualifications and classes.
 * 
 */
public interface LinkQualificationClassRepository {

	public void delete(Qualification_Class entity); 
	
	public void delete(Iterable<Qualification_Class> entities); 

	public Iterable<Qualification_Class> save(Iterable<Qualification_Class> entities); 
	
	public Qualification_Class save(Qualification_Class entity);
	
	List<Qualification_Class> findByQualification(Qualification qualification);
	
	List<Qualification_Class> findBytheClass(Class theClass);
	
}
