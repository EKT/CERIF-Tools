package gr.ekt.cerif.services.link.prize;

import gr.ekt.cerif.entities.link.Prize_Class;

/**
 * A repository for links between facilities and classes.
 * 
 */
public interface LinkPrizeClassRepository {

	public void delete(Prize_Class entity); 
	
	public void delete(Iterable<Prize_Class> entities); 

	public Iterable<Prize_Class> save(Iterable<Prize_Class> entities); 
	
	public Prize_Class save(Prize_Class entity);
	
}
