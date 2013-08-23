package gr.ekt.cerif.services.link.indicator;

import gr.ekt.cerif.entities.link.Indicator_Class;

/**
 * A repository for links between indicators and classes.
 * 
 */
public interface LinkIndicatorClassRepository {

	public void delete(Indicator_Class entity); 
	
	public void delete(Iterable<Indicator_Class> entities); 

	public Iterable<Indicator_Class> save(Iterable<Indicator_Class> entities); 
	
	public Indicator_Class save(Indicator_Class entity);
	
}
