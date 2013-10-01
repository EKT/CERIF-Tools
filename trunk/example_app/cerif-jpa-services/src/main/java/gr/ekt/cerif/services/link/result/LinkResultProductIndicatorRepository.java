package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;

/**
 * A repository for links between resultProducts and indicators.
 * 
 */
public interface LinkResultProductIndicatorRepository {

	public void delete(ResultProduct_Indicator entity); 
	
	public void delete(Iterable<ResultProduct_Indicator> entities); 

	public Iterable<ResultProduct_Indicator> save(Iterable<ResultProduct_Indicator> entities); 
	
	public ResultProduct_Indicator save(ResultProduct_Indicator entity);
	
}
