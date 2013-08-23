package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
/**
 * A repository for links between resultPatents and indicators.
 * 
 */
public interface LinkResultPatentIndicatorRepository {

	public void delete(ResultPatent_Indicator entity); 
	
	public void delete(Iterable<ResultPatent_Indicator> entities); 

	public Iterable<ResultPatent_Indicator> save(Iterable<ResultPatent_Indicator> entities); 
	
	public ResultPatent_Indicator save(ResultPatent_Indicator entity);
	
}
