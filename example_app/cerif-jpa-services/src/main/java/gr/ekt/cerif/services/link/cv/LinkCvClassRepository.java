package gr.ekt.cerif.services.link.cv;

import gr.ekt.cerif.entities.link.Cv_Class;

/**
 * A repository for links between cvs and classes.
 * 
 */
public interface LinkCvClassRepository {

	public void delete(Cv_Class entity); 
	
	public void delete(Iterable<Cv_Class> entities); 

	public Iterable<Cv_Class> save(Iterable<Cv_Class> entities); 
	
	public Cv_Class save(Cv_Class entity);
	
}
