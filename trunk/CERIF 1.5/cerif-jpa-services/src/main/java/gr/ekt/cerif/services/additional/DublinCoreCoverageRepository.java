package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreCoverage;

/**
 * A repository for dublin core coverage.
 * 
 */
public interface DublinCoreCoverageRepository {

	public void delete(DublinCoreCoverage entity); 
	
	public void delete(Iterable<DublinCoreCoverage> entities); 

	public Iterable<DublinCoreCoverage> save(Iterable<DublinCoreCoverage> entities); 
	
	public DublinCoreCoverage save(DublinCoreCoverage entity);
}

