package gr.ekt.cerif.services.link.funding;

import java.util.List;

import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;

/**
 * A repository for links between fundings and measurements.
 * 
 */
public interface LinkFundingMeasurementRepository {

	public void delete(Funding_Measurement entity); 
	
	public void delete(Iterable<Funding_Measurement> entities); 

	public Iterable<Funding_Measurement> save(Iterable<Funding_Measurement> entities); 
	
	public Funding_Measurement save(Funding_Measurement entity);
	
	List<Funding_Measurement> findByFunding(Funding funding);
	
	List<Funding_Measurement> findByMeasurement(Measurement measurement);
	
}
