package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;

/**
 * A repository for links between resultProducts and measurements.
 * 
 */
public interface LinkResultProductMeasurementRepository {

	public void delete(ResultProduct_Measurement entity); 
	
	public void delete(Iterable<ResultProduct_Measurement> entities); 

	public Iterable<ResultProduct_Measurement> save(Iterable<ResultProduct_Measurement> entities); 
	
	public ResultProduct_Measurement save(ResultProduct_Measurement entity);
	
}
