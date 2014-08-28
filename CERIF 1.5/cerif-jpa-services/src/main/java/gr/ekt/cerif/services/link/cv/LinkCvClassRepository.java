package gr.ekt.cerif.services.link.cv;

import java.util.List;

import gr.ekt.cerif.entities.link.Cv_Class;
import gr.ekt.cerif.entities.second.CV;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between cvs and classes.
 * 
 */
public interface LinkCvClassRepository {

	public void delete(Cv_Class entity); 
	
	public void delete(Iterable<Cv_Class> entities); 

	public Iterable<Cv_Class> save(Iterable<Cv_Class> entities); 
	
	public Cv_Class save(Cv_Class entity);
	
	List<Cv_Class> findByCv(CV cv);
	
	List<Cv_Class> findBytheClass(Class theClass);
	
}
