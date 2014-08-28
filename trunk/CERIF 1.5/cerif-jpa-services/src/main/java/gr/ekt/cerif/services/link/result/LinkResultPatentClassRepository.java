package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_Class;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between resultPatents and classes.
 * 
 */
public interface LinkResultPatentClassRepository {

	public void delete(ResultPatent_Class entity); 
	
	public void delete(Iterable<ResultPatent_Class> entities); 

	public Iterable<ResultPatent_Class> save(Iterable<ResultPatent_Class> entities); 
	
	public ResultPatent_Class save(ResultPatent_Class entity);
	
	List<ResultPatent_Class> findByResultPatent(ResultPatent resultPatent);
	
	List<ResultPatent_Class> findBytheClass(Class theClass);
	
}
