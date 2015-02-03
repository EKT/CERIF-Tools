package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreDescription;

/**
 * A repository for dublin core contributor.
 * 
 */
@Deprecated
public interface DublinCoreDescriptionRepository {

	public void delete(DublinCoreDescription entity); 
	
	public void delete(Iterable<DublinCoreDescription> entities); 

	public Iterable<DublinCoreDescription> save(Iterable<DublinCoreDescription> entities); 
	
	public DublinCoreDescription save(DublinCoreDescription entity);
}

