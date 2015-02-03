package gr.ekt.cerif.services.link.indicator;

import java.util.List;

import gr.ekt.cerif.entities.link.Indicator_Class;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between indicators and classes.
 * 
 */
public interface LinkIndicatorClassRepository {

	public void delete(Indicator_Class entity); 
	
	public void delete(Iterable<Indicator_Class> entities); 

	public Iterable<Indicator_Class> save(Iterable<Indicator_Class> entities); 
	
	public Indicator_Class save(Indicator_Class entity);
	
	List<Indicator_Class> findByTheClass(Class theClass);

	List<Indicator_Class> findByIndicator(Indicator indicator);
}
