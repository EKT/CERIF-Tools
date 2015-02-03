package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreResourceType;

/**
 * A repository for dublin core resource type.
 * 
 */
@Deprecated
public interface DublinCoreResourceTypeRepository {

	public void delete(DublinCoreResourceType entity); 
	
	public void delete(Iterable<DublinCoreResourceType> entities); 

	public Iterable<DublinCoreResourceType> save(Iterable<DublinCoreResourceType> entities); 
	
	public DublinCoreResourceType save(DublinCoreResourceType entity);
}

