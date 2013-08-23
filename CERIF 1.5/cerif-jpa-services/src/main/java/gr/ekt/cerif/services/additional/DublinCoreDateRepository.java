package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreDate;

/**
 * A repository for dublin core date.
 * 
 */
public interface DublinCoreDateRepository {

	public void delete(DublinCoreDate entity); 
	
	public void delete(Iterable<DublinCoreDate> entities); 

	public Iterable<DublinCoreDate> save(Iterable<DublinCoreDate> entities); 
	
	public DublinCoreDate save(DublinCoreDate entity);
}

