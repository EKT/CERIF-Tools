package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Class;


/**
 * A repository for links between resultProducts and classs.
 * 
 */
public interface LinkResultProductClassRepository {

	public void delete(ResultProduct_Class entity); 
	
	public void delete(Iterable<ResultProduct_Class> entities); 

	public Iterable<ResultProduct_Class> save(Iterable<ResultProduct_Class> entities); 
	
	public ResultProduct_Class save(ResultProduct_Class entity);	
}
