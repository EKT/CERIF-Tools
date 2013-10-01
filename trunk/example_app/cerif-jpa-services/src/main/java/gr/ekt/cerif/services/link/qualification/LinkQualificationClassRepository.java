package gr.ekt.cerif.services.link.qualification;

import gr.ekt.cerif.entities.link.Qualification_Class;

/**
 * A repository for links between qualifications and classes.
 * 
 */
public interface LinkQualificationClassRepository {

	public void delete(Qualification_Class entity); 
	
	public void delete(Iterable<Qualification_Class> entities); 

	public Iterable<Qualification_Class> save(Iterable<Qualification_Class> entities); 
	
	public Qualification_Class save(Qualification_Class entity);
	
}
