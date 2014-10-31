package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreResourceIdentifier;

/**
 * A repository for dublin core resource identifier.
 * 
 */
public interface DublinCoreResourceIdentifierRepository {

	public void delete(DublinCoreResourceIdentifier entity); 
	
	public void delete(Iterable<DublinCoreResourceIdentifier> entities); 

	public Iterable<DublinCoreResourceIdentifier> save(Iterable<DublinCoreResourceIdentifier> entities); 
	
	public DublinCoreResourceIdentifier save(DublinCoreResourceIdentifier entity);
}

