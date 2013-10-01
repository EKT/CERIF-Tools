package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreProvenance;

/**
 * A repository for dublin core contributor.
 * 
 */
public interface DublinCoreProvenanceRepository {

	public void delete(DublinCoreProvenance entity); 
	
	public void delete(Iterable<DublinCoreProvenance> entities); 

	public Iterable<DublinCoreProvenance> save(Iterable<DublinCoreProvenance> entities); 
	
	public DublinCoreProvenance save(DublinCoreProvenance entity);
}

