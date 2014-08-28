package gr.ekt.cerif.services.link.result;

import java.util.List;

import gr.ekt.cerif.entities.link.result.ResultPatent_Measurement;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between resultPatents and measurements.
 * 
 */
public interface LinkResultPatentMeasurementRepository {

	public void delete(ResultPatent_Measurement entity); 
	
	public void delete(Iterable<ResultPatent_Measurement> entities); 

	public Iterable<ResultPatent_Measurement> save(Iterable<ResultPatent_Measurement> entities); 
	
	public ResultPatent_Measurement save(ResultPatent_Measurement entity);
	
	List<ResultPatent_Measurement> findByMeasurement(Measurement measurement);
	
	List<ResultPatent_Measurement> findByResultPatent(ResultPatent resultPatent);
	
}
