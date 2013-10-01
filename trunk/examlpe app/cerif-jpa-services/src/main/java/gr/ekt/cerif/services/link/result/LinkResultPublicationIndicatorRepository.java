package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Indicator;

/**
 * A repository for links between resultPublications and indicators.
 * 
 */
public interface LinkResultPublicationIndicatorRepository {

	public void delete(ResultPublication_Indicator entity); 
	
	public void delete(Iterable<ResultPublication_Indicator> entities); 

	public Iterable<ResultPublication_Indicator> save(Iterable<ResultPublication_Indicator> entities); 
	
	public ResultPublication_Indicator save(ResultPublication_Indicator entity);
	
}
