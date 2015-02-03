package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreAudience;

/**
 * A repository for dublin core audience.
 * 
 */
@Deprecated
public interface DublinCoreAudienceRepository {

	public void delete(DublinCoreAudience entity); 
	
	public void delete(Iterable<DublinCoreAudience> entities); 

	public Iterable<DublinCoreAudience> save(Iterable<DublinCoreAudience> entities); 
	
	public DublinCoreAudience save(DublinCoreAudience entity);
}

