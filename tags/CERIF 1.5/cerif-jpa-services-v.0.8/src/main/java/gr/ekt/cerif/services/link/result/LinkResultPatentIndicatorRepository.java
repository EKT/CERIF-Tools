package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_Indicator;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Indicator;
/**
 * A repository for links between resultPatents and indicators.
 * 
 */
public interface LinkResultPatentIndicatorRepository {

	public void delete(ResultPatent_Indicator entity); 
	
	public void delete(Iterable<ResultPatent_Indicator> entities); 

	public Iterable<ResultPatent_Indicator> save(Iterable<ResultPatent_Indicator> entities); 
	
	public ResultPatent_Indicator save(ResultPatent_Indicator entity);
	
	List<ResultPatent_Indicator> findByIndicator(Indicator indicator);
	
	List<ResultPatent_Indicator> findByResultPatent(ResultPatent resultPatent);
	
}
