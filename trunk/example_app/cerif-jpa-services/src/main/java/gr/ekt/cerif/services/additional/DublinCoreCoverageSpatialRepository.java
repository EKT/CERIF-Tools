package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreCoverageSpatial;

/**
 * A repository for dublin core coverage spatial.
 * 
 */
public interface DublinCoreCoverageSpatialRepository {

	public void delete(DublinCoreCoverageSpatial entity); 
	
	public void delete(Iterable<DublinCoreCoverageSpatial> entities); 

	public Iterable<DublinCoreCoverageSpatial> save(Iterable<DublinCoreCoverageSpatial> entities); 
	
	public DublinCoreCoverageSpatial save(DublinCoreCoverageSpatial entity);
}

