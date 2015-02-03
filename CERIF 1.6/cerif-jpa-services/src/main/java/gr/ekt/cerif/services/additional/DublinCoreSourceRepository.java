package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreSource;

/**
 * A repository for dublin core source.
 * 
 */
@Deprecated
public interface DublinCoreSourceRepository {

	public void delete(DublinCoreSource entity); 
	
	public void delete(Iterable<DublinCoreSource> entities); 

	public Iterable<DublinCoreSource> save(Iterable<DublinCoreSource> entities); 
	
	public DublinCoreSource save(DublinCoreSource entity);
}

