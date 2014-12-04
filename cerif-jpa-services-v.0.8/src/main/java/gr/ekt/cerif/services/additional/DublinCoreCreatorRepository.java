package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreCreator;

/**
 * A repository for dublin core creator.
 * 
 */
public interface DublinCoreCreatorRepository {

	public void delete(DublinCoreCreator entity); 
	
	public void delete(Iterable<DublinCoreCreator> entities); 

	public Iterable<DublinCoreCreator> save(Iterable<DublinCoreCreator> entities); 
	
	public DublinCoreCreator save(DublinCoreCreator entity);
}

