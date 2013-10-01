package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Measurement;

/**
 * A repository for links between resultPublications and measurements.
 * 
 */
public interface LinkResultPublicationMeasurementRepository {

	public void delete(ResultPublication_Measurement entity); 
	
	public void delete(Iterable<ResultPublication_Measurement> entities); 

	public Iterable<ResultPublication_Measurement> save(Iterable<ResultPublication_Measurement> entities); 
	
	public ResultPublication_Measurement save(ResultPublication_Measurement entity);
	
}
