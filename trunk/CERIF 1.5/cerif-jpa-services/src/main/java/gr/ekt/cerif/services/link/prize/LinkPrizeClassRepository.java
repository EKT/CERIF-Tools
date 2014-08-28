package gr.ekt.cerif.services.link.prize;

import java.util.List;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

/**
 * A repository for links between facilities and classes.
 * 
 */
public interface LinkPrizeClassRepository {

	public void delete(Prize_Class entity); 
	
	public void delete(Iterable<Prize_Class> entities); 

	public Iterable<Prize_Class> save(Iterable<Prize_Class> entities); 
	
	public Prize_Class save(Prize_Class entity);
	
	List<Prize_Class> findByPrize(Prize prize);
	
	List<Prize_Class> findBytheClass(Class theClass);
	
}
