package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreCoverageTemporal;

/**
 * A repository for dublin core coverage temporal.
 * 
 */
public interface DublinCoreCoverageTemporalRepository {

	public void delete(DublinCoreCoverageTemporal entity); 
	
	public void delete(Iterable<DublinCoreCoverageTemporal> entities); 

	public Iterable<DublinCoreCoverageTemporal> save(Iterable<DublinCoreCoverageTemporal> entities); 
	
	public DublinCoreCoverageTemporal save(DublinCoreCoverageTemporal entity);
}

