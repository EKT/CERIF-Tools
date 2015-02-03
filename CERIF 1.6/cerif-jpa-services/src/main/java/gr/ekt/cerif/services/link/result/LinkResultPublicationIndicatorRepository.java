package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.Indicator;

/**
 * A repository for links between resultPublications and indicators.
 * 
 */
public interface LinkResultPublicationIndicatorRepository {

	public void delete(ResultPublication_Indicator entity); 
	
	public void delete(Iterable<ResultPublication_Indicator> entities); 

	public Iterable<ResultPublication_Indicator> save(Iterable<ResultPublication_Indicator> entities); 
	
	public ResultPublication_Indicator save(ResultPublication_Indicator entity);
	
	List<ResultPublication_Indicator> findByIndicator(Indicator indicator);
	
	List<ResultPublication_Indicator> findByResultPublication(ResultPublication resultPublication);
	
}
